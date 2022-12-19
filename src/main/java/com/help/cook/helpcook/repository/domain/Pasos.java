package com.help.cook.helpcook.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pasos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPasos;

	private Integer idRecetas;

	private Integer tipo;

	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="ID_Recetas")
	private Pasos pasos;

}
