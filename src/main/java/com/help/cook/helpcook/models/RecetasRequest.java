package com.help.cook.helpcook.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RecetasRequest {
	
	private Integer idRecetas;
	
	private Integer idUsuarios;
	
	private String descripcion;
	
	private Float tiempo;
	
	private String foto;
	
	private String titulo;
	
	private String categoria;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaAlta;
	
	private Float valoracionMedia;
	
	private Integer comensales;

	private List<RecetasIngredientesRequest> ingredientes;
	
	private List<RecetasPasosRequest> pasos;

}
