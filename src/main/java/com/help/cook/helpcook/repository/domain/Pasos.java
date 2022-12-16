package com.help.cook.helpcook.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pasos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPasos;

	private Integer idRecetas;

	private Integer tipo;

	private String descripcion;

}
