package com.help.cook.helpcook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IUsuariosBusiness;
import com.help.cook.helpcook.models.UsuariosRequest;
import com.help.cook.helpcook.models.UsuariosResponse;



@RestController(value = "usuarios")
public class UsuariosController {
	

	@Autowired
	IUsuariosBusiness usuariossBusiness;
	
	
	@PostMapping
	public UsuariosResponse crear(UsuariosRequest request) {
		
		return usuariossBusiness.crear(request);
		
	}

}
