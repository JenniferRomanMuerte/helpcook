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

import com.help.cook.helpcook.business.IValoracionesBusiness;
import com.help.cook.helpcook.models.ValoracionesRequest;
import com.help.cook.helpcook.models.ValoracionesResponse;

@RestController
@RequestMapping("valoraciones")
public class ValoracionesController {
	
	@Autowired
	IValoracionesBusiness valoracionesBusiness;
	
	@PostMapping
	public ValoracionesResponse crear(@RequestBody ValoracionesRequest request) {
		return valoracionesBusiness.crear(request);
	}
	
	@GetMapping("/{id}")
	public ValoracionesResponse obtener(@PathVariable Integer id) {
		return valoracionesBusiness.obtener(id);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		valoracionesBusiness.eliminar(id);
	}
	
	@PutMapping ("/{id}")
	public ValoracionesResponse modificar(@RequestBody ValoracionesRequest request, @PathVariable Integer id) {
		return valoracionesBusiness.modificar(request, id);
	}

}
