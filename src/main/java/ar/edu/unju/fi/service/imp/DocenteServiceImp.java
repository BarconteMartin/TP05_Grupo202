package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.map.DocenteMapDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.DocenteService;

@Service
public class DocenteServiceImp implements DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;
    
    @Autowired
    private DocenteMapDTO docenteMapDTO;
    
    @Override
    public void guardarDocente(DocenteDTO docenteDTO) {
        Docente docente = docenteMapDTO.convertirDocenteDTOADocente(docenteDTO);
        docente.setEstado(true); // Aseguramos que el estado se establezca en verdadero al guardar.
        docenteRepository.save(docente);
    }

    @Override
    public List<Docente> mostrarDocentes() {
       return docenteRepository.findDocenteByEstado(true);
    }

    @Override
    public void borrarDocente(String legajo) {
        Docente docente = docenteRepository.findById(legajo).orElse(null);
        if (docente != null) {
            docente.setEstado(false);
            docenteRepository.save(docente);
        }
    }

    @Override
    public void modificarDocente(DocenteDTO docenteModificado) {
        Docente docente = docenteRepository.findById(docenteModificado.getLegajo()).orElse(null);
        if (docente != null) {
            docente.setNombre(docenteModificado.getNombre());
            docente.setApellido(docenteModificado.getApellido());
            docente.setEmail(docenteModificado.getEmail());
            docente.setTelefono(docenteModificado.getTelefono());
            docente.setEstado(docenteModificado.isEstado());
            docenteRepository.save(docente);
        }
    }

    @Override
    public DocenteDTO buscarDocente(String legajo) {
        Docente docente = docenteRepository.findById(legajo).orElse(null);
        return docente != null ? docenteMapDTO.convertirDocenteADocenteDTO(docente) : null;
    }
}