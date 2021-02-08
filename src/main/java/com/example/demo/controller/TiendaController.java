package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Medicamento;
import com.example.demo.service.TiendaService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
	
	private static final String VIEW = "tienda";
	
	@Autowired
	@Qualifier("tiendaService")
	private TiendaService tiendaService;
	
	public TiendaController() {
		
	}
	
	@GetMapping({"/"})
	public String catalogo(Model model) {
		return mostrarPagina(1, null, model);
	}
	
	@GetMapping({"/pagina/{pageNumber}"})
	public String mostrarPagina(@PathVariable(value="pageNumber") int pageNumber, @Param(value="keyword") String keyword, Model model) {
		int pageSize = 3;
		Page<Medicamento> pagina;
		if (keyword == null) {
			pagina = tiendaService.paginateMedicamentos(pageNumber, pageSize);
		} else {
			pagina = tiendaService.findAllByKeyword(pageNumber, pageSize, keyword);
		}
		
		List<Medicamento> medicamentos = pagina.getContent();
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalPages", pagina.getTotalPages());
		model.addAttribute("totalElements", pagina.getTotalElements());
		model.addAttribute("medicamentos", medicamentos);
		model.addAttribute("keyword", keyword);
		
		return VIEW;
	}
}
