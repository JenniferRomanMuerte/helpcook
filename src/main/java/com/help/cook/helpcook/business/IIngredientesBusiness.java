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

	/**
	 * Método para crear un ingrediente,
	 * almacenamos los datos en un objeto Ingrediente y lo guardamos en el repositorio,
	 * asignamos los datos en el objeto Ingrediente a devolver
	 * @param request. Recibimos el objeto Ingredientes con los datos introducidos por el usuario
	 * @return. Devolvemos el Ingrediente creado
	 */
	IngredientesResponse crear(IngredientesRequest request);
	
	
    /**
     * Método para recuperar los datos de un ingrediente por su id,
     * recuperamos el ingrediente del repositorio y almacenamos los datos en el objeto a devolver
     * @param id. Recibimos el id del Ingrediente que se quiere recuperar
     * @return. DFevolvemos el Ingrediente solicitado
     */
	IngredientesResponse obtener(Integer id);
	
	
    /**
     * Método para borrar un ingrediente
     * @param id. Recibimos el id del ingrediente a borrar
     */
	void eliminar(Integer id);
	
	
     /**
      * Método para modificar los valores de un ingrediente,
      * recuperamos el Ingrediente a modificar del repositorio, le asignamos los nuevos valores,
      * lo guardamos el objeto Ingrediente a devolver
      * @param request. Recibimos el objeto con los nuevos datos.
      * @param id. Recibimos el id del Ingrediente que se quiere modificar
      * @return. Devolvemos el Ingrediente con los nuevos datos dados por el usuario
      */
	IngredientesResponse modificar(IngredientesRequest request, Integer id);
	
	
    /**
     * Método para obtener todos los ingredientes de la base de datos,
     * si el párametro tipo va vacio recuperamos todos los ingredientes,
     * si recibimos el párametro recuperamos sólo los Ingredientes de ese tipo
     * @param tipo. Recibimos el tipo del ingrediente
     * @return. Devolvemosla lista de los ingredientes que hemos recuperado del repositorio
     */
    List<IngredientesResponse> obtenerTodos(String tipo);
}
