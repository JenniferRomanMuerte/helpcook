package com.help.cook.helpcook.models;

import lombok.Data;

@Data
/**
 * Objeto para recibir datos del front
 * @author Jennifer
 *@version 1.0, 2022/11/05
 */
public class ValoracionesRequest {
	
	private Integer idValoraciones;
	
	private Integer idRecetas;
	
	private Integer idUsuarios;
	
	private Integer valor;

}
