package com.help.cook.helpcook.repository.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
/** 
 * Clase de la tabla Pasos de BBDD Helpcook
 * @author Hugo
 * @version 1.0, 2022/11/05 
 */
public class Pasos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPasos;


	private Integer tipo;

	private String descripcion;
	
	private String foto;
	
	
	
	@ManyToOne
	@JoinColumn(name="ID_Recetas")
	private Recetas recetas;

}
