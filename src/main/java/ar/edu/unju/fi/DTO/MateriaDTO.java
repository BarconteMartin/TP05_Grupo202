package ar.edu.unju.fi.DTO;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Modalidad;
import lombok.Data;

@Data
@Component
public class MateriaDTO {    
    private String codigo;
	private String nombre;
	private String curso;
	private Boolean estado;
	private int cantidadHoras;
	private Modalidad modalidad;
}
