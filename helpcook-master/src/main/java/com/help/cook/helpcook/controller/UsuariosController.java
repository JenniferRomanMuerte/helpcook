package com.help.cook.helpcook.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IUsuariosBusiness;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.models.UsuariosRequest;
import com.help.cook.helpcook.models.UsuariosResponse;



@RestController
@RequestMapping("usuarios")
public class UsuariosController {
	

	@Autowired
	IUsuariosBusiness usuariosBusiness;
	
	
	@PostMapping
	public UsuariosResponse crear(@RequestBody UsuariosRequest request) {
		
		return usuariosBusiness.crear(request);
		
	}
	
	@GetMapping("/{id}")
	public UsuariosResponse obtener(@PathParam(value = "id") int id) {
		
		
		
		return null;
	}

	
	@DeleteMapping("/{id}")
	public UsuariosResponse eliminar(@PathParam(value = "id") int id) {
		
		return null;
	}

	
	@PutMapping("/{id}")
	public UsuariosResponse modificar(@RequestBody  IngredientesRequest request, @PathParam(value = "id") int id) {
		
		return null;
		
	}

}
