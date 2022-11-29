package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;

public interface IIngredientesBusiness {

	IngredientesResponse crear(IngredientesRequest request);

}
