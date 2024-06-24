package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.service.MateriaService;
@Controller
public class MateriaController {
	@Autowired
    Materia nuevaMateria;
	
	@Autowired
	MateriaService materiaService;

    @GetMapping("/formularioMaterias")
    public ModelAndView getFormularioMaterias() {
        ModelAndView modelView = new ModelAndView("formMateria");
        modelView.addObject("nuevaMateria", nuevaMateria);
        modelView.addObject("band", false);
        return modelView;
    }
    @GetMapping("/listadoMateria")
    public ModelAndView getListadoMateria() {
        ModelAndView modelView = new ModelAndView("listaDeMaterias");
        modelView.addObject("listadoMateria", materiaService.mostrarMaterias());
        return modelView;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaParaGuardar) {
        materiaService.guardarMateria(materiaParaGuardar);
        return new ModelAndView("redirect:/listadoMateria");
    }
	  @GetMapping("/borrarMateria/{codigo}")
	  public ModelAndView deleteMateriaDelListado(@PathVariable(name="codigo") String codigo) {
			materiaService.borrarMateria(codigo);
			ModelAndView modelView = new ModelAndView("listaDeMaterias");
			modelView.addObject("listadoMateria", materiaService.mostrarMaterias());	
			
			return modelView;		
			}
	  
	  @GetMapping("/modificarMateria/{codigo}") 
	  public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) { 
	  MateriaDTO materiaParaModificar = materiaService.buscarMateria(codigo); 
	  ModelAndView modelView = new ModelAndView("formMateria");
	  modelView.addObject("nuevaMateria", materiaParaModificar);
	  modelView.addObject("band", true); return modelView; }
	  
	  @PostMapping("/modificarMateria")
	    public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") MateriaDTO materiaModificada) {
	        materiaService.modificarMateria(materiaModificada);
	        return new ModelAndView("redirect:/listadoMateria");
	    }
			 
		/*
		 * @GetMapping("/modificarMateria/{codigo}") public ModelAndView
		 * editMateria(@PathVariable(name="codigo") String codigo) { Materia
		 * materiaAModificar = ListadoMaterias.buscarMateriaPorCodigo(codigo);
		 * 
		 * ModelAndView modelView = new ModelAndView("formularioMaterias");
		 * modelView.addObject("nuevaMateria", materiaAModificar);
		 * modelView.addObject("listadoDocente", ListadoDocentes.listarDocentes());
		 * modelView.addObject("listadoCarrera", ListadoCarreras.listarCarreras());
		 * modelView.addObject("flag", true); return modelView; }
		 * 
		 * @PostMapping("/modificarMateria") public ModelAndView
		 * updateMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
		 * materiaModificada.setDocente(ListadoDocentes.buscarDocentePorLegajo(
		 * materiaModificada.getDocente().getLegajo()));
		 * materiaModificada.setCarrera(ListadoCarreras.buscarCarreraPorCodigo(
		 * materiaModificada.getCarrera().getCodigo()));
		 * ListadoMaterias.modificarMateria(materiaModificada);
		 * 
		 * ModelAndView modelView = new ModelAndView("listaDeMaterias");
		 * modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());
		 * return modelView; }
		 * 
		 * @GetMapping("/materias") public ModelAndView showMaterias() { ModelAndView
		 * modelView = new ModelAndView("listaDeMaterias");
		 * modelView.addObject("listadoMateria", ListadoMaterias.listarMaterias());
		 * return modelView; }
		 */
	 
}

