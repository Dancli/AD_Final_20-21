package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.configuration.CompraPDFExporter;
import com.example.demo.entity.Compra;
import com.example.demo.model.MedicamentoModel;
import com.example.demo.service.CarritoService;
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
	
	public CarritoController() {
		
	}
	
	@GetMapping({"/"})
	public String carrito(Model model) {
		
		return VIEW;
	}
	
	@PostMapping({"/addToCart"})
	public String addToCart(
			@Valid @ModelAttribute("medicamento") MedicamentoModel medicamentoModel,
			BindingResult bindingResult,
			RedirectAttributes flash,
			Model model
	) {
		if(medicamentoModel.getReceta() == null) {
			medicamentoModel.setReceta("0");
		}
		tiendaService.saveMedicamento(medicamentoModel);
		
		
		
		return "redirect:/tienda/pagina/1";
	}
	
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
	
}
