package com.help.cook.helpcook.business;

import java.util.List;

import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.domain.Usuarios;

public interface IFavoritosBusiness {

	FavoritosResponse crear(FavoritosRequest request);

	FavoritosResponse obtener(Integer id);

	void eliminar(Integer id);

	FavoritosResponse modificar(FavoritosRequest request, Integer id);
	
	List<FavoritosResponse> obtenerTodos(Integer IdUsuarios);

}
