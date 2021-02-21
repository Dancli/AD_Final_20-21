package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Medico;
import com.example.demo.model.MedicoModel;
import com.example.demo.service.MedicoService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private static final String VISTA = "relacionMedicos";
    private static final String VISTA2 = "altaMedico";
    private static final String VISTA3="relacionMedicoPorCategoria";

    @Autowired
    @Qualifier("MedicoServiceImpl")
    private MedicoService medicoService;
    
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public MedicoController() {
    }
    
    @GetMapping({"/relacion"})
    public ModelAndView relacionMedicos() {
        ModelAndView medicos=new ModelAndView(VISTA);
        medicos.addObject("medicos", medicoService.listAllMedicos());
        return medicos;
    }

    //se selecciona especialidad y muestra relacion
    @GetMapping({"/relacionEspecialidad"})
    public ModelAndView relacionEspecialidad(@Param(value="especialidad") String especialidad, Model model) {
        ModelAndView medicos=new ModelAndView(VISTA3);
        medicos.addObject("medicos", medicoService.findMedicoByEspecialidad(especialidad));
        return medicos;
    }



    @GetMapping(value = {"/altaMedico"})
    public String medicoForm(@RequestParam(name="idMedico",required = false) Integer idMedico, Model model){
        MedicoModel medicoModel=new MedicoModel();
        model.addAttribute("medico", new MedicoModel());
        model.addAttribute("medico", medicoModel);
        return VISTA2;
    }

    //con esto editamos el medico
    @GetMapping("/editar")
    public String editar(@RequestParam(name="idMedico",required = false) Integer idMedico, Model model){
        Medico medico= new Medico();
        medico=medicoService.findMedicoById(idMedico);
        System.out.println(medico.getIdMedico());
        System.out.println(medico.getNombre());
        model.addAttribute("medico",medico);
        return VISTA2;
    }



    @PostMapping("/saveMedico")
    public String addMedico(@Valid @ModelAttribute("medico") MedicoModel medicoModel, @RequestParam("username") String username){
        medicoService.saveMedico(medicoModel);
        userService.registrarMedico(medicoModel);
        return "redirect:/medicos/relacion";
    }

    //para borrar medicos
    @GetMapping("/bajaMedico")
    public String bajaMedico(@RequestParam(name="idMedico",required=true) Integer idMedico, Model model){
        medicoService.removeMedico(idMedico);
        return "redirect:/medicos/relacion";
    }






}