package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Service
public interface DocenteService {
    void guardarDocente(DocenteDTO docenteDTO);
    List<Docente> mostrarDocentes();
    void borrarDocente(String legajo);
    void modificarDocente(DocenteDTO docenteModificado);
    DocenteDTO buscarDocente(String legajo);
}