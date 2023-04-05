package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;


/**
 * Declarada interfaz Recetas en el paquete Business,
 * se definen los métodos que se usarán en la clase 
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public interface IRecetasBusiness {
	
	RecetasResponse crear(RecetasRequest request);
	
	RecetasResponse obtener(Integer id);
	
	void eliminar(Integer id);
	
	RecetasResponse modificar(RecetasRequest request, Integer id);
	
	List<RecetasResponse> obtenerTodos(String categoria, List<Integer> idIngredientes, Integer idUsuario);
	
	

}
