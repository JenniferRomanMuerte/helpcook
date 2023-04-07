package com.help.cook.helpcook.business;

import java.util.ArrayList;
import java.util.List;

import com.help.cook.helpcook.repository.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.repository.FavoritosRepository;
import com.help.cook.helpcook.repository.domain.Favoritos;

@Service
/**
 * Usamos ésta clase para subir al contexto de Spring la información
 * @author Jennifer
 * @version 1.0, 2022/11/05
 */
public class FavoritosBusinessImpl implements IFavoritosBusiness {

	@Autowired
	private FavoritosRepository favoritosRepository;

	@Override
	/**
	 * 
	 */
	public FavoritosResponse crear(FavoritosRequest request) {

		Favoritos favoritos = new Favoritos();

		FavoritosResponse response = new FavoritosResponse();
		Usuarios usuarios = new Usuarios();

		favoritos.setIdRecetas(request.getIdRecetas());
		favoritos.setDescripcion(request.getDescripcion());

		usuarios.setId(request.getIdUsuarios());
		favoritos.setUsuarios(usuarios);

		Favoritos datoGuardado = favoritosRepository.save(favoritos);

		response.setIdFavoritos(datoGuardado.getIdFavoritos());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getUsuarios().getId());
		response.setDescripcion(datoGuardado.getDescripcion());

		return response;
	}

	
	
	@Override
	/**
	 * Método para recuperar los datos de un favorito por su id
	 * 
	 * @param respònse. Creamos el objeto favoritos que vamos a devolver
	 * @param datoGuardado. Recuperamos el objeto favotito del repositorio y lo almacenamos,
	 * Asignamos al favorito a devolver los valores del favorito guardado
	 * 
	 * @return. Devolvemos el favorito
	 * 
	 */
	public FavoritosResponse obtener(Integer id) {

		FavoritosResponse response = new FavoritosResponse(); // Creamos el objeto que devolveremos al front

		Favoritos datoGuardado = favoritosRepository.findById(id).get(); // Recuperamos el objeto de la base de datos

		response.setIdFavoritos(datoGuardado.getIdFavoritos());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getUsuarios().getId());
		response.setDescripcion(datoGuardado.getDescripcion());

		return response;
	}

	@Override
	/**
	 * Método para borrar un favorito
	 * Borramos de la base de datos el favorito mediante su id
	 */
	public void eliminar(Integer id) {

		favoritosRepository.deleteById(id);

	}

	@Override
	/**
	 * Método para modificar un favorito
	 * 
	 * @param response. Creamos el favorito que se va a devolver
	 * @param datoGuardado. Recuperamos el favorito del repositorio mediante su id
	 * Asignamos al favorito que hemos recuperado los nuevos valores dados por el usuario
	 * @param datoModificado. Creamos un favorito con los datos ya modificados y guardados en el repositorio
	 * Asignamos al favorito a devolver los nuevos datos
	 * 
	 * @return. Devolvemos el favorito ya modificado.
	 */
	public FavoritosResponse modificar(FavoritosRequest request, Integer id) {

		FavoritosResponse response = new FavoritosResponse();

		Favoritos datoGuardado = favoritosRepository.findById(id).get();

		datoGuardado.setIdRecetas(request.getIdRecetas());
		datoGuardado.getUsuarios().setId(request.getIdUsuarios());
		datoGuardado.setDescripcion(request.getDescripcion());

		Favoritos datoModificado = favoritosRepository.save(datoGuardado);

		response.setIdFavoritos(datoModificado.getIdFavoritos());
		response.setIdRecetas(datoModificado.getIdRecetas());
		response.setIdUsuarios(datoModificado.getUsuarios().getId());
		response.setDescripcion(datoModificado.getDescripcion());

		return response;
	}
	/**
	 * Método para obtener todos los favoritos un usuario de la base de datos
	 * 
	 * @param favoritosResponseLista. Declaramos la lista de favoritos que vamos a devolver
	 * @param favoritosLista. Declaramos una lista de favoritos que almacenará los favoritos que tenga un usuario. 
	 * Recorremos la lista de favoritos recuperando todos los favoritos
	 * @param favoritosResponse. Creamos el favorito para almacenar los valores del favorito del repositorio y lo añadimos a la lista que vamos a devolver
	 * 
	 * @return. Devolvemos la lista de los favoritos que hemos recuperado del repositorio
	 * 
	 */
	 public List <FavoritosResponse> obtenerTodos(Integer idUsuario) {
		 
		List<FavoritosResponse> favoritosResponseLista = new ArrayList<>(); //Creamos una lista que nos devolvera los favoritos a mostrar
			
		List<Favoritos> favoritosLista = favoritosRepository.findByUsuarios(idUsuario); //Creamos una lista que almacena todos los objetos de favoritos de la BBDD con ese Usuario
			
			
			//Recorremos la lista
			for(Favoritos favorito: favoritosLista) {
				FavoritosResponse favoritosResponse = new FavoritosResponse(); //Creamos el objeto favoritos a devolver
				
				//Le asignamos los datos que capturamos del objeto favorito de la tabla
				favoritosResponse.setIdFavoritos(favorito.getIdFavoritos());
				favoritosResponse.setIdRecetas(favorito.getIdRecetas());
				favoritosResponse.setDescripcion(favorito.getDescripcion());
				favoritosResponse.setIdUsuarios(favorito.getUsuarios().getId());
				
				
				
				//Metemos en la lista a devolver los objetos
				favoritosResponseLista.add(favoritosResponse);
			}
		 
		 return favoritosResponseLista;
	 }
	 
	

}
