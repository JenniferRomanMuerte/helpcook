package com.help.cook.helpcook.business;


import java.util.List;

import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.models.UsuariosRequest;
import com.help.cook.helpcook.models.UsuariosResponse;
import com.help.cook.helpcook.repository.UsuariosRepository;
import com.help.cook.helpcook.repository.domain.Ingredientes;


/**
 * Declarada interfaz Usuarios en el paquete Business,
 * se definen los métodos que se usarán en la clase 
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public interface IUsuariosBusiness {
	
	UsuariosResponse crear(UsuariosRequest request);

	UsuariosResponse obtener(Integer id);
	
	void eliminar(Integer id);
	
	UsuariosResponse modificar(UsuariosRequest request, Integer id);
	
	List<UsuariosResponse> obtenerTodos();

	UsuariosResponse validarUsuario(String email, String contrasenia);
	


}
