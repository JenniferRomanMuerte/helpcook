package com.help.cook.helpcook.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.IngredientesRepository;
import com.help.cook.helpcook.repository.domain.Ingredientes;

@Service //Sube al contexto de Spring la información

/**
 * Usamos ésta clase para subir al contexto de Spring la información
 * @author Jennifer
 * @version 1.0, 2022/11/05
 */
public class IngredientesBusinessImpl implements IIngredientesBusiness {

	@Autowired ////Le indicamos que recupera la información del contexto de Spring de ésta Interface
	private IngredientesRepository ingredientesRepository;

	@Override
	/**
	 * 
	 * Método para crear un ingrediente
	 * 
	 * @param ingredientes. Creamos un ingrediente al cúal le asignaremos los valores que manda el usuario
	 * @param response. Creamos el ingredientes que vamos a devolver
	 * Se asignan los valores recibidos del front(del objeto ingredientes request) a los atributos del ingredientes
	 * @param datoGuardado. Creamos un nuevo objeto ingredientes (datoGuardado) asignandole el ingrediente que hemos creado y guardado en el repositorio
	 * Asignamos al ingrediente que vamos a devolver(response) los valores del ingrediente (datoGuardo)  
	 * 
	 * @return. Devuelve el ingrediente que hemos creado con los datos dados por el usuario
	 */
	public IngredientesResponse crear(IngredientesRequest request) {

		Ingredientes ingredientes = new Ingredientes(); //Creamos un objeto ingredientes

		IngredientesResponse response = new IngredientesResponse(); //Creamos el objeto que devolveremos al front

		//Metemos en el objeto ingredientes los datos que recuperamos del objeto de entrada
		ingredientes.setNombre(request.getNombre());
		ingredientes.setTipo(request.getTipo());

		Ingredientes datoGuardado = ingredientesRepository.save(ingredientes); //Creamos un objeto ingredientes donde que guardaremos en la base de datos

		////Metemos en el objeto response(creado para la salida de datos) los datos que recuperamos del objeto que hemos guardado
		response.setIdIngredientes(datoGuardado.getIdIngredientes());
		response.setNombre(datoGuardado.getNombre());
		response.setTipo(datoGuardado.getTipo());

		return response; //devolvemos el objeto de salida
	}

	@Override
	
	/**
	 * Método para recuperar los datos de un ingrediente por su id
	 * 
	 * @param response. Creamos el objeto ingredientes que vamos a devolver
	 * @param datoGuardado. Recuperamos el objeto ingredientes del repositorio y lo almacenamos
	 * Asignamos al objeto ingredientes a devolver los valores del ingrediente guardado
	 * 
	 * @return. Devolvemos el ingrediente
	 * 
	 */
	public IngredientesResponse obtener(Integer id) {

		IngredientesResponse response = new IngredientesResponse(); //Creamos el objeto que devolveremos al front

		Ingredientes datoGuardado = ingredientesRepository.findById(id).get(); //Recuperamos el objeto de la base de datos por su id


		//Metemos en el objeto response(para su salida de datos) los datos que recuperamos del objeto de la base de datos
		response.setIdIngredientes(datoGuardado.getIdIngredientes());
		response.setNombre(datoGuardado.getNombre());
		response.setTipo(datoGuardado.getTipo());

		return response; //devolvemos el objeto de salida
	}

	/**
	 * Método para borrar un ingrediente
	 * Borramos de la base de datos el ingrediente mediante su id
	 */
	public void eliminar(Integer id) {

		ingredientesRepository.deleteById(id); //Borramos de la base de datos el objeto indicandole su id

	}
	
	/**
	 * Método para modificar los valores de un ingrediente
	 * 
	 * @param response. Creamos el ingrediente que se va a devolver
	 * @param datoGuardado. Recuperamos el ingrediente del repositorio mediante su id
	 * Asignamos al ingrediente que hemos recuperado los valores dados por el usuario
	 * @param datoModificado. Creamos un ingrediente con los datos ya modificados y guardamos en el repositorio
	 * Asignamos al ingrediente a devolver los nuevos datos
	 * 
	 * @return. Devolvemos el ingrediente ya modificado.
	 */
	public IngredientesResponse modificar(IngredientesRequest request, Integer id) {

		IngredientesResponse response = new IngredientesResponse(); //Creamos el objeto que devolveremos al front

		Ingredientes datoGuardado = ingredientesRepository.findById(id).get(); //Recuperamos el objeto de la base de datos por su id


		//Asignamos los valores nuevos introducidos por el usuario al objeto recuperado de la base de datos
		datoGuardado.setNombre(request.getNombre());
		datoGuardado.setTipo(request.getTipo());

		Ingredientes datoModificado = ingredientesRepository.save(datoGuardado); //Introducimos en la base de datos el objeto ya modificado


		//Metemos en objeto de salida los datos del objeto ya modificado
		response.setIdIngredientes(datoModificado.getIdIngredientes());
		response.setNombre(datoModificado.getNombre());
		response.setTipo(datoModificado.getTipo());

		return response; //devolvemos el objeto de salida
	}

	@Override
	/**
	 * Método para obtener todos los ingredientes de la base de datos
	 * 
	 * @param ingredientesResponseLista. Declaramos la lista de ingredientes que vamos a devolver
	 * @param ingredientesLista. Declaramos una lista de ingredientes que almacenará los ingredientes del repositorio, 
	 * si mandamos el tipo almacenará sólo los ingredientes de esa tipo, si no le mandamos nada nos devuelve todos los ingredientes 
	 * Recorremos la lista de ingredientes recuperando todos los ingredientes
	 * @param ingredientesResponse. Creamos el ingrediente para almacenar los valores del ingrediente del repositorio y lo añadimos a la lista que vamos a devolver
	 * 
	 * @return. Devolvemosla lista de los ingredientes que hemos recuperado del repositorio
	 * 
	 */
	public List<IngredientesResponse> obtenerTodos(String tipo) {
		
		List<IngredientesResponse> ingredientesResponseLista = new ArrayList<>(); //Creamos una lista que nos devolvera los objetos ingredientes a mostrar
		
		List<Ingredientes> ingredientesLista = ingredientesRepository.findByTipo(tipo); //Creamos una lista que almacena todos los objetos de ingredientes de la BBDD
		
		
		//Recorremos la lista
		for(Ingredientes ingrediente: ingredientesLista) {
			IngredientesResponse ingredientesResponse = new IngredientesResponse(); //Creamos el objeto ingredientes a devolver
			
			//Le asignamos los datos que capturamos del objeto ingrediente de la tabla
			ingredientesResponse.setIdIngredientes(ingrediente.getIdIngredientes());
			ingredientesResponse.setNombre(ingrediente.getNombre());
			ingredientesResponse.setTipo(ingrediente.getTipo());
			
			//Metemos en la lista a devolver los objetos
			ingredientesResponseLista.add(ingredientesResponse);
		}
		
		return ingredientesResponseLista; //Devolvemos la lista con los objetos a devolver
	}
	
}
