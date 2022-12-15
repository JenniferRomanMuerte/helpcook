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

import com.help.cook.helpcook.business.IRecetasBusiness;
import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;

@RestController
@RequestMapping("recetas")
public class RecetasController {
	@Autowired
	IRecetasBusiness recetasBusiness;
	
	
	@PostMapping
	public RecetasResponse crear(@RequestBody RecetasRequest request) {
		
		return recetasBusiness.crear(request);
				
	}
	
	@GetMapping("/{id}")
	public RecetasResponse obtener(@PathVariable Integer id) {
		return recetasBusiness.obtener(id);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
	}
	
	@PutMapping ("/{id}")
	public RecetasResponse modificar(@RequestBody RecetasRequest request, @PathVariable Integer id) {
		return recetasBusiness.modificar(request, id);
	}
}
