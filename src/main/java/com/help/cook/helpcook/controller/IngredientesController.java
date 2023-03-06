package com.help.cook.helpcook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.help.cook.helpcook.business.IIngredientesBusiness;
import com.help.cook.helpcook.models.IngredientesRequest;
import com.help.cook.helpcook.models.IngredientesResponse;


// ES LA CAPA QUE CONECTARÁ CON EL FRONT
//DECLARAMOS LOS SERVICIOS REST


@RestController //Indica que es un controlador de tipo rest
@RequestMapping("ingredientes") //Le indica la ruta donde va a llamar el front
public class IngredientesController {

	@Autowired //Le indicamos que recupera la información del contexto de Spring de ésta Interface
	IIngredientesBusiness ingredientesBusiness;


	@PostMapping //Para crear
	public IngredientesResponse crear(@RequestBody  IngredientesRequest request) { //Le indicamos que coja el cuerpo del mensaje del objeto de entrada

		return ingredientesBusiness.crear(request); //Llamamos al método pasandole el objeto de entrada

	}

	@GetMapping("/{id}") //Para recuperar, le indicamos que recupere el objeto por su id
	public IngredientesResponse obtener(@PathVariable Integer id) {


		return ingredientesBusiness.obtener(id);//Llamamos al método pasandole el id del objeto
	}


	@DeleteMapping("/{id}") //Para borrar
	public void eliminar(@PathVariable Integer id) { //@PathVariable indica que en la url va una variable

	}


	@PutMapping("/{id}") //Para modificar
	public IngredientesResponse modificar(@RequestBody  IngredientesRequest request, @PathVariable Integer id) {

		return ingredientesBusiness.modificar(request,id); //Llamamos al método pasandole el objeto de entrada y el id

	}
	
	@GetMapping // Para obtener todo el listado 
	public List<IngredientesResponse> obtenerTodos(@RequestParam(required = false) String tipo) {


		return ingredientesBusiness.obtenerTodos(tipo);
	}
	
}
