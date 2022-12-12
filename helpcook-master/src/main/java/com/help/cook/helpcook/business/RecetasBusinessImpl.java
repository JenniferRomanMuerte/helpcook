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

}
