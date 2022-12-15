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

import com.help.cook.helpcook.business.IPasosBusiness;
import com.help.cook.helpcook.models.PasosRequest;
import com.help.cook.helpcook.models.PasosResponse;

@RestController
@RequestMapping("pasos")
public class PasosController {
	
	@Autowired
	IPasosBusiness pasosBusiness;
	
	@PostMapping
	public PasosResponse crear( @RequestBody PasosRequest request) {
		return pasosBusiness.crear(request);
	}
	
	@GetMapping("/{id}")
	public PasosResponse obtener(@PathVariable Integer id) {
		return pasosBusiness.obtener(id);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
	}
	
	@PutMapping("/{id}")
	public PasosResponse modificar(@RequestBody PasosRequest request, @PathVariable Integer id) {
		return pasosBusiness.modificar(request, id);
	}
	

}
