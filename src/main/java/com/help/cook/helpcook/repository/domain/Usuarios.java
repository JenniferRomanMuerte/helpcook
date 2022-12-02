package com.help.cook.helpcook.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUsuarios;

	private String nick;

	private String contraseña;

	private String nombre;

	private String apellido;

	private String email;

	private String foto;
}
