package com.help.cook.helpcook.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IUsuariosBusiness;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.models.RecetasResponse;
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
	public UsuariosResponse obtener(@PathVariable Integer id) {
		return usuariosBusiness.obtener(id);
	}

	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		usuariosBusiness.eliminar(id);
		
	}

	
	@PutMapping("/{id}")
	public UsuariosResponse modificar(@RequestBody  UsuariosRequest request, @PathVariable Integer id) {
		
		return usuariosBusiness.modificar(request,id);
		
	}
	

	@GetMapping
	public List<UsuariosResponse> obtenerTodos(){
		return usuariosBusiness.obtenerTodos();
	}
	

}
