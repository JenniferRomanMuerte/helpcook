package com.help.cook.helpcook.business;

import java.util.ArrayList;
import java.util.List;

import com.help.cook.helpcook.repository.domain.Recetas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.PasosRequest;
import com.help.cook.helpcook.models.PasosResponse;
import com.help.cook.helpcook.repository.PasosRepository;
import com.help.cook.helpcook.repository.domain.Pasos;

@Service
/**
 * Clase con la lógica del Negocio
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public class PasosBusinessImpl implements IPasosBusiness{
	
	@Autowired
	private PasosRepository pasosRepository;
	
	@Override
	public PasosResponse crear(PasosRequest request) {
		
		Pasos pasos = new Pasos();
		PasosResponse response = new PasosResponse();
		Recetas recetas = new Recetas();

		pasos.setTipo(request.getTipo());
		pasos.setDescripcion(request.getDescripcion());
		pasos.setFoto(request.getFoto());
		recetas.setIdRecetas(request.getIdRecetas());
		pasos.setRecetas(recetas);
		
		Pasos datoGuardado = pasosRepository.save(pasos);
		
		response.setIdPasos(datoGuardado.getIdPasos());
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		response.setFoto(datoGuardado.getFoto());
		response.setIdRecetas(datoGuardado.getRecetas().getIdRecetas());
		
		return response;
	}
	
	@Override
	public PasosResponse obtener(Integer id) {
		
		PasosResponse response = new PasosResponse();
		
		Pasos datoGuardado = pasosRepository.findById(id).get();
		
		response.setIdPasos(datoGuardado.getIdPasos());
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		response.setFoto(datoGuardado.getFoto());
		response.setIdRecetas(datoGuardado.getRecetas().getIdRecetas());
		
		return response;
		
	}
	
	@Override
	public void eliminar(Integer id) {
		
		pasosRepository.deleteById(id);
		
	}
	
	@Override
	public PasosResponse modificar(PasosRequest request, Integer id) {
		
		PasosResponse response = new PasosResponse();
		
		Pasos datoGuardado = pasosRepository.findById(id).get();
		
		datoGuardado.setTipo(request.getTipo());
		datoGuardado.setDescripcion(request.getDescripcion());
		datoGuardado.setFoto(request.getFoto());
		
		Pasos datoModificado = pasosRepository.save(datoGuardado);
		
		response.setIdPasos(datoModificado.getIdPasos());
		response.setTipo(datoModificado.getTipo());
		response.setDescripcion(datoModificado.getDescripcion());
		response.setFoto(datoModificado.getFoto());
		response.setIdRecetas(datoGuardado.getRecetas().getIdRecetas());
		
		return response;
	}
	
	@Override
	public List<PasosResponse> obtenerTodos() {
		
		List <PasosResponse> pasosResponseLista = new ArrayList();
		
		List <Pasos> pasosLista = pasosRepository.findAll();
		
		for(Pasos paso : pasosLista) {
			PasosResponse pasosResponse = new PasosResponse();
			
			pasosResponse.setIdPasos(paso.getIdPasos());
			pasosResponse.setTipo(paso.getTipo());
			pasosResponse.setDescripcion(paso.getDescripcion());
			pasosResponse.setFoto(paso.getFoto());
			pasosResponse.setIdRecetas(paso.getRecetas().getIdRecetas());
			
			pasosResponseLista.add(pasosResponse);
		}
		
		return pasosResponseLista;
	}

}
