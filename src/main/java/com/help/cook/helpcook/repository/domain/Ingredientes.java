package com.help.cook.helpcook.repository.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class Ingredientes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idIngredientes;
	
	private String nombre;
	
	private String tipo;
	
	private String cantidad;
}
