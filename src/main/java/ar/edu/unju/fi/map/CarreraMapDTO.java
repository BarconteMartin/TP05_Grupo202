package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapDTO {

    CarreraDTO convertirCarreraACarreraDTO(Carrera c);

    @InheritInverseConfiguration
    Carrera convertirCarreraDTOACarrera(CarreraDTO cdto);

    List<CarreraDTO> convertirListaCarrerasAListaCarrerasDTO(List<Carrera> listaCarreras);

    List<Carrera> convertirListadCarrerasDTOAListaCarreras(List<CarreraDTO> listaCarrerasDTO);
}
