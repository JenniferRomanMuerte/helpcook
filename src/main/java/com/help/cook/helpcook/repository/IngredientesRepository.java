package com.help.cook.helpcook.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Ingredientes;


//Es la interface que accede a la base de datos
//Extiende del CrudRepository y le indicamos la tabla y el tipo de la primaryKey

public interface  IngredientesRepository  extends CrudRepository<Ingredientes, Integer> {
	
	List<Ingredientes> findAll();

}
