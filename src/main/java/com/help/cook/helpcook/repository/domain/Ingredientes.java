package com.help.cook.helpcook.repository.domain;

import javax.persistence.*;

import lombok.Data;

import java.util.Set;



//Representación de nuestra tabla de la base de datos, es la que usará la interface del repository

@Data //Anotación para generar los getters & setters y constructor de la clase
@Entity //Anotación para indicar que es una tabla de nuestra base de datos
/** 
 * Clase de la tabla Ingredientes de BBDD Helpcook
 * @author Jennifer
 * @version 1.0, 2022/11/05 
 */
public class Ingredientes {

	@Id // Anotación para indicar que es la primaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Le indicamos la forma de crear la primaryKey (la base de datos es la encargada de rellenar este valor ya que lo hemos declarado autoincrement en ella)
	private Integer idIngredientes;
	
	private String nombre;
	
	private String tipo;

	
	//Creamos el objeto para la relación con la tabla RecetasIngredientes
	@OneToMany(mappedBy = "ingredientes") //Le indicamos que es una relación de 1 a muchos, y que coja el objeto ingredientes de la tabla RecetasIngredientes
	Set<RecetasIngredientes> recetas;
}
