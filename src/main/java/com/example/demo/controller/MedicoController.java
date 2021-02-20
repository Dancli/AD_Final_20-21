package com.example.demo.controller;

import com.example.demo.entity.Medico;
import com.example.demo.entity.Paciente;
import com.example.demo.model.MedicamentoModel;
import com.example.demo.model.MedicoModel;
import com.example.demo.model.PacienteModel;
import com.example.demo.service.MedicoService;
import com.example.demo.service.PacienteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private static final String VISTA = "relacionMedicos";
    private static final String VISTA2 = "altaMedico";
    private static final String VISTA3="relacionMedicoPorCategoria";
    private static final Log LOG=LogFactory.getLog(MedicoController.class);

    @Autowired
    @Qualifier("MedicoServiceImpl")

    private MedicoService medicoService;

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
    //public String pacienteForm(@PathVariable(name="idPaciente", required=false) Integer idPaciente, Model model) {
    public String medicoForm(@RequestParam(name="idMedico",required = false) Integer idMedico, Model model){

        MedicoModel medicoModel=new MedicoModel();
        model.addAttribute("medico", new MedicoModel());

        model.addAttribute("medico",medicoModel);
        return VISTA2;
    }

    //con esto editamos el paciente
    @GetMapping("/editar")
    public String editar(@RequestParam(name="idMedico",required = false) Integer idMedico,Model model){
        Medico medico= new Medico();
        medico=medicoService.findMedicoById(idMedico);
        System.out.println(medico.getIdMedico());
        System.out.println(medico.getNombre());
        model.addAttribute("medico",medico);
        return VISTA2;
    }



    @PostMapping("/addMedico")
    public String addMedico(@Valid @ModelAttribute("medico") MedicoModel medicoModel){
                              //BindingResult bindingResult, RedirectAttributes flash, Model model){
        //ModelAndView mav=new ModelAndView(VISTA);
        //pacienteService.findPacienteById(paciente.getIdPaciente());

        //si la validación tiene errores
        /*if(bindingResult.hasErrors()) {
            Path directorio= Paths.get(".\\src\\main\\resources\\static\\img");
            String rootPath=directorio.toFile().getAbsolutePath();
            LOG.info("rootPath"+rootPath);
            try {
                byte[] bytes=foto.getBytes();
                Path rutaCompleta=Paths.get(rootPath+"\\"+pacienteModel.getIdPaciente()+pacienteModel.getNombre()+".png");
                LOG.info("hola"+rutaCompleta);
                Files.write(rutaCompleta,bytes);
                pacienteModel.setFoto("/img/"+pacienteModel.getIdPaciente()+pacienteModel.getNombre()+".png");
            }catch(IOException e) {
                e.printStackTrace();
            }
        }else {

            pacienteModel.setFoto("/img/logo.jpg");
            LOG.info("/img/logo.jpg");

        }*/

       System.out.println("los valores del medico son " + medicoModel.toString());
               

        medicoService.addMedico(medicoModel);
        return "redirect:/medicos/relacion";

       /* if(bindingResult.hasErrors()) {
            model.addAttribute("pacientes", pacienteService.listAllPacientes());
            return VISTA;
        }else{
            String imagen= storageService.store(foto,pacienteModel.getIdPaciente());
            pacienteModel.setFoto(foto,pacienteModel);
        }*/


    }

    //para borrar medicos
    @GetMapping("/bajaMedico")
    //public String pacienteForm(@PathVariable(name="idPaciente", required=false) Integer idPaciente, Model model) {
    public String bajaMedico(@RequestParam(name="idMedico",required=true) Integer idMedico, Model model){
        //CiclistaModelo ciclistaModelo=new CiclistaModelo();

        medicoService.removeMedico(idMedico);
        return "redirect:/medicos/relacion";
    }






}