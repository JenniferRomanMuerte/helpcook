package com.help.cook.helpcook.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IUsuariosBusiness;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.models.RecetasResponse;
import com.help.cook.helpcook.models.UsuariosRequest;
import com.help.cook.helpcook.models.UsuariosResponse;



@RestController
@RequestMapping("usuarios")
/**
 * Clase para la conexión con el Front 
 * @author Hugo
 *@version 1.0, 2022/11/05
 */
public class UsuariosController {
	

	@Autowired
	IUsuariosBusiness usuariosBusiness;
	
	
	@PostMapping
	/**
	 * Método de comunicacion con el Front para crear un usuario
	 * @param request. El usuario nos manda los valores para crear el usuario
	 * @return devolvemos el usuario creado con los datos introducidos por el usuario que nos devuelve el método business 
	 */
	public UsuariosResponse crear(@RequestBody UsuariosRequest request) {
		
		return usuariosBusiness.crear(request);
		
	}
	
	@GetMapping("/{id}")
	/**
	 * Método de comunicacion con el Front para obtener un usuario
	 * @param id. Recibimos el id del usuario que el usuario quiere visualizar
	 * @return devolvemos el usuario seleccionado que nos devuelve el método business 
	 */
	public UsuariosResponse obtener(@PathVariable Integer id) {
		return usuariosBusiness.obtener(id);
	}

	@GetMapping("/{email}/{contrasenia}")
	/**
	 * Método de comunicacion con el Front para el acceso del usurio
	 * @param id. Recibimos el id del usuario que el usuario quiere visualizar
	 * @return devolvemos el usuario seleccionado que nos devuelve el método business 
	 */
	public UsuariosResponse validarUsuario(@PathVariable String email, @PathVariable String contrasenia) {
		return usuariosBusiness.validarUsuario(email,contrasenia);
	}

	
	@DeleteMapping("/{id}")
	/**
	 * Método de comunicacion con el Front  para borrar un usuario
	 * @param id. Recibimos el id del usuario a borrar
	 */
	public void eliminar(@PathVariable Integer id) {
		usuariosBusiness.eliminar(id);
		
	}

	
	@PutMapping("/{id}")
	/**
	 * Método de comunicacion con el Front para modificar un usuario
	 * @param request. Recibimos los nuevos valores del objeto usuario
	 * @param id. Recibimos el id del usuario que se quiere modificar
	 * @return. Devolvemos el usuario modificado que nos devuelve el método business 
	 */
	public UsuariosResponse modificar(@RequestBody  UsuariosRequest request, @PathVariable Integer id) {
		
		return usuariosBusiness.modificar(request,id);
		
	}
	

	@GetMapping
	/**
	 * Método de comunicacion con el Front  para recuperar todos los usuarios 
	 * @return. devolvemos una lista de usuarios que nos devuelve el método business 
	 */
	public List<UsuariosResponse> obtenerTodos(){
		return usuariosBusiness.obtenerTodos();
	}
	

}
