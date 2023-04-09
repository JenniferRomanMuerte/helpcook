package com.help.cook.helpcook.models;

import lombok.Data;

@Data
/**
 * Objeto para recibir datos del front
 * @author Jennifer
 *@version 1.0, 2022/11/05
 */
public class FavoritosRequest {
	
private Integer idFavoritos;
	
	private Integer idRecetas;
	
	private Integer idUsuarios;
	
	private String descripcion;
	

}
