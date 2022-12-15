package com.help.cook.helpcook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IFavoritosBusiness;
import com.help.cook.helpcook.business.IIngredientesBusiness;
import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;

@RestController
@RequestMapping("favoritos")
public class FavoritosController {
	
	@Autowired
	IFavoritosBusiness favoritosBusiness;
	
	
	@PostMapping
	public FavoritosResponse crear(@RequestBody  FavoritosRequest request) {
		
		return favoritosBusiness.crear(request);
		
	}
	
	@GetMapping("/{id}")
	public FavoritosResponse obtener(@PathVariable Integer id) {
		
		
		return favoritosBusiness.obtener(id);
	}

	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
	}

	
	@PutMapping("/{id}")
	public FavoritosResponse modificar(@RequestBody  FavoritosRequest request, @PathVariable Integer id) {
		
		return favoritosBusiness.modificar(request,id);
		
	}

}
