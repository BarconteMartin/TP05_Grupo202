package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocenteMapDTO {

    DocenteDTO convertirDocenteADocenteDTO(Docente d);

    @InheritInverseConfiguration
    Docente convertirDocenteDTOADocente(DocenteDTO ddto);

    List<DocenteDTO> convertirListaDocentesAListaDocentesDTO(List<Docente> listaDocentes);

    List<Docente> convertirListaDocentesDTOAListaDocentes(List<DocenteDTO> listaDocentesDTO);
}