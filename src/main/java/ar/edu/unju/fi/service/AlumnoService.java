package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.model.Alumno;

@Service
public interface AlumnoService {
    void guardarAlumno(AlumnoDTO alumnoDTO);
    List<Alumno> mostrarAlumnos();
    void borrarAlumno(String dni);
    void modificarAlumno(AlumnoDTO alumnoModificado);
    AlumnoDTO buscarAlumno(String dni);
}