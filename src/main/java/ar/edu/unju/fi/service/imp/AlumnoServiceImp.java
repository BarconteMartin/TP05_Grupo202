package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.AlumnoDTO;
import ar.edu.unju.fi.map.AlumnoMapDTO;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Autowired
    private AlumnoMapDTO alumnoMapDTO;
    
    @Override
    public void guardarAlumno(AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoMapDTO.convertirAlumnoDTOAAlumno(alumnoDTO);
        alumno.setEstado(true); // Aseguramos que el estado se establezca en verdadero al guardar.
        alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> mostrarAlumnos() {
       return alumnoRepository.findAlumnoByEstado(true);
    }

    @Override
    public void borrarAlumno(String dni) {
        Alumno alumno = alumnoRepository.findById(dni).orElse(null);
        if (alumno != null) {
            alumno.setEstado(false);
            alumnoRepository.save(alumno);
        }
    }

    @Override
    public void modificarAlumno(AlumnoDTO alumnoModificado) {
        Alumno alumno = alumnoRepository.findById(alumnoModificado.getDni()).orElse(null);
        if (alumno != null) {
            alumno.setNombre(alumnoModificado.getNombre());
            alumno.setApellido(alumnoModificado.getApellido());
            alumno.setEmail(alumnoModificado.getEmail());
            alumno.setTelefono(alumnoModificado.getTelefono());
            alumno.setFechaNacimiento(alumnoModificado.getFechaNacimiento());
            alumno.setDomicilio(alumnoModificado.getDomicilio());
            alumno.setLu(alumnoModificado.getLu());
            alumno.setEstado(alumnoModificado.isEstado());
            alumnoRepository.save(alumno);
        }
    }

    @Override
    public AlumnoDTO buscarAlumno(String dni) {
        Alumno alumno = alumnoRepository.findById(dni).orElse(null);
        return alumno != null ? alumnoMapDTO.convertirAlumnoAAlumnoDTO(alumno) : null;
    }
}