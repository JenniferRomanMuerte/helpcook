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
public class IngredientesBusinessImpl implements IIngredientesBusiness {

	@Autowired ////Le indicamos que recupera la información del contexto de Spring de ésta Interface
	private IngredientesRepository ingredientesRepository;

	@Override
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
	public IngredientesResponse obtener(Integer id) {

		IngredientesResponse response = new IngredientesResponse(); //Creamos el objeto que devolveremos al front

		Ingredientes datoGuardado = ingredientesRepository.findById(id).get(); //Recuperamos el objeto de la base de datos por su id


		//Metemos en el objeto response(para su salida de datos) los datos que recuperamos del objeto de la base de datos
		response.setIdIngredientes(datoGuardado.getIdIngredientes());
		response.setNombre(datoGuardado.getNombre());
		response.setTipo(datoGuardado.getTipo());

		return response; //devolvemos el objeto de salida
	}

	public void eliminar(Integer id) {

		ingredientesRepository.deleteById(id); //Borramos de la base de datos el objeto indicandole su id

	}

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
	public List<IngredientesResponse> obtenerTodos() {
		
		List<IngredientesResponse> ingredientesResponseLista = new ArrayList<>(); //Creamos una lista que nos devolvera los objetos ingredientes a mostrar
		
		List<Ingredientes> ingredientesLista = ingredientesRepository.findAll(); //Creamos una lista que almacena todos los objetos de ingredientes de la BBDD
		
		
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
