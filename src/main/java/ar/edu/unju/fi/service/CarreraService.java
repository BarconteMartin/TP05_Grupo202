package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Service
public interface CarreraService {
    void guardarCarrera(CarreraDTO carreraDTO);
    List<Carrera> mostrarCarreras();
    void borrarCarrera(String codigo);
    void modificarCarrera(CarreraDTO carreraModificada);
    CarreraDTO buscarCarrera(String codigo);
}
