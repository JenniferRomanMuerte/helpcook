package com.help.cook.helpcook.repository.domain;

import javax.persistence.*;

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


	private Integer tipo;

	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="ID_Recetas")
	private Recetas recetas;

}
