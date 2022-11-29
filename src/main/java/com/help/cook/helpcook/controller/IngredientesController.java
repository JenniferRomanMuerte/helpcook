package com.help.cook.helpcook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IIngredientesBusiness;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;

@RestController(value = "ingredientes")
public class IngredientesController {
	
	@Autowired
	IIngredientesBusiness ingredientesBusiness;
	
	
	@PostMapping
	public IngredientesResponse crear(IngredientesRequest request) {
		
		return ingredientesBusiness.crear(request);
		
	}

}
