package com.example.demo.controller;


import com.example.demo.entity.Medico;
import com.example.demo.model.CitaModel;
import com.example.demo.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller

@RequestMapping("/citas")
public class CitaController {

    private static final String VISTA = "PedirCita";

    @Autowired
    @Qualifier("citaService")
    private CitaService citaService;

    public CitaController() {
    }
    @GetMapping({"/citasPaciente"})
    public String cita(Model model) {
        return VISTA;
    }


    // Nos redirige al formulario de creación de cita
    @GetMapping(value = {"/altaCita"})
    public String altaCita(@RequestParam(name="idMedico",required = false) Integer idMedico, Model model){
        CitaModel citaModel=new CitaModel();
        Medico medico=new Medico();
        medico.setIdMedico(idMedico);

        model.addAttribute("cita", new CitaModel());
        model.addAttribute("cita",citaModel.getMedico().getIdMedico());
        return VISTA;
    }


    @PostMapping("/saveCita")
    public String saveCita(
            @Valid @ModelAttribute("cita") CitaModel citaModel){
        citaService.saveCita(citaModel);
        //userService.registrarPaciente(pacienteModel);
        //return mav;
        return "redirect:/pacientes/relacion";
    }



}
