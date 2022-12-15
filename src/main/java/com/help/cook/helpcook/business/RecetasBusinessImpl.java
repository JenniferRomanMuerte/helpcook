package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;
import com.help.cook.helpcook.repository.RecetasRepository;
import com.help.cook.helpcook.repository.domain.Recetas;

@Service
public class RecetasBusinessImpl implements IRecetasBusiness {

	@Autowired
	private RecetasRepository recetasRepository;

	@Override
	public RecetasResponse crear(RecetasRequest request) {
		Recetas recetas = new Recetas();
		RecetasResponse response = new RecetasResponse();

		recetas.setDescripcion(request.getDescripcion());
		recetas.setTiempo(request.getTiempo());
		recetas.setFoto(request.getFoto());
		recetas.setTipo(request.getTipo());
		recetas.setCategoria(request.getCategoria());
		recetas.setFecha_alta(request.getFecha_alta());
		recetas.setValoracionMedia(request.getValoracionMedia());
		recetas.setComensales(request.getComensales());

		Recetas datoGuardado = recetasRepository.save(recetas);

		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setDescripcion(datoGuardado.getDescripcion());
		response.setTiempo(datoGuardado.getTiempo());
		response.setFoto(datoGuardado.getFoto());
		response.setTipo(datoGuardado.getTipo());
		response.setCategoria(datoGuardado.getCategoria());
		response.setFecha_alta(datoGuardado.getFecha_alta());
		response.setValoracionMedia(datoGuardado.getValoracionMedia());
		response.setComensales(datoGuardado.getComensales());

		return response;

	}
	
	@Override
	public RecetasResponse obtener(Integer id) {
		
		RecetasResponse response = new RecetasResponse();
		
		Recetas datoGuardado = recetasRepository.findById(id).get();
		
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setDescripcion(datoGuardado.getDescripcion());
		response.setTiempo(datoGuardado.getTiempo());
		response.setFoto(datoGuardado.getFoto());
		response.setTipo(datoGuardado.getTipo());
		response.setCategoria(datoGuardado.getCategoria());
		response.setFecha_alta(datoGuardado.getFecha_alta());
		response.setValoracionMedia(datoGuardado.getValoracionMedia());
		response.setComensales(datoGuardado.getComensales());
		
		return response;
		
	}
	
	public void eliminar(Integer id) {
		recetasRepository.deleteById(id);
	}
	
	@Override
	public RecetasResponse modificar(RecetasRequest request, Integer id) {
		
		RecetasResponse response = new RecetasResponse();
		
		Recetas datoGuardado = recetasRepository.findById(id).get();
		
		datoGuardado.setDescripcion(request.getDescripcion());
		datoGuardado.setTiempo(request.getTiempo());
		datoGuardado.setFoto(request.getFoto());
		datoGuardado.setTipo(request.getTipo());
		datoGuardado.setCategoria(request.getCategoria());
		datoGuardado.setFecha_alta(request.getFecha_alta());
		datoGuardado.setValoracionMedia(request.getValoracionMedia());
		datoGuardado.setComensales(request.getComensales());
		
		Recetas datoModificado = recetasRepository.save(datoGuardado);
		
		response.setIdRecetas(datoModificado.getIdRecetas());
		response.setDescripcion(datoModificado.getDescripcion());
		response.setTiempo(datoModificado.getTiempo());
		response.setFoto(datoModificado.getFoto());
		response.setTipo(datoModificado.getTipo());
		response.setCategoria(datoModificado.getCategoria());
		response.setFecha_alta(datoModificado.getFecha_alta());
		response.setValoracionMedia(datoModificado.getValoracionMedia());
		response.setComensales(datoModificado.getComensales());
		
		return response;
	}

}
