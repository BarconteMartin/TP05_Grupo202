package ar.edu.unju.fi.map;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlumnoMapDTO {

    AlumnoDTO convertirAlumnoAAlumnoDTO(Alumno a);

    @InheritInverseConfiguration
    Alumno convertirAlumnoDTOAAlumno(AlumnoDTO adto);

    List<AlumnoDTO> convertirListaAlumnosAListaAlumnosDTO(List<Alumno> listaAlumnos);

    List<Alumno> convertirListaAlumnosDTOAListaAlumnos(List<AlumnoDTO> listaAlumnosDTO);
}