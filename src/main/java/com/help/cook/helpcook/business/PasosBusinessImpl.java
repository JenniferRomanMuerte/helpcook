package com.help.cook.helpcook.business;

import java.util.ArrayList;
import java.util.List;

import com.help.cook.helpcook.repository.domain.Recetas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.PasosRequest;
import com.help.cook.helpcook.models.PasosResponse;
import com.help.cook.helpcook.repository.PasosRepository;
import com.help.cook.helpcook.repository.domain.Pasos;

@Service
/**
 * Usamos ésta clase para subir al contexto de Spring la información
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public class PasosBusinessImpl implements IPasosBusiness{
	
	@Autowired
	private PasosRepository pasosRepository;
	
	@Override
	/**
	 * 
	 * Método para crear un paso
	 * 
	 * @param pasos. Creamos el paso al cúal le asignaremos los valores que manda el usuario
	 * @param response. Creamos el ingredientes que vamos a devolver
	 * @param recetas. Creamos el objeto recetas que contendrá los pasos que le mandamos
	 * Se asignan los valores recibidos del front(del objeto favoritos request) a los atributos del pasos 
	 * @param datoGuardado. Creamos un nuevo objeto ingredientes (datoGuardado) asignandole el pasos que hemos creado
	 * Asignamos al pasos que vamos a devolver(response) los valores del favorito (datoGuardo)  
	 * 
	 * @return. Devuelve el paso con los datos dados por el usuario
	 */
	public PasosResponse crear(PasosRequest request) {
		
		Pasos pasos = new Pasos();
		PasosResponse response = new PasosResponse();
		Recetas recetas = new Recetas();

		pasos.setTipo(request.getTipo());
		pasos.setDescripcion(request.getDescripcion());
		pasos.setFoto(request.getFoto());
		recetas.setIdRecetas(request.getIdRecetas());
		pasos.setRecetas(recetas);
		
		Pasos datoGuardado = pasosRepository.save(pasos);
		
		response.setIdPasos(datoGuardado.getIdPasos());
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		response.setFoto(datoGuardado.getFoto());
		response.setIdRecetas(datoGuardado.getRecetas().getIdRecetas());
		
		return response;
	}
	
	@Override
	/**
	 * Método para recuperar los datos de un paso por su id
	 * 
	 * @param respònse. Creamos el objeto pasos que vamos a devolver
	 * @param datoGuardado. Recuperamos el objeto pasos del repositorio y lo almacenamos
	 * Asignamos al objeto pasos a devolver los valores del paso guardado
	 * 
	 * @return. Devolvemos el paso
	 * 
	 */
	public PasosResponse obtener(Integer id) {
		
		PasosResponse response = new PasosResponse();
		
		Pasos datoGuardado = pasosRepository.findById(id).get();
		
		response.setIdPasos(datoGuardado.getIdPasos());
		response.setTipo(datoGuardado.getTipo());
		response.setDescripcion(datoGuardado.getDescripcion());
		response.setFoto(datoGuardado.getFoto());
		response.setIdRecetas(datoGuardado.getRecetas().getIdRecetas());
		
		return response;
		
	}
	/**
	 * Método para borrar un paso
	 * Borramos de la base de datos el paso mediante su id
	 */
	public void eliminar(Integer id) {
		
		pasosRepository.deleteById(id);
		
	}
	
	@Override
	/**
	 * Método para modificar los valores de un paso
	 * 
	 * @param response. Creamos el paso que se va a devolver
	 * @param datoGuardado. Recuperamos el paso del repositorio mediante su id
	 * Asignamos al paso que hemos recuperado los valores dados por el usuario
	 * @param datoModificado. Creamos un pasos con los datos ya modificados y guardamos en el repositorio
	 * Asignamos al paso a devolver los nuevos datos y el dato de la receta a la que pertenecia obtenida de los datos del repositorio
	 * 
	 * @return. Devolvemos el paso ya modificado.
	 */
	public PasosResponse modificar(PasosRequest request, Integer id) {
		
		PasosResponse response = new PasosResponse();
		
		Pasos datoGuardado = pasosRepository.findById(id).get();
		
		datoGuardado.setTipo(request.getTipo());
		datoGuardado.setDescripcion(request.getDescripcion());
		datoGuardado.setFoto(request.getFoto());
		
		Pasos datoModificado = pasosRepository.save(datoGuardado);
		
		response.setIdPasos(datoModificado.getIdPasos());
		response.setTipo(datoModificado.getTipo());
		response.setDescripcion(datoModificado.getDescripcion());
		response.setFoto(datoModificado.getFoto());
		response.setIdRecetas(datoGuardado.getRecetas().getIdRecetas());
		
		return response;
	}
	
	@Override
	/**
	 * Método para obtener todos los pasos de la base de datos
	 * 
	 * @param pasosResponseLista. Declaramos la lista de pasos que vamos a devolver
	 * @param pasosLista. Declaramos una lista de pasos que almacenará los pasos del repositorio, 
	 * Recorremos la lista de pasos recuperando todos los pasos
	 * @param pasosResponse. Creamos el paso para almacenar los valores del paso del repositorio y lo añadimos a la lista que vamos a devolver
	 * 
	 * @return. Devolvemosla lista de los pasos que hemos recuperado del repositorio
	 * 
	 */
	public List<PasosResponse> obtenerTodos() {
		
		List <PasosResponse> pasosResponseLista = new ArrayList();
		
		List <Pasos> pasosLista = pasosRepository.findAll();
		
		for(Pasos paso : pasosLista) {
			PasosResponse pasosResponse = new PasosResponse();
			
			pasosResponse.setIdPasos(paso.getIdPasos());
			pasosResponse.setTipo(paso.getTipo());
			pasosResponse.setDescripcion(paso.getDescripcion());
			pasosResponse.setFoto(paso.getFoto());
			pasosResponse.setIdRecetas(paso.getRecetas().getIdRecetas());
			
			pasosResponseLista.add(pasosResponse);
		}
		
		return pasosResponseLista;
	}

}
