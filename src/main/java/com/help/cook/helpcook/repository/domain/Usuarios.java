package com.help.cook.helpcook.repository.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuarios;

	private String nick;

	private String contraseña;

	private String nombre;

	private String apellido;

	private String email;

	private String foto;

	@OneToMany(mappedBy="usuarios")
	private Set<Valoraciones> valoraciones;


	@OneToMany(mappedBy = "usuarios")
	private  Set<Favoritos> favoritos;
}
