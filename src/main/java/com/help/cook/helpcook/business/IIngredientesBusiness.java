package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.IngredientesRequest;

import com.help.cook.helpcook.models.IngredientesResponse;


//CREACIÓN DE LA INTERFACE PARA QUE PUEDAN LLAMARLAS OTRAS CLASES
/**
 * Declarada interfaz Ingredientes en el paquete Business,
 * se definen los métodos que se usarán en la clase 
 * @author Jennifer
 * @version 1.0, 2022/11/05
 *
 */
public interface IIngredientesBusiness {

	// Definimos los métodos públicos para generar el CRUD

	//Métodos donde le pasamos lo que nos envia el front
	IngredientesResponse crear(IngredientesRequest request);

	IngredientesResponse obtener(Integer id);

	void eliminar(Integer id);

	IngredientesResponse modificar(IngredientesRequest request, Integer id);

    List<IngredientesResponse> obtenerTodos(String tipo);
}
