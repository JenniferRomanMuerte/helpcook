package com.help.cook.helpcook.models;

import lombok.Data;

@Data
public class PasosRequest {

	private Integer idPasos;

	private Integer idRecetas;

	private Integer tipo;

	private String descripcion;

}
