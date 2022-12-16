package com.help.cook.helpcook.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Ingredientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngredientes;
	
	private String nombre;
	
	private String tipo;
	
	private String cantidad;
}
