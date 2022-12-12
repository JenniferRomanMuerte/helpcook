package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.PasosRequest;
import com.help.cook.helpcook.models.PasosResponse;
import com.help.cook.helpcook.repository.PasosRepository;
import com.help.cook.helpcook.repository.domain.Pasos;

@Service
public class PasosBusinessImpl implements IPasosBusiness{
	
	@Autowired
	private PasosRepository pasosRepository;
	
	@Override
	public PasosResponse crear(PasosRequest request) {
		
		Pasos pasos = new Pasos();
		PasosResponse response = new PasosResponse();
		
		pasos.setTipo(request.getTipo());
		pasos.setDescripcion(request.getDescripcion());
		
		Pasos datoGuardado = pasosRepository.save(pasos);
		
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		
		return response;
	}

}
