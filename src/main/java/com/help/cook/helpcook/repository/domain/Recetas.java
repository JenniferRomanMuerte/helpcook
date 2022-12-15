package com.help.cook.helpcook.repository.domain;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


import lombok.Data;

@Data
@Entity
public class Recetas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecetas;
	
	private Integer idUsuarios;
	
	private String descripcion;
	
	private Float tiempo;
	
	private String foto;
	
	private String tipo;
	
	private String categoria;
	
	private Time fecha_alta;
	
	private Float valoracionMedia;
	
	private Integer comensales;
}
