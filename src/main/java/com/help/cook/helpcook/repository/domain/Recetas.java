package com.help.cook.helpcook.repository.domain;

import java.sql.Time;
import java.util.Set;

import javax.persistence.*;


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

	@OneToMany(mappedBy = "recetas")
	Set<RecetasIngredientes> ingredientes;

}
