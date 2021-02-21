package com.example.demo.controller;


import com.example.demo.model.CitaModel;
import com.example.demo.model.PacienteModel;
import com.example.demo.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller

@RequestMapping("/citas")
public class CitaController {

    private static final String VISTA = "CitaPaciente";

    public CitaController() {
    }
    @GetMapping({"/citasPaciente"})
    public String cita(Model model) {
        return VISTA;
    }

    @PostMapping("/addCita")
    public String addCita(
            @Valid @ModelAttribute("cita") CitaModel citaModel,
            BindingResult bindingResult,
            RedirectAttributes flash,
            Model model){



        //CitaService.
        //userService.registrarPaciente(pacienteModel);

        //return mav;
        return "redirect:/pacientes/relacion";




    }

}
