package com.help.cook.helpcook.models;

import lombok.Data;

@Data
public class IngredientesResponse {
	private Integer idIngredientes;
	
	private String nombre;
	
	private String tipo;
	
	private String cantidad;
}
