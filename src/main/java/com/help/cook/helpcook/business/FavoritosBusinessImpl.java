package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.FavoritosRepository;
import com.help.cook.helpcook.repository.IngredientesRepository;
import com.help.cook.helpcook.repository.domain.Favoritos;
import com.help.cook.helpcook.repository.domain.Ingredientes;

@Service
public class FavoritosBusinessImpl implements IFavoritosBusiness {

	@Autowired
	private FavoritosRepository favoritosRepository;

	@Override
	public FavoritosResponse crear(FavoritosRequest request) {

		Favoritos favoritos = new Favoritos();

		FavoritosResponse response = new FavoritosResponse();

		favoritos.setIdRecetas(request.getIdRecetas());
		favoritos.getUsuarios().setIdUsuarios(request.getIdUsuarios());
		favoritos.setDescripcion(request.getDescripcion());

		Favoritos datoGuardado = favoritosRepository.save(favoritos);

		response.setIdFavoritos(datoGuardado.getIdFavoritos());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getUsuarios().getIdUsuarios());
		response.setDescripcion(datoGuardado.getDescripcion());

		return response;
	}

	@Override
	public FavoritosResponse obtener(Integer id) {

		FavoritosResponse response = new FavoritosResponse(); // Creamos el objeto que devolveremos al front

		Favoritos datoGuardado = favoritosRepository.findById(id).get(); // Recuperamos el objeto de la base de datos

		response.setIdFavoritos(datoGuardado.getIdFavoritos());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getUsuarios().getIdUsuarios());
		response.setDescripcion(datoGuardado.getDescripcion());

		return response;
	}

	@Override
	public void eliminar(Integer id) {

		favoritosRepository.deleteById(id);

	}

	@Override
	public FavoritosResponse modificar(FavoritosRequest request, Integer id) {

		FavoritosResponse response = new FavoritosResponse();

		Favoritos datoGuardado = favoritosRepository.findById(id).get();

		datoGuardado.setIdRecetas(request.getIdRecetas());
		datoGuardado.getUsuarios().setIdUsuarios(request.getIdUsuarios());
		datoGuardado.setDescripcion(request.getDescripcion());

		Favoritos datoModificado = favoritosRepository.save(datoGuardado);

		response.setIdFavoritos(datoModificado.getIdFavoritos());
		response.setIdRecetas(datoModificado.getIdRecetas());
		response.setIdUsuarios(datoModificado.getUsuarios().getIdUsuarios());
		response.setDescripcion(datoModificado.getDescripcion());

		return response;
	}
	/*
	 * public List<FavoritosResponse> obtenerTodos() {
	 * 
	 * return null; }
	 */

}
