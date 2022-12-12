package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.models.UsuariosRequest;
import com.help.cook.helpcook.models.UsuariosResponse;
import com.help.cook.helpcook.repository.UsuariosRepository;
import com.help.cook.helpcook.repository.domain.Ingredientes;
import com.help.cook.helpcook.repository.domain.Usuarios;

@Service
public class UsuariosBusinessImpl implements IUsuariosBusiness {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	

	@Override
	public UsuariosResponse crear(UsuariosRequest request) {
		
		Usuarios usuarios = new Usuarios();
		UsuariosResponse response = new UsuariosResponse();
		
		usuarios.setIdUsuarios(request.getIdUsuarios());
		usuarios.setNick(request.getNick());
		usuarios.setContraseña(request.getContraseña());
		usuarios.setNombre(request.getNombre());
		usuarios.setApellido(request.getApellido());
		usuarios.setEmail(request.getEmail());
		usuarios.setFoto(request.getFoto());
	
		
		Usuarios datoGuardado = usuariosRepository.save(usuarios);
		
		response.setIdUsuarios(datoGuardado.getIdUsuarios());
		response.setNick(datoGuardado.getNick());
		response.setContraseña(datoGuardado.getContraseña());
		response.setNombre(datoGuardado.getNombre());
		response.setApellido(datoGuardado.getApellido());
		response.setEmail(datoGuardado.getEmail());
		response.setFoto(datoGuardado.getFoto());
		
		return response;
	}

}
