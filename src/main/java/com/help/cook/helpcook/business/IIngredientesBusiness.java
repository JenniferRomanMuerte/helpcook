package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.IngredientesRequest;

import com.help.cook.helpcook.models.IngredientesResponse;


//CREACIÓN DE LA INTERFACE PARA QUE PUEDAN LLAMARLAS OTRAS CLASES

public interface IIngredientesBusiness {

	// Definimos los métodos públicos para generar el CRUD

	//Métodos donde le pasamos lo que nos envia el front
	IngredientesResponse crear(IngredientesRequest request);

	IngredientesResponse obtener(Integer id);

	void eliminar(Integer id);

	IngredientesResponse modificar(IngredientesRequest request, Integer id);

	List<IngredientesResponse> obtenerTodos();


}
