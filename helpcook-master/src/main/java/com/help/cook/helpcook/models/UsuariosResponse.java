package com.help.cook.helpcook.models;

import lombok.Data;

@Data
public class UsuariosResponse {
	
	private Integer idUsuarios;

	private String nick;
	
	private String contraseña;

	private String nombre;

	private String apellido;

	private String email;
	
	private String foto;

}
