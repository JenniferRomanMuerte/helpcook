package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;

public interface IFavoritosBusiness {

	FavoritosResponse crear(FavoritosRequest request);

	FavoritosResponse obtener(Integer id);

	void eliminar(Integer id);

	FavoritosResponse modificar(FavoritosRequest request, Integer id);

}
