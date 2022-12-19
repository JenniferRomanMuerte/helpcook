package com.help.cook.helpcook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Ingredientes;
import org.springframework.data.repository.query.Param;


//Es la interface que accede a la base de datos
//Extiende del CrudRepository y le indicamos la tabla y el tipo de la primaryKey

public interface  IngredientesRepository  extends CrudRepository<Ingredientes, Integer> {
	
	List<Ingredientes> findAll(); //Declaramos el método que usará Business

	@Query("SELECT i FROM Ingredientes i WHERE (:tipo is null or i.tipo like %:tipo%)")
	List<Ingredientes> findByTipo(@Param("tipo") String tipo);

}
