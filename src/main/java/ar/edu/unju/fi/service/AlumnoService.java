package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

public interface AlumnoService {
    void guardarAlumno(AlumnoDTO alumnoDTO);
    List<Alumno> mostrarAlumnos();
    void borrarAlumno(String codigo);
    void modificarAlumno(AlumnoDTO alumnoModificado);
    AlumnoDTO buscarAlumno(String codigo);
}