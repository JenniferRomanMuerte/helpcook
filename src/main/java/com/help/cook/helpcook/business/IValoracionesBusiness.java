package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.ValoracionesRequest;
import com.help.cook.helpcook.models.ValoracionesResponse;

public interface IValoracionesBusiness {
	
	ValoracionesResponse crear(ValoracionesRequest request);
	
	ValoracionesResponse obtener(Integer id);
	
	void eliminar(Integer id);
	
	ValoracionesResponse modificar(ValoracionesRequest request, Integer id);

}
