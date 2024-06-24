package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.service.AlumnoService;

@Controller
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/formularioAlumnos")
    public ModelAndView getFormAlumno() {
        ModelAndView modelView = new ModelAndView("formAlumno");
        modelView.addObject("nuevoAlumno", new AlumnoDTO());
        modelView.addObject("band", false);
        return modelView;
    }
    
    @PostMapping("/guardarAlumno")
    public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoParaGuardar) {
        alumnoService.guardarAlumno(alumnoParaGuardar);
        return new ModelAndView("redirect:/listadoAlumnos");
    }
    
    @GetMapping("/listadoAlumnos")
    public ModelAndView getListadoAlumnos() {
        ModelAndView modelView = new ModelAndView("listaDeAlumnos");
        modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumnos());
        return modelView;
    }

    @GetMapping("/borrarAlumno/{codigo}")
    public ModelAndView deleteAlumnoDelListado(@PathVariable(name="codigo") String codigo) {
        alumnoService.borrarAlumno(codigo);
        return new ModelAndView("redirect:/listadoAlumnos");
    }
    
    @GetMapping("/modificarAlumno/{codigo}")
    public ModelAndView editAlumno(@PathVariable(name="codigo") String codigo) {
        AlumnoDTO alumnoParaModificar = alumnoService.buscarAlumno(codigo);
        ModelAndView modelView = new ModelAndView("formAlumno");
        modelView.addObject("nuevoAlumno", alumnoParaModificar);
        modelView.addObject("band", true);
        return modelView;        
    }
    
    @PostMapping("/modificarAlumno")
    public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoModificado) {
        alumnoService.modificarAlumno(alumnoModificado);
        return new ModelAndView("redirect:/listadoAlumnos");
    }
}