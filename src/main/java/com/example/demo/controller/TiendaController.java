package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Medicamento;
import com.example.demo.model.MedicamentoModel;
import com.example.demo.service.TiendaService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
	
	private static final String VIEW = "tienda";
	private static final String FORM = "formularioMedicamento";
	
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
	public String mostrarPagina(
			@PathVariable(value="pageNumber") int pageNumber, 
			@Param(value="keyword") String keyword, 
			Model model) {
		int pageSize = 3;
		Page<MedicamentoModel> pagina;
		if (keyword == null) {
			pagina = tiendaService.paginateMedicamentos(pageNumber, pageSize);
		} else {
			pagina = tiendaService.findAllByKeyword(pageNumber, pageSize, keyword);
		}
		
		List<MedicamentoModel> medicamentoModels = pagina.getContent();
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalPages", pagina.getTotalPages());
		model.addAttribute("totalElements", pagina.getTotalElements());
		model.addAttribute("medicamentos", medicamentoModels);
		model.addAttribute("keyword", keyword);
		
		return VIEW;
	}
	
	@GetMapping({"/addMedicamentoForm"})
	public String addMedicamentoForm(Model model) {	
		
		MedicamentoModel medicamentoModel = new MedicamentoModel();
		model.addAttribute("medicamento", medicamentoModel);
		model.addAttribute("medicamento", new MedicamentoModel());
		return FORM;
	}
	
	@GetMapping({"/editMedicamentoForm"})
	public String editMedicamentoForm(
			@RequestParam(name="idMedicamento", required=true) Integer idMedicamento, 
			Model model
	) {
		Medicamento medicamento = new Medicamento();
		medicamento = tiendaService.findMedicamentoById(idMedicamento);
		model.addAttribute("medicamento", medicamento);
		return FORM;
	}
	
	@PostMapping({"/save"})
	public String saveMedicamento(
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
	
	@GetMapping({"/delete"})
	public String deleteMedicamento(
		@RequestParam(name="idMedicamento", required=true) Integer idMedicamento
	) {
		tiendaService.removeMedicamento(idMedicamento);
		return "redirect:/tienda/pagina/1";
	}
}
