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
/** 
 * Clase de la tabla Valoraciones de BBDD Helpcook
 * @author Jennifer
 * @version 1.0, 2022/11/05
 * 
 */
public class Valoraciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idValoraciones;
	
	private Integer idRecetas;
	
	private Integer valor;

	
	
	
	
	//Declaramos el objeto Usuarios para la relación entre las tablas
	@ManyToOne //Le indicamos que es una relación de muchos a uno
	@JoinColumn(name="ID_Usuarios") //Le indicamos que use la columna Id para la relación
	private Usuarios usuarios;

	

}
