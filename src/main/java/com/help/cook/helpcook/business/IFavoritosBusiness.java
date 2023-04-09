package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.domain.Usuarios;

/**
 * Declarada interfaz Favoritos en el paquete Business,
 * se definen los métodos que se usarán en la clase 
 * @author Jennifer
 * @version 1.0, 2022/11/05
 */
public interface IFavoritosBusiness {
	
/**
 * Método para crear un favorito, 
 * le asignamos a un nuevo Objeto Favorito los valores creados por el usuario y le asignamos el id del Usuario
 * @param request. Recibimos el objeto del Front
 * @return. Devolvemos el Favorito creado
 */
	FavoritosResponse crear(FavoritosRequest request);
	
	
/**
 * Método para recuperar los datos de un favorito por su id,
 * @param id. Recibimos el id del Favorito que queremos recuperar
 * @return. Devolvemos el favorito
 */
	FavoritosResponse obtener(Integer id);
	
	
/**
 * Método para borrar un favorito,
 * borramos de la base de datos el favorito mediante su id
 * @param id. Recibimos el identificador del favorito a borrar.
 */
	void eliminar(Integer id);

	
	/**
	 * Método para modificar un favorito,
	 * recuperamos el favorito que queremos modificar, le asignamos los nuevos valores, y lo guardamos en el repositorio
	 * asignamos al Favorito que vamos a devolver los nuevos valores
	 * @param request. Recibimos el objeto favorito con los nuevos valores
	 * @param id. Recibimos el id del Favorito a modificar
	 * @return. Devolvemos el objeto Favorito ya modificado
	 */
	FavoritosResponse modificar(FavoritosRequest request, Integer id);
	
	
	/**
	 * Método para obtener todos los favoritos,
	 *  si el párametro que recimos es nulo recibimos tods los Favoritos de la base de Datos,
	 *  si se recibe el IdUsuario mostrará los favoritos de ese usuario.
	 * @param IdUsuario.Recibimos el id del Usuario.
	 * @return. Devolvemos una Lista con los favoritos 
	 */
	List<FavoritosResponse> obtenerTodos(Integer IdUsuario);

	

}
