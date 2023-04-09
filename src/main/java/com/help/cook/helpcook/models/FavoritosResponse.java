package com.help.cook.helpcook.models;

import lombok.Data;

@Data
/**
 * Clase para la devolución del objeto Favorito
 * @author Jennifer
 * @version 1.0, 2022/11/05
 *
 */
public class FavoritosResponse {

	private Integer idFavoritos;

	private Integer idRecetas;

	private Integer idUsuarios;

	private String descripcion;

}
