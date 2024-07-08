package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.map.AlumnoMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.CarreraService;
import ar.edu.unju.fi.service.MateriaService;


@Controller
public class ConsultaController {
	
	@Autowired
	CarreraService carreraService;
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	MateriaService materiaService;
	@Autowired
	AlumnoMapDTO alumnoMapDTO;
	
	@Autowired
	Alumno nuevoAlumno;

	@Autowired
	Materia nuevaMateria;
	
	@GetMapping("/consultarAlumnos")
	public ModelAndView consultarAlumnosForm() {
	    ModelAndView modelAndView = new ModelAndView("listaDeAlumnosDTO");
	    return modelAndView;
	}

	@PostMapping("/consultarAlumnos")
	public ModelAndView consultarAlumnos(@RequestParam("codigoCarrera") String codigoCarrera) {
	    ModelAndView modelAndView = new ModelAndView("listaDeAlumnosDTO");
	    modelAndView.addObject("listadoAlumnos", alumnoMapDTO.convertirListaAlumnosAListaAlumnosDTO(alumnoService.filtrarAlumnosPorCarrera(codigoCarrera)));
	    return modelAndView;
	}

	@GetMapping("/formularioInscripcion") // inscribe Alumno en Materias
	public ModelAndView getFormAlumnoInscripcion() {
		ModelAndView modelView = new ModelAndView("formAlumnoInscripcion");		
		modelView.addObject("nuevoAlumno", nuevoAlumno);
		modelView.addObject("nuevaMateria", nuevaMateria);
		modelView.addObject("listadoMaterias", materiaService.mostrarMateriasDTO());
		return modelView;
	}
	
	@PostMapping("/inscribirAlumno")
	public ModelAndView formularioInscripcion(@ModelAttribute("nuevoAlumno") Alumno alumno, @ModelAttribute("nuevaMateria") Materia materia) {
		ModelAndView modelView = new ModelAndView("ListaDeAlumnos");
		modelView.addObject("listadoAlumnos", alumnoService.mostrarAlumno());
		try {
			if (alumnoService.buscarAlumno(alumno.getLu())!=null){
				alumnoService.inscribirAlumno(alumnoService.buscarAlumno(alumno.getLu()), materiaService.buscarMateria(materia.getCodigo()));			
			}
		}
		catch( Exception e){
			boolean errors = true;
			modelView.addObject("errors", errors);
			modelView.addObject("cargaAlumnoErrorMessage", " Error al cargar en la BD " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return modelView;	
	}
    
    @GetMapping("/filtrarAlumnos")
    public ModelAndView mostrarFormularioFiltrarAlumnos() {
        ModelAndView modelAndView = new ModelAndView("formularioFiltrarAlumnos");
        return modelAndView;
    }

    @PostMapping("/filtrarAlumnos")
    public ModelAndView filtrarAlumnos(@RequestParam("codigo") Integer codigo) {
        ModelAndView modelAndView = new ModelAndView("listaDeAlumnos");
        modelAndView.addObject("listadoAlumnos", alumnoService.filtrarAlumnos(codigo)); // Asegurar que se filtran los alumnos por materia
        return modelAndView;
    }

	
	
	
	
	
}
