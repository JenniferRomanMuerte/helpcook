package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.PasosRequest;
import com.help.cook.helpcook.models.PasosResponse;


/**
 * Declarada interfaz Pasos en el paquete Business,
 * se definen los métodos que se usarán en la clase 
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public interface IPasosBusiness {

	PasosResponse crear(PasosRequest request);
	
	PasosResponse obtener(Integer id);
	
	void eliminar(Integer id);
	
	PasosResponse modificar(PasosRequest request, Integer id);
	
	List<PasosResponse> obtenerTodos();

}
