package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;

public interface IRecetasBusiness {
	
	RecetasResponse crear(RecetasRequest request);
	
	RecetasResponse obtener(Integer id);
	
	void eliminar(Integer id);
	
	RecetasResponse modificar(RecetasRequest request, Integer id);
	
	List<RecetasResponse> obtenerTodos();
	
	

}
