package com.help.cook.helpcook.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.IngredientesRepository;
import com.help.cook.helpcook.repository.domain.Ingredientes;

@Service
public class IngredientesBusinessImpl implements IIngredientesBusiness {

	@Autowired
	private IngredientesRepository ingredientesRepository;

	@Override
	public IngredientesResponse crear(IngredientesRequest request) {

		Ingredientes ingredientes = new Ingredientes();
		
		IngredientesResponse response = new IngredientesResponse();

		ingredientes.setCantidad(request.getCantidad());
		ingredientes.setNombre(request.getNombre());
		ingredientes.setTipo(request.getTipo());

		Ingredientes datoGuardado = ingredientesRepository.save(ingredientes);

		response.setIdIngredientes(datoGuardado.getIdIngredientes());
		response.setCantidad(datoGuardado.getCantidad());
		response.setNombre(datoGuardado.getNombre());
		response.setTipo(datoGuardado.getTipo());

		return response;
	}

	@Override
	public IngredientesResponse obtener(Integer id) {
		
		IngredientesResponse response = new IngredientesResponse(); //Creamos el objeto que devolveremos al front
		
		Ingredientes datoGuardado = ingredientesRepository.findById(id).get(); //Recuperamos el objeto de la base de datos

		response.setIdIngredientes(datoGuardado.getIdIngredientes());
		response.setCantidad(datoGuardado.getCantidad());
		response.setNombre(datoGuardado.getNombre());
		response.setTipo(datoGuardado.getTipo());
		
		return response;
	}

	public void eliminar(Integer id) {
		
		ingredientesRepository.deleteById(id);

	}
	
	@Override
	public IngredientesResponse modificar(IngredientesRequest request, Integer id) {
		
		IngredientesResponse response = new IngredientesResponse();
		
		Ingredientes datoGuardado = ingredientesRepository.findById(id).get();

		datoGuardado.setCantidad(request.getCantidad());
		datoGuardado.setNombre(request.getNombre());
		datoGuardado.setTipo(request.getTipo());
		
		Ingredientes datoModificado = ingredientesRepository.save(datoGuardado);
		
		response.setIdIngredientes(datoModificado.getIdIngredientes());
		response.setCantidad(datoModificado.getCantidad());
		response.setNombre(datoModificado.getNombre());
		response.setTipo(datoModificado.getTipo());
		
		return response;
	}

	
	/*public List<IngredientesResponse> obtenerTodos() {
		
		return null;
	}
	*/
}
