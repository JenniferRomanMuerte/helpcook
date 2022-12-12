package com.help.cook.helpcook.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.IngredientesRequest;
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
	
	@Override
	public UsuariosResponse obtener(Integer id) {
		UsuariosResponse response = new UsuariosResponse();

		Usuarios datoGuardado = usuariosRepository.findById(id).get();

		response.setNick(datoGuardado.getNick());
		response.setContraseña(datoGuardado.getContraseña());
		response.setNombre(datoGuardado.getNombre());
		response.setApellido(datoGuardado.getApellido());
		response.setEmail(datoGuardado.getEmail());
		response.setFoto(datoGuardado.getFoto());
		
		return response;
	}
	
	
	public void eliminar(Integer id) {
		usuariosRepository.deleteById(id);

	}
	
	
	public UsuariosResponse modificar(UsuariosRequest request, Integer id) {
		UsuariosResponse response = new UsuariosResponse();
		
		Usuarios usuario = usuariosRepository.findById(id).get();

		usuario.setNick(request.getNick());
		usuario.setContraseña(request.getContraseña());
		usuario.setNombre(request.getNombre());
		usuario.setApellido(request.getApellido());
		usuario.setEmail(request.getEmail());
		usuario.setFoto(request.getFoto());
		
		Usuarios datoModificado = usuariosRepository.save(usuario);
		
		response.setIdUsuarios(datoModificado.getIdUsuarios());
		response.setNick(datoModificado.getNick());
		response.setContraseña(datoModificado.getContraseña());
		response.setNombre(datoModificado.getNombre());
		response.setApellido(datoModificado.getApellido());
		response.setEmail(datoModificado.getEmail());
		response.setFoto(datoModificado.getFoto());
		
		return response;
	}
	

	/*public List<UsuariosResponse> obtenerTodos() {
	
		return null;
	}
	*/
	
}
