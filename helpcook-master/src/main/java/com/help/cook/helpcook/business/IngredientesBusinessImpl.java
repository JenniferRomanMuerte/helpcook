package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.IngredientesRepository;
import com.help.cook.helpcook.repository.domain.Ingredientes;

@Service
public class IngredientesBusinessImpl implements  IIngredientesBusiness{
	
	@Autowired
	private  IngredientesRepository ingredientesRepository;
	
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

}
