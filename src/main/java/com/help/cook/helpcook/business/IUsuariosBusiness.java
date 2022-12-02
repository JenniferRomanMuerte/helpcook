package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.UsuariosRequest;
import com.help.cook.helpcook.models.UsuariosResponse;

public interface IUsuariosBusiness {
	
	UsuariosResponse crear(UsuariosRequest request);

}
