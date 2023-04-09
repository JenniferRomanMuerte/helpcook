package com.help.cook.helpcook.models;

import lombok.Data;

@Data
/**
 * Clase para la devolución del objeto Valoraciones
 * @author Jennifer
 * @version 1.0, 2022/11/05
 *
 */
public class ValoracionesResponse {
	
	private Integer idValoraciones;
	
	private Integer idRecetas;
	
	private UsuariosResponse usuario;
	
	private Integer valor;

}
