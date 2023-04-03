package com.help.cook.helpcook.models;

import lombok.Data;

@Data
public class UsuariosRequest {

	private Integer idUsuarios;

	private String nick;
	
	private String contrasenia;

	private String nombre;

	private String apellido;

	private String email;
	
	private String foto;
}
