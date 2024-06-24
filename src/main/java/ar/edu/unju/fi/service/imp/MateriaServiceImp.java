package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;
@Service
public class MateriaServiceImp implements MateriaService{
	@Autowired
	MateriaRepository materiaRepository;
	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
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
	public void modificarMateria(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MateriaDTO buscarMateria(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
