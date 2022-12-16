package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.ValoracionesRequest;
import com.help.cook.helpcook.models.ValoracionesResponse;
import com.help.cook.helpcook.repository.ValoracionesRepository;
import com.help.cook.helpcook.repository.domain.Valoraciones;

@Service
public class ValoracionesBusinessImpl implements IValoracionesBusiness {
	
	@Autowired
	private ValoracionesRepository valoracionesRepository;
	
	@Override
	public ValoracionesResponse crear(ValoracionesRequest request) {
		
		Valoraciones valoraciones = new Valoraciones();
		
		ValoracionesResponse response = new ValoracionesResponse();
		
		valoraciones.setIdRecetas(request.getIdRecetas());
		valoraciones.setIdUsuarios(request.getIdUsuarios());
		valoraciones.setValor(request.getValor());
		
		Valoraciones datoGuardado = valoracionesRepository.save(valoraciones);
		
		response.setIdValoraciones(datoGuardado.getIdValoraciones());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getIdUsuarios());
		response.setValor(datoGuardado.getValor());
		
		return response;
		
	}
	
	@Override
	public ValoracionesResponse obtener(Integer id) {
		
		ValoracionesResponse response = new ValoracionesResponse();
		
		Valoraciones datoGuardado = valoracionesRepository.findById(id).get();
		
		response.setIdValoraciones(datoGuardado.getIdValoraciones());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getIdUsuarios());
		response.setValor(datoGuardado.getValor());
		
		return response;
	}
	
	public void eliminar(Integer id) {
		valoracionesRepository.deleteById(id);
	}
	
	@Override
	public ValoracionesResponse modificar(ValoracionesRequest request, Integer id) {
		
		ValoracionesResponse response = new ValoracionesResponse();
		
		Valoraciones datoGuardado = valoracionesRepository.findById(id).get();
		
		datoGuardado.setIdRecetas(request.getIdRecetas());
		datoGuardado.setIdUsuarios(request.getIdUsuarios());
		datoGuardado.setValor(request.getValor());
		
		Valoraciones datoModificado = valoracionesRepository.save(datoGuardado);
		
		response.setIdValoraciones(datoModificado.getIdValoraciones());
		response.setIdRecetas(datoModificado.getIdRecetas());
		response.setIdUsuarios(datoModificado.getIdUsuarios());
		response.setValor(datoModificado.getValor());
		
		return response;
	}
	

}
