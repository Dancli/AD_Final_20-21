package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MedicamentoModel;
import com.example.demo.service.TiendaService;

@RestController
@RequestMapping("/api")
public class TiendaRestController {
	
	@Autowired
	@Qualifier("tiendaService")
	private TiendaService tiendaService;
	
	@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8100", "https://clinicasur.herokuapp.com"})
	@GetMapping({"/list"})
	public ResponseEntity<?> list() {
		List<MedicamentoModel> medicamentos = tiendaService.listAllMedicamentos();
		
		if(medicamentos.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(medicamentos);
		}
	}
	
}
