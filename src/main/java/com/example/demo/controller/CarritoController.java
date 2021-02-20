package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.configuration.CompraPDFExporter;
import com.example.demo.entity.Compra;
import com.example.demo.entity.ItemCompra;
import com.example.demo.entity.Paciente;
import com.example.demo.model.CompraModel;
import com.example.demo.model.MedicamentoModel;
import com.example.demo.service.CarritoService;
import com.example.demo.service.PacienteService;
import com.example.demo.service.TiendaService;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
private static final String VIEW = "carrito";
	
	@Autowired
	@Qualifier("carritoService")
	private CarritoService carritoService;
	
	@Autowired
	@Qualifier("tiendaService")
	private TiendaService tiendaService;
	
	@Autowired
	@Qualifier("pacienteServiceImpl")
	private PacienteService pacienteService;
	
	@Autowired
	private HttpSession session;
	
	public CarritoController() {
		
	}
	
	@GetMapping({"/listado"})
	public String carrito(Model model) {
		
		CompraModel compra = (CompraModel) session.getAttribute("compra");
		if(compra == null) {
			model.addAttribute("precio", 0);
			model.addAttribute("medicamentos", null);
		} else {
			model.addAttribute("precio", compra.getPrecio());
			model.addAttribute("items", compra.getItems());
		}

		return VIEW;
	}

	@PostMapping({"/addToCart"})
	public String addToCart(
			@Valid @ModelAttribute("medicamento") MedicamentoModel medicamentoModel,
			BindingResult bindingResult,
			RedirectAttributes flash,
			Model model
	) {
		CompraModel compra = (CompraModel) session.getAttribute("compra");

		if(compra == null) {
			if(medicamentoModel.getStock() >= 0) {
				// Se construye la primera compra.
				CompraModel compraModel = new CompraModel();
				compraModel.setFecha(new Date());
				compraModel.setPrecio(medicamentoModel.getPrecio());
				UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String username = userDetails.getUsername();
				Paciente paciente = pacienteService.findPacienteByUsername(username);
				compraModel.setPaciente(paciente);
				// Se construye el primer objeto de la compra.
				Set<ItemCompra> items = new HashSet<ItemCompra>();
				ItemCompra firstItem = new ItemCompra();
				firstItem.setCompra(carritoService.transformModelToEntity(compraModel));
				firstItem.setMedicamento(tiendaService.transformModelToEntity(medicamentoModel));
				items.add(firstItem);
				compraModel.setItems(items);
				session.setAttribute("compra", compraModel);
				System.out.println(session.getAttribute("compra"));
			} else {
				System.out.println("Ha excedido el límite de medicamentos que puede añadir al carrito.");
			}
		} else {
			if(checkStock(compra, medicamentoModel, medicamentoModel.getStock()) == true) {
				compra.setFecha(new Date());
				compra.setPrecio(compra.getPrecio() + medicamentoModel.getPrecio());
				compra.setPaciente(compra.getPaciente());
				Set<ItemCompra> items = compra.getItems();
				ItemCompra item = new ItemCompra();
				item.setCompra(carritoService.transformModelToEntity(compra));
				item.setMedicamento(tiendaService.transformModelToEntity(medicamentoModel));
				items.add(item);
				compra.setItems(items);
				session.setAttribute("compra", compra);
				System.out.println(session.getAttribute("compra"));
			} else {
				System.out.println("Ha excedido el límite de medicamentos que puede añadir al carrito.");
			}
		}
		
		return "redirect:/tienda/pagina/1";
	}
	
	// Este método comprobará si quedan o no unidades disponibles de un determinado medicamento.
	public boolean checkStock(CompraModel compraModel, MedicamentoModel medicamentoModel, int medicamentoStock) {
		int count = (int) compraModel.getItems().stream().filter(
			i -> i.getMedicamento().getNombre().equals(medicamentoModel.getNombre())
		).count();
		if(count == medicamentoStock) {
			return false;
		} else {
			return true;
		}
	}
	
	@GetMapping({"/removeFromCart"})
	public String removeFromCart(@RequestParam(name="idMedicamento", required=true) Integer idMedicamento) {
		CompraModel compra = (CompraModel) session.getAttribute("compra");
		Set<ItemCompra> items = compra.getItems();
		for(ItemCompra item : items) {
			if(item.getMedicamento().getIdMedicamento() == idMedicamento) {
				compra.setPrecio(compra.getPrecio() - item.getMedicamento().getPrecio());
				items.remove(item);
				break;
			}
		}
		compra.setItems(items);
		
		return "redirect:/carrito/listado";
	}
	
	@GetMapping("/factura/pdf")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException {
		// Guarda la compra en la BD
		CompraModel compra = (CompraModel) session.getAttribute("compra");
		carritoService.saveCompra(compra);
		/*
		for (ItemCompra item : compra.getItems()) {
			itemService.saveItem(item);
			int itemsInCart = Collections.frequency(compra.getItems(), item);
			Medicamento medicamento = item.getMedicamento();
			int stock = medicamento.getStock();
			medicamento.setStock(stock - itemsInCart);
			tiendaService.saveMedicamento(tiendaService.transformEntityToModel(medicamento));
		}
		*/
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=factura_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		Compra compraEntity = carritoService.transformModelToEntity(compra);
		CompraPDFExporter exporter = new CompraPDFExporter(compraEntity);
		exporter.export(response);

		compra.setPrecio(0);
		Set<ItemCompra> clearItems = compra.getItems();
		clearItems.clear();
		compra.setItems(clearItems);
		session.setAttribute("compra", compra);

	}
	
}
