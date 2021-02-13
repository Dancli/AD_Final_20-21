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

@CrossOrigin(origins = "http://localhost:8080", methods={RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class TiendaRestController {
	
	@Autowired
	@Qualifier("tiendaService")
	private TiendaService tiendaService;
	
	
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
