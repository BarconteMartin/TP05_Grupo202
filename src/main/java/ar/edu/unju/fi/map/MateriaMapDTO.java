package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.MateriaDTO;
import ar.edu.unju.fi.model.Materia;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapDTO {
	MateriaDTO convertirMateriaAMateriaDTO(Materia m);

    @InheritInverseConfiguration
    Materia convertirMateriaDTOAMateria(MateriaDTO cdto);

    List<MateriaDTO> convertirListaMateriasAListaMateriasDTO(List<Materia> listaMaterias);

    List<Materia> convertirListadMateriasDTOAListaMaterias(List<MateriaDTO> listaMateriasDTO);
}
