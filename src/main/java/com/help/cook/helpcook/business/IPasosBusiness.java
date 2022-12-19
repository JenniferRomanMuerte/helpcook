package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.PasosRequest;
import com.help.cook.helpcook.models.PasosResponse;

public interface IPasosBusiness {

	PasosResponse crear(PasosRequest request);
	
	PasosResponse obtener(Integer id);
	
	void eliminar(Integer id);
	
	PasosResponse modificar(PasosRequest request, Integer id);
	
	List<PasosResponse> obtenerTodos();

}
