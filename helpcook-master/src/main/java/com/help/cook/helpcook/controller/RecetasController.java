package com.help.cook.helpcook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IRecetasBusiness;
import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;

@RestController(value = "recetas")
public class RecetasController {
	@Autowired
	IRecetasBusiness recetasBusiness;
	
	
	@PostMapping
	public RecetasResponse crear(RecetasRequest request) {
		
		return recetasBusiness.crear(request);
				
	}
}