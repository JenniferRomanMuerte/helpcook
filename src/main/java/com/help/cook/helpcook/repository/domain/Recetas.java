package com.help.cook.helpcook.repository.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;


import lombok.Data;



@Data
@Entity
/** 
 * Clase de la tabla Recetas de BBDD Helpcook
 * @author Hugo
 * @version 1.0, 2022/11/05 
 */
public class Recetas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecetas;
	
	private Integer idUsuarios;
	
	private String descripcion;
	
	private Float tiempo;
	
	private String foto;
	
	private String tipo;
	
	private String categoria;
	
	private Timestamp fechaAlta;

	private Float valoracionMedia;
	
	private Integer comensales;

	
	
	//Creamos el objeto para la relación con la tabla RecetasIngredientes
	@OneToMany(mappedBy = "recetas") //Le indicamos que es una relación de 1 a muchos, y que coja el objeto recetas de la tabla RecetasIngredientes
	Set<RecetasIngredientes> ingredientes;
	
	
	// Creamos la relación con la tabla Pasos
	@OneToMany(mappedBy = "recetas")
	Set<Pasos> pasos;

}
