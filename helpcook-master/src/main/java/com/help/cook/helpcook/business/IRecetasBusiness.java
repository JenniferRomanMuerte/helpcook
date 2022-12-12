package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;

public interface IRecetasBusiness {
	
	RecetasResponse crear(RecetasRequest request);
	
	

}
