package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.map.MateriaMapDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;
@Service
public class MateriaServiceImp implements MateriaService{
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
    private MateriaMapDTO materiaMapDTO;
	
	@Override
	public void guardarMateria(MateriaDTO materiaDTO) {
        Materia materia = materiaMapDTO.convertirMateriaDTOAMateria(materiaDTO);
        materia.setEstado(true); 
        materiaRepository.save(materia);
    }

	@Override
	public List<Materia> mostrarMaterias() {
		// TODO Auto-generated method stub
		//return materiaRepository.findAll();
		return materiaRepository.findMateriaByEstado(true);
	}

	@Override
	public void borrarMateria(String codigo) {
		// TODO Auto-generated method stub
		Materia materia = materiaRepository.findById(codigo).orElse(null);
        if (materia != null) {
            materia.setEstado(false);
            materiaRepository.save(materia);
        }
	}

	@Override
	 public void modificarMateria(MateriaDTO materiaModificada) {
		// TODO Auto-generated method stub
		 Materia materia = materiaRepository.findById(materiaModificada.getCodigo()).orElse(null);
	        if (materia != null) {
	            materia.setNombre(materiaModificada.getNombre());
	            materia.setCurso(materiaModificada.getCurso());
	            materia.setEstado(materiaModificada.getEstado());
	            materia.setCantidadHoras(materiaModificada.getCantidadHoras());
	            materia.setModalidad(materiaModificada.getModalidad());
	            materiaRepository.save(materia);
	        }
	}
	@Override
	public MateriaDTO buscarMateria(String codigo) {
		// TODO Auto-generated method stub
		Materia materia = materiaRepository.findById(codigo).orElse(null);
        return materia != null ? materiaMapDTO.convertirMateriaAMateriaDTO(materia) : null;
	}
}
