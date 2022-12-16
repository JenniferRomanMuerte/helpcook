package com.help.cook.helpcook.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Valoraciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idValoraciones;
	
	private Integer idRecetas;

	@ManyToOne
	@JoinColumn(name="ID_Usuarios")
	private Usuarios usuarios;

	private Integer valor;

}
