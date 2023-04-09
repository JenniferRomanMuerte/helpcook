package com.help.cook.helpcook.models;

import lombok.Data;

@Data
/**
 * Objeto para recibir datos del front
 * @author Hugo
 *@version 1.0, 2022/11/05
 */
public class PasosRequest {

	private Integer idPasos;

	private Integer idRecetas;

	private Integer tipo;

	private String descripcion;

	private String foto;

}
