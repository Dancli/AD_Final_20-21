package com.example.demo.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Paciente;
import com.example.demo.model.CompraModel;
import com.example.demo.model.MedicamentoModel;
import com.example.demo.service.CarritoService;
import com.example.demo.service.PacienteService;
import com.example.demo.service.TiendaService;

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
		/*
		Set<Medicamento> medicamentos = compra.getMedicamentos().stream().collect(Collectors.toCollection(
				() -> new TreeSet<Medicamento>((m1, m2) -> m1.getNombre().compareTo(m2.getNombre()))
		));
		*/
		model.addAttribute("precio", compra.getPrecio());
		model.addAttribute("medicamentos", compra.getMedicamentos());
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
				CompraModel compraModel = new CompraModel();
				compraModel.setFecha(new Date());
				float precio = medicamentoModel.getPrecio();
				compraModel.setPrecio(precio);
				UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String username = userDetails.getUsername();
				Paciente paciente = pacienteService.findPacienteByUsername(username);
				compraModel.setPaciente(paciente);
				Set<Medicamento> medicamentos = new HashSet<Medicamento>();
				medicamentos.add(tiendaService.transformModelToEntity(medicamentoModel));
				compraModel.setMedicamentos(medicamentos);
				session.setAttribute("compra", compraModel);
				System.out.println(session.getAttribute("compra"));
			} else {
				System.out.println("No puedes añadir más de eso.");
				// Aquí iría un flash messenger.
			}
		} else {
			if(checkStock(compra, medicamentoModel, medicamentoModel.getStock()) == true) {
				session.setAttribute("compra", compra);
				compra.setFecha(new Date());
				compra.setPrecio(compra.getPrecio() + medicamentoModel.getPrecio());
				Set<Medicamento> medicamentos = compra.getMedicamentos();
				medicamentos.add(tiendaService.transformModelToEntity(medicamentoModel));
				compra.setMedicamentos(medicamentos);
				System.out.println(session.getAttribute("compra"));
			} else {
				System.out.println("No puedes añadir más de eso.");
				// Aquí iría un flash messenger.
			}
		}
		return "redirect:/tienda/pagina/1";
	}
	
	// Este método comprobará si quedan o no unidades disponibles de un determinado medicamento.
	public boolean checkStock(CompraModel compra, MedicamentoModel medicamentoModel, int medicamentoStock) {
		int count = (int) compra.getMedicamentos().stream().filter(
			m -> m.getNombre().equals(medicamentoModel.getNombre())
		).count();
		if(count == medicamentoStock) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
	@GetMapping("/factura/pdf")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=compra_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		Compra compra = carritoService.findCompraByIdPaciente(0);
		
		CompraPDFExporter exporter = new CompraPDFExporter(compra);
		exporter.export(response);
	}
	*/
	
}
