package com.help.cook.helpcook.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


//Representación de nuestra tabla de la base de datos, es la que usará la interface del repository                                             

@Data //Anotación para generar los getters & setters y constructor de la clase
@Entity //Anotación para indicar que es una tabla de nuestra base de datos
public class Ingredientes {

	@Id  // Anotación para indicar que es la primaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Le indicamos la forma de crear la primaryKey (la base de datos es la encargada de rellenar este valor ya que lo hemos declarado autoincrement en ella)
	private Integer idIngredientes;
	
	private String nombre;
	
	private String tipo;
	
}
