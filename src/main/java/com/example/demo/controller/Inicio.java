package com.example.demo.controller;

import com.example.demo.model.MedicoModel;
import com.example.demo.model.PacienteModel;
import com.example.demo.service.MedicoService;
import com.example.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inicio")
public class Inicio {

    private static final String VISTA = "inicio";
    private static final String VISTA2 = "blanco";

    @Autowired
    @Qualifier("MedicoServiceImpl")
    private MedicoService medicoService;

    public Inicio() {
    }

    /*@GetMapping({"/"})
    public String inicio(Model model, ModelAndView medicos) {

        medicos=new ModelAndView(VISTA);

        model.addAttribute("medicos",medicoService.listAllPacientes());

        model.addAttribute("label","¿Por qué elegir Clinica Sur?");
        model.addAttribute("motivo","Existimos para mejorar la salud y la calidad de vida de los ciudadanos, " +
                "ofreciendo servicios sanitarios excelentes con el paciente como centro de nuestra atención y profesionales altamente cualificados.");
        model.addAttribute("quienessomos","El Grupo Hospitalario HLA es uno de los mayores proveedores hospitalarios de España. Lo componen 16 hospitales, " +
                "36 centros médicos multiespecialidad y una red de 41 unidades de referencia en tratamientos de última generación que trabajan de forma integrada para proporcionar acceso a una asistencia sanitaria de alto nivel.");

        model.addAttribute("quienessomos2","Con 1.300 plazas de hospitalización, HLA es un referente en la atención hospitalaria y ambulatoria. " +
                "El grupo posee casi 40 años de experiencia y está presente en seis países. Sus profesionales garantizan un modelo de atención que se basa en la excelencia, " +
                "la innovación, la responsabilidad y un trato humano y cercano con el paciente.");

        model.addAttribute("quienessomos3","En 2020 el Grupo Hospitalario HLA ha sido la primera compañía sanitaria en certificar sus protocolos " +
                "frente a la COVID-19 en toda su red asistencial. Este certificado es un paso más en la estrategia de HLA por la excelencia y la calidad asistencial.");



        return VISTA;
    }*/

    @GetMapping({"/"})
    public String inicio(Model model) {

        MedicoModel medicos=new MedicoModel();
        model.addAttribute("medicos", medicoService.listAllMedicos());

        model.addAttribute("label","¿Por qué elegir Clinica Sur?");
        model.addAttribute("motivo","Existimos para mejorar la salud y la calidad de vida de los ciudadanos, " +
                "ofreciendo servicios sanitarios excelentes con el paciente como centro de nuestra atención y profesionales altamente cualificados.");
        model.addAttribute("quienessomos","El Grupo Hospitalario HLA es uno de los mayores proveedores hospitalarios de España. Lo componen 16 hospitales, " +
                "36 centros médicos multiespecialidad y una red de 41 unidades de referencia en tratamientos de última generación que trabajan de forma integrada para proporcionar acceso a una asistencia sanitaria de alto nivel.");

        model.addAttribute("quienessomos2","Con 1.300 plazas de hospitalización, HLA es un referente en la atención hospitalaria y ambulatoria. " +
                "El grupo posee casi 40 años de experiencia y está presente en seis países. Sus profesionales garantizan un modelo de atención que se basa en la excelencia, " +
                "la innovación, la responsabilidad y un trato humano y cercano con el paciente.");

        model.addAttribute("quienessomos3","En 2020 el Grupo Hospitalario HLA ha sido la primera compañía sanitaria en certificar sus protocolos " +
                "frente a la COVID-19 en toda su red asistencial. Este certificado es un paso más en la estrategia de HLA por la excelencia y la calidad asistencial.");


        return VISTA;
    }

    @GetMapping({"/blanco"})
    public String blanco(Model model) {

        return VISTA2;
    }



}
