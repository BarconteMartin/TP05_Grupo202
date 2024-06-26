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
    AlumnoDTO alumnoServiceDTO;
    
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/formularioAlumnos")
    public ModelAndView getFormAlumno() {
    	ModelAndView modelView = new ModelAndView("formAlumno");
        modelView.addObject("nuevoAlumno", new AlumnoDTO());
        modelView.addObject("flag", false); // Asegura que flag sea falso por defecto para guardar
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
        modelView.addObject("listaDeAlumnos", alumnoService.mostrarAlumnos());
        return modelView;
    }

    @GetMapping("/borrarAlumno/{dni}")
    public ModelAndView deleteAlumnoDelListado(@PathVariable(name="dni") String dni) {
        alumnoService.borrarAlumno(dni);
        ModelAndView modelView = new ModelAndView("listaDeAlumnos");
        modelView.addObject("listaDeAlumnos", alumnoService.mostrarAlumnos());
        return modelView;
    }

    @GetMapping("/modificarAlumno/{dni}")
    public ModelAndView editAlumno(@PathVariable("dni") String dni) {
        AlumnoDTO alumnoParaModificar = alumnoService.buscarAlumno(dni);
        ModelAndView modelView = new ModelAndView("formAlumno");
        modelView.addObject("nuevoAlumno", alumnoParaModificar);
        modelView.addObject("flag", true); // Habilita el flag para modificar
        return modelView;
    }

    @PostMapping("/modificarAlumno")
    public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") AlumnoDTO alumnoModificado) {
        alumnoService.modificarAlumno(alumnoModificado);
        ModelAndView modelView = new ModelAndView("listaDeAlumnos");
        modelView.addObject("listaDeAlumnos", alumnoService.mostrarAlumnos());
        return modelView;
    }
}