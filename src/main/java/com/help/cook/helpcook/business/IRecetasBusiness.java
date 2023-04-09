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
	
	
	/**
	 * Método para crear una Receta,
	 * Asignamos los valores a una nueva receta, la guardamos en el repositorio,
	 * asignamos los valores al objeto a devolver
	 * @param request. Recibimos la receta con los valores dados por el usuario.
	 * @return.Devolvemos la Receta creada con los valores dados por el usuario
	 */
	RecetasResponse crear(RecetasRequest request);
	
	
	/**
	 * Método para recuperar los datos de una receta por su id,
	 * recuperamos la receta del repositorio, asignamos los valores al objeto a devolver
	 * @param id. Recibimos el id de la receta que se quiere obtener
	 * @return
	 */
	RecetasResponse obtener(Integer id);
	
	
	/**
	 * Método para borrar una receta
	 * @param id. Recibimos el id de la Receta que se desea borrar
	 */
	void eliminar(Integer id);
	
	RecetasResponse modificar(RecetasRequest request, Integer id);
	
	List<RecetasResponse> obtenerTodos(String categoria, List<Integer> idIngredientes, Integer idUsuario, String ordenacion);
	
	

}
