package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Paciente;
import com.example.demo.model.PacienteModel;
import com.example.demo.service.PacienteService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/pacientes")
public class RelacionPacientes {

    private static final String VISTA = "relacionPacientes";
    private static final String VISTA2 = "altaPaciente";
    // private static final Log LOG = LogFactory.getLog(RelacionPacientes.class);

    @Autowired
    @Qualifier("pacienteServiceImpl")
    private PacienteService pacienteService;
    
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public RelacionPacientes() {
    }
    @GetMapping({"/relacion"})
    public ModelAndView relacionpacientes() {
        ModelAndView pacientes=new ModelAndView(VISTA);
        pacientes.addObject("pacientes", pacienteService.listAllPacientes());
        return pacientes;
    }

    @GetMapping(value = {"/altaPaciente"})
    //public String pacienteForm(@PathVariable(name="idPaciente", required=false) Integer idPaciente, Model model) {
    public String pacienteForm(@RequestParam(name="idPaciente",required = false) Integer idPaciente,@RequestParam(name="nombre",required=false) String nombre, Model model){
        PacienteModel pacienteModel=new PacienteModel();

        model.addAttribute("paciente", new PacienteModel());
        model.addAttribute("paciente",pacienteModel);
        return VISTA2;
    }

    //con esto editamos el paciente
    @GetMapping("/editar")
    public String editar(@RequestParam(name="idPaciente", required = false) Integer idPaciente,Model model){
        Paciente paciente= new Paciente();
        paciente=pacienteService.findPacienteById(idPaciente);
        System.out.println(paciente.getIdPaciente());
        System.out.println(paciente.getNombre());
        model.addAttribute("paciente",paciente);
        return VISTA2;
    }


    //Para añadir al paciente
    @PostMapping("/addPaciente")
    public String addPaciente(
    		@Valid @ModelAttribute("paciente") PacienteModel pacienteModel,
            BindingResult bindingResult,
            RedirectAttributes flash,
            Model model,
            @RequestParam("foto") MultipartFile foto,
            @RequestParam("username") String username){
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


        pacienteService.addPaciente(pacienteModel);
        userService.registrarPaciente(pacienteModel);

        //return mav;
        return "redirect:/pacientes/relacion";

       /* if(bindingResult.hasErrors()) {
            model.addAttribute("pacientes", pacienteService.listAllPacientes());
            return VISTA;
        }else{
            String imagen= storageService.store(foto,pacienteModel.getIdPaciente());
            pacienteModel.setFoto(foto,pacienteModel);
        }*/


        }

    //para borrar pacientes
    @GetMapping("/bajaPaciente")
    //public String pacienteForm(@PathVariable(name="idPaciente", required=false) Integer idPaciente, Model model) {
    public String bajaPaciente(@RequestParam(name="idPaciente",required=true) Integer idPaciente, Model model){
        //CiclistaModelo ciclistaModelo=new CiclistaModelo();

        pacienteService.removePaciente(idPaciente);
        return "redirect:/pacientes/relacion";
    }



}