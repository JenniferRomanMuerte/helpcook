package com.help.cook.helpcook.models;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class RecetasRequest {
	
	private Integer idRecetas;
	
	private Integer idUsuarios;
	
	private String descripcion;
	
	private Float tiempo;
	
	private String foto;
	
	private String tipo;
	
	private String categoria;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaAlta;
	
	private Float valoracionMedia;
	
	private Integer comensales;

	private List<IngredientesRecetasResponse> ingredientes;

}
