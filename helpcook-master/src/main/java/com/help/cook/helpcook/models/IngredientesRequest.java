package com.help.cook.helpcook.models;

import lombok.Data;

@Data
public class IngredientesRequest {

	private Integer idIngredientes;
	
	private String nombre;
	
	private String tipo;
	
	private String cantidad;
}
