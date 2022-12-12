package com.help.cook.helpcook.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IIngredientesBusiness;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;

@RestController
@RequestMapping("ingredientes")
public class IngredientesController {
	
	@Autowired
	IIngredientesBusiness ingredientesBusiness;
	
	
	@PostMapping
	public IngredientesResponse crear(@RequestBody  IngredientesRequest request) {
		
		return ingredientesBusiness.crear(request);
		
	}
	
	@GetMapping("/{id}")
	public IngredientesResponse obtener(@PathParam(value = "id") String id) {
		
		return null;
	}

	
	@DeleteMapping("/{id}")
	public IngredientesResponse eliminar(@PathParam(value = "id") String id) {
		
		return null;
	}

	
	@PutMapping("/{id}")
	public IngredientesResponse modificar(@RequestBody  IngredientesRequest request, @PathParam(value = "id") String id) {
		
		return null;
		
	}
}
