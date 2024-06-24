package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;

@Controller
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/formularioDocentes")
    public String getFormDocente(Model model) {
        model.addAttribute("nuevoDocente", new DocenteDTO());
        model.addAttribute("flag", false); // Asegura que flag sea falso por defecto para guardar
        return "formDocente";
    }

    @PostMapping("/guardarDocente")
    public String saveDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteParaGuardar) {
        docenteService.guardarDocente(docenteParaGuardar);
        return "redirect:/listadoDocentes";
    }

    @GetMapping("/listadoDocentes")
    public String getListadoDocentes(Model model) {
        model.addAttribute("listadoDocentes", docenteService.mostrarDocentes());
        return "listaDeDocentes";
    }

    @GetMapping("/borrarDocente/{legajo}")
    public String deleteDocenteDelListado(@PathVariable("legajo") String legajo) {
        docenteService.borrarDocente(legajo);
        return "redirect:/listadoDocentes";
    }

    @GetMapping("/modificarDocente/{legajo}")
    public String editDocente(@PathVariable("legajo") String legajo, Model model) {
        DocenteDTO docenteParaModificar = docenteService.buscarDocente(legajo);
        model.addAttribute("nuevoDocente", docenteParaModificar);
        model.addAttribute("flag", true); // Habilita el flag para modificar
        return "formDocente";
    }

    @PostMapping("/modificarDocente")
    public String updateDocente(@ModelAttribute("nuevoDocente") DocenteDTO docenteModificado) {
        docenteService.modificarDocente(docenteModificado);
        return "redirect:/listadoDocentes";
    }
}
