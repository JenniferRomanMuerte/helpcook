package com.help.cook.helpcook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	

}
