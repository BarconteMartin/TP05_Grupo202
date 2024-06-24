package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.map.CarreraMapDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;
    
    @Autowired
    private CarreraMapDTO carreraMapDTO;
    
    @Override
    public void guardarCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = carreraMapDTO.convertirCarreraDTOACarrera(carreraDTO);
        carrera.setEstado(true); // Aseguramos que el estado se establezca en verdadero al guardar.
        carreraRepository.save(carrera);
    }

    @Override
    public List<Carrera> mostrarCarreras() {
        return carreraRepository.findCarreraByEstado(true);
    }

    @Override
    public void borrarCarrera(String codigo) {
        Carrera carrera = carreraRepository.findById(codigo).orElse(null);
        if (carrera != null) {
            carrera.setEstado(false);
            carreraRepository.save(carrera);
        }
    }

    @Override
    public void modificarCarrera(CarreraDTO carreraModificada) {
        Carrera carrera = carreraRepository.findById(carreraModificada.getCodigo()).orElse(null);
        if (carrera != null) {
            carrera.setNombre(carreraModificada.getNombre());
            carrera.setCantidadAnios(carreraModificada.getCantidadAnios());
            carrera.setEstado(carreraModificada.getEstado());
            carreraRepository.save(carrera);
        }
    }

    @Override
    public CarreraDTO buscarCarrera(String codigo) {
        Carrera carrera = carreraRepository.findById(codigo).orElse(null);
        return carrera != null ? carreraMapDTO.convertirCarreraACarreraDTO(carrera) : null;
    }
}
