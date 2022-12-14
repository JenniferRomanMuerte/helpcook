package com.help.cook.helpcook.business;

import java.util.ArrayList;
import java.util.List;

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
		
		response.setIdPasos(datoGuardado.getIdPasos());
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		
		return response;
	}
	
	@Override
	public PasosResponse obtener(Integer id) {
		
		PasosResponse response = new PasosResponse();
		
		Pasos datoGuardado = pasosRepository.findById(id).get();
		
		response.setIdPasos(datoGuardado.getIdPasos());
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		
		return response;
		
	}
	
	public void eliminar(Integer id) {
		
		pasosRepository.deleteById(id);
		
	}
	
	@Override
	public PasosResponse modificar(PasosRequest request, Integer id) {
		
		PasosResponse response = new PasosResponse();
		
		Pasos datoGuardado = pasosRepository.findById(id).get();
		
		datoGuardado.setTipo(request.getTipo());
		datoGuardado.setDescripcion(request.getDescripcion());
		
		Pasos datoModificado = pasosRepository.save(datoGuardado);
		
		response.setIdPasos(datoModificado.getIdPasos());
		response.setTipo(datoModificado.getTipo());
		response.setDescripcion(datoModificado.getDescripcion());
		
		return response;
	}
	
	@Override
	public List<PasosResponse> obtenerTodos() {
		
		List <PasosResponse> pasosResponseLista = new ArrayList();
		
		List <Pasos> pasosLista = pasosRepository.findAll();
		
		for(Pasos paso : pasosLista) {
			PasosResponse pasosResponse = new PasosResponse();
			
			pasosResponse.setIdPasos(paso.getIdPasos());
			pasosResponse.setIdRecetas(paso.getIdRecetas());
			pasosResponse.setTipo(paso.getTipo());
			pasosResponse.setDescripcion(paso.getDescripcion());
			
			pasosResponseLista.add(pasosResponse);
		}
		
		return pasosResponseLista;
	}

}
