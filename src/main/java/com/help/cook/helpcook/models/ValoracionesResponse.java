package com.help.cook.helpcook.models;

import lombok.Data;

@Data
public class ValoracionesResponse {
	
	private Integer idValoraciones;
	
	private Integer idRecetas;
	
	private UsuariosResponse usuario;
	
	private Integer valor;

}
