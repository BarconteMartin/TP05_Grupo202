package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;

@Controller
public class DocenteController {

    @Autowired
    DocenteDTO docenteServiceDTO;
    
    @Autowired
    DocenteService docenteService;
    
    @GetMapping("/formularioDocentes")
    public ModelAndView getFormDocente() {
    	ModelAndView modelView = new ModelAndView("formDocente");
        modelView.addObject("nuevoDocente", new DocenteDTO());
        modelView.addObject("flag", false); // Asegura que flag sea falso por defecto para guardar
        return modelView;
    }

    @PostMapping("/guardarDocente")
    public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteParaGuardar) {
        docenteService.guardarDocente(docenteParaGuardar);
        return new ModelAndView("redirect:/listadoDocentes");
    }

    @GetMapping("/listadoDocentes")
    public ModelAndView getListadoDocentes() {
        ModelAndView modelView = new ModelAndView("listaDeDocentes");
        modelView.addObject("listaDeDocentes", docenteService.mostrarDocentes());
        return modelView;
    }

    @GetMapping("/borrarDocente/{legajo}")
    public ModelAndView deleteDocenteDelListado(@PathVariable(name="legajo") String legajo) {
        docenteService.borrarDocente(legajo);
        ModelAndView modelView = new ModelAndView("listaDeDocentes");
        modelView.addObject("listaDeDocentes", docenteService.mostrarDocentes());
        return modelView;
        //return new ModelAndView("redirect:/listaDeDocentes");
    }

    @GetMapping("/modificarDocente/{legajo}")
    public ModelAndView editDocente(@PathVariable("legajo") String legajo) {
        DocenteDTO docenteParaModificar = docenteService.buscarDocente(legajo);
        ModelAndView modelView = new ModelAndView("formDocente");
        modelView.addObject("nuevoDocente", docenteParaModificar);
        modelView.addObject("flag", true); // Habilita el flag para modificar
        return modelView;
    }

    @PostMapping("/modificarDocente")
    public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteModificado) {
        docenteService.modificarDocente(docenteModificado);
        ModelAndView modelView = new ModelAndView("listaDeDocentes");
        modelView.addObject("listaDeDocentes", docenteService.mostrarDocentes());
        return modelView;
        //return new ModelAndView("redirect:/listaDeDocentes");
    }
}
