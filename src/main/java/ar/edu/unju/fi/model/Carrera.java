package ar.edu.unju.fi.model;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Carrera {
	private String codigo;
	private String nombre;
	private int cantidadAnios;
	private boolean estado;
}