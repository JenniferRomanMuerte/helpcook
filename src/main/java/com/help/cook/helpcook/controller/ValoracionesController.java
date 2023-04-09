package com.help.cook.helpcook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.cook.helpcook.business.IValoracionesBusiness;
import com.help.cook.helpcook.models.UsuariosResponse;
import com.help.cook.helpcook.models.ValoracionesRequest;
import com.help.cook.helpcook.models.ValoracionesResponse;

@RestController
@RequestMapping("valoraciones")
/**
 * Clase para la conexión con el Front 
 * @author Jennifer
 *@version 1.0, 2022/11/05
 */
public class ValoracionesController {
	
	@Autowired
	IValoracionesBusiness valoracionesBusiness;
	
	@PostMapping
	/**
	 * Método de comunicacion con el Front para crear una valoracion
	 * @param request. El usuario nos manda los valores para crear la valoracion
	 * @return devolvemos la valoracion creada con los datos introducidos por el usuario que nos devuelve el método business 
	 */
	public ValoracionesResponse crear(@RequestBody ValoracionesRequest request) {
		return valoracionesBusiness.crear(request);
	}
	
	@GetMapping("/{id}")
	/**
	 * Método de comunicacion con el Front para obtener una valoracion
	 * @param id. Recibimos el id de la valoracion que el usuario quiere visualizar
	 * @return devolvemos la valoracion seleccionada que nos devuelve el método business 
	 */
	public ValoracionesResponse obtener(@PathVariable Integer id) {
		return valoracionesBusiness.obtener(id);
	}
	
	@DeleteMapping("/{id}")
	/**
	 * Método de comunicacion con el Front  para borrar una valoracion
	 * @param id. Recibimos el id del ingrediente a borrar
	 */
	public void eliminar(@PathVariable Integer id) {
		valoracionesBusiness.eliminar(id);
	}
	
	@PutMapping ("/{id}")
	/**
	 * Método de comunicacion con el Front para modificar una valoracion
	 * @param request. Recibimos los nuevos valores de la valoracion
	 * @param id. Recibimos el id de la valoracion que se quiere modificar
	 * @return. Devolvemos la valoracion que nos devuelve el método business 
	 */
	public ValoracionesResponse modificar(@RequestBody ValoracionesRequest request, @PathVariable Integer id) {
		return valoracionesBusiness.modificar(request, id);
	}
	
	@GetMapping
	/**
	 * Método de comunicacion con el Front  para recuperar todas las valoraciones
	 * @return devolvemos la lista de valoraciones que nos devuelve el método business 
	 */
	public List<ValoracionesResponse> obtenerTodos(){
		return valoracionesBusiness.obtenerTodos();
	}
	

}
