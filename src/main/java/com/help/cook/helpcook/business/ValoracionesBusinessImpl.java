package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.UsuariosResponse;
import com.help.cook.helpcook.repository.RecetasRepository;
import com.help.cook.helpcook.repository.domain.Recetas;
import com.help.cook.helpcook.repository.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.ValoracionesRequest;
import com.help.cook.helpcook.models.ValoracionesResponse;
import com.help.cook.helpcook.repository.ValoracionesRepository;
import com.help.cook.helpcook.repository.domain.Valoraciones;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * Usamos ésta clase para subir al contexto de Spring la información
 * @author Jennifer
 * @version 1.0, 2022/11/05
 */
public class ValoracionesBusinessImpl implements IValoracionesBusiness {

    @Autowired
    private ValoracionesRepository valoracionesRepository;

    @Autowired
    private RecetasRepository recetasRepository;

    @Override
    /**
	 * 
	 * Método para crear una valoración
	 * 
	 * @param valoraciones. Creamos una valoración a la cúal le asignaremos los valores que manda el usuario
	 * @param usuarios. Creamos un usuario para asignarle la valoración
	 * @param response. Creamos la valoración que vamos a devolver
	 * @param usuariosResponse. Creamos el usuario que vamos a devolver
	 * Se asignan los valores recibidos del front(del objeto request) a los atributos de la valoración
	 * Se asigna al usurio su id para poder identificarlo y se le agigna a la valoración ese Usuario
	 * 
	 * @param datoGuardado. Creamos un nuevo objeto valoraciones (datoGuardado) asignandole la valoración que hemos creado y guardado en el repositorio
	 * 
	 * Se llama a la función valoracionMedia para calcular la media con la nueva valoracion creada
	 * 
	 * Asignamos a la valoración que vamos a devolver(response) los valores de la valoración(datoGuardado) 
	 * Asignamos al Usuario que se devuelve los valores que recuperamos de la valoracion
	 * Asignamos a la valoracion el usuario 
	 * 
	 * @return. Devuelve la valoración que hemos creado con los datos dados por el usuario
	 */
    public ValoracionesResponse crear(ValoracionesRequest request) {

        Valoraciones valoraciones = new Valoraciones();
        Usuarios usuarios = new Usuarios();

        ValoracionesResponse response = new ValoracionesResponse();
        UsuariosResponse usuariosResponse = new UsuariosResponse();
        valoraciones.setIdRecetas(request.getIdRecetas());
        valoraciones.setValor(request.getValor());

        usuarios.setId(request.getIdUsuarios());
        valoraciones.setUsuarios(usuarios);
        
        Valoraciones datoGuardado = valoracionesRepository.save(valoraciones);

        
        valoracionMedia(datoGuardado.getIdRecetas());

        response.setIdValoraciones(datoGuardado.getIdValoraciones());
        response.setIdRecetas(datoGuardado.getIdRecetas());
        response.setValor(datoGuardado.getValor());

        usuariosResponse.setApellido(valoraciones.getUsuarios().getApellido());
        usuariosResponse.setNombre(valoraciones.getUsuarios().getNombre());
        usuariosResponse.setNick(valoraciones.getUsuarios().getNick());

        response.setUsuario(usuariosResponse);

        return response;

    }

    @Override
    /**
	 * Método para recuperar los datos de una valoración por su id
	 * 
	 * @param respònse. Creamos el objeto valoraciones que vamos a devolver
	 * @param datoGuardado. Recuperamos el objeto valoraciones del repositorio y lo almacenamos
	 * Asignamos al objeto valoraciones a devolver los valores de la valoración guardada
	 * @param usuariosResponse. Creamos el Usuario que se va a devolver
	 * Se le asignan los datos del Usuario que estaban guardados en la valoracion del repositorio
	 * Se le asigana a la valoración que se devuelve el usuario
	 * 
	 * @return. Devolvemos la valoración
	 * 
	 */
    public ValoracionesResponse obtener(Integer id) {

        ValoracionesResponse response = new ValoracionesResponse();

        Valoraciones datoGuardado = valoracionesRepository.findById(id).get();

        response.setIdValoraciones(datoGuardado.getIdValoraciones());
        response.setIdRecetas(datoGuardado.getIdRecetas());
        response.setValor(datoGuardado.getValor());

        UsuariosResponse usuariosResponse = new UsuariosResponse();

        usuariosResponse.setApellido(datoGuardado.getUsuarios().getApellido());
        usuariosResponse.setNombre(datoGuardado.getUsuarios().getNombre());
        usuariosResponse.setNick(datoGuardado.getUsuarios().getNick());

        response.setUsuario(usuariosResponse);

        return response;
    }

    /**
	 * Método para borrar una valoración
	 * Borramos de la base de datos la valoracion mediante su id
	 * @param idReceta. Recuperamos la receta a la que pertenece la valoración
	 * Llamamos a la función valoración media para calcular la nueva valoración pasandole la Receta
	 */
    public void eliminar(Integer id) {
    	
    	Integer idReceta = valoracionesRepository.findById(id).get().getIdRecetas();
    	
        valoracionesRepository.deleteById(id);
        
        
        valoracionMedia(idReceta);
        
        
    }

    @Override
    /**
	 * Método para modificar los valores de una valoración
	 * 
	 * @param response. Creamos la valoración que se va a devolver
	 * @param datoGuardado. Recuperamos la valoración del repositorio mediante su id
	 * Asignamos a la valoración que hemos recuperado los valores dados por el usuario
	 * @param datoModificado. Creamos una valoración con los datos ya modificados y guardamos en el repositorio
	 * Asignamos a la valoración a devolver los nuevos datos
	 * @param usuariosResponse. Creamos el usuario que se va a devolver en la valoración
	 * Llamamos a la función valoracionMedia para el calculo después de haberse modificado
	 * Asignamos al Usuario a devolver los datos que se han guardado y asignamos éste usuario a la valoracióin a devolver
	 * 
	 * @return. Devolvemos la valoración ya modificada.
	 */

    public ValoracionesResponse modificar(ValoracionesRequest request, Integer id) {

        ValoracionesResponse response = new ValoracionesResponse();

        Valoraciones datoGuardado = valoracionesRepository.findById(id).get();

        datoGuardado.setIdRecetas(request.getIdRecetas());
        datoGuardado.getUsuarios().setId(request.getIdUsuarios());
        datoGuardado.setValor(request.getValor());

        Valoraciones datoModificado = valoracionesRepository.save(datoGuardado);
        
        

        response.setIdValoraciones(datoModificado.getIdValoraciones());
        response.setIdRecetas(datoModificado.getIdRecetas());
        response.setValor(datoModificado.getValor());

        UsuariosResponse usuariosResponse = new UsuariosResponse();
               
        valoracionMedia(datoGuardado.getIdRecetas());
           
        usuariosResponse.setApellido(datoGuardado.getUsuarios().getApellido());
        usuariosResponse.setNombre(datoGuardado.getUsuarios().getNombre());
        usuariosResponse.setNick(datoGuardado.getUsuarios().getNick());

        response.setUsuario(usuariosResponse);

        return response;
    }
    
    /**
	 * Método para obtener todas las valoraciones de la base de datos
	 * 
	 * @param valoracionesResponseLista. Declaramos la lista de valoraciones que vamos a devolver
	 * @param valoracionesLista. Declaramos una lista de valoraciones que almacenará las valoraciones del repositorio, 
	 * 
	 * Recorremos la lista de valoraciones recuperando todas las valoraciones
	 * @param valoracionesResponse. Creamos la valoracion a devolver para almacenar los valores de las valoraciones del repositorio y la añadimos a la lista que vamos a devolver
	 * 
	 * @return. Devolvemosla lista de los valoraciones que hemos recuperado del repositorio
	 * 
	 */
public List<ValoracionesResponse> obtenerTodos() {
		
		List<ValoracionesResponse> valoracionesResponseLista = new ArrayList<>();
		List<Valoraciones> valoracionesLista = valoracionesRepository.findAll();
		
		for(Valoraciones valoraciones: valoracionesLista) {
			
			ValoracionesResponse valoracionesResponse = new ValoracionesResponse();
			
			
			valoracionesResponse.setIdValoraciones(valoraciones.getIdValoraciones());
			valoracionesResponse.setIdRecetas(valoraciones.getIdRecetas());
			valoracionesResponse.setValor(valoraciones.getValor());
			
			
			valoracionesResponseLista.add(valoracionesResponse);	
			
		}
		
		return valoracionesResponseLista;
	}
    

    /**
     * Calculo de la valoración media de una receta
     * @param recetaGuardada. Recuperamos la receta del repositorio.
     * @param valoracionesGuardadas. Creamos una lista para almacenar todas las valoraciones que posee una receta
     * @param sumaMedia. Variable para almacenar el calculo final
     * @param idRecetas. Dato por el que obtenemos la receta
     * Recorremos la lista de las valoraciones guardadas, accedemos a su valor,las sumamos y las almacenamos en sumaMedia
     * @param valorMedio. Calculamos la valoración media diviendo la suma de todas las valoraciones entre el número de valoraciones que existen
     * Asignamos a recetaGuardada el nuevo valor y guardamos la receta con los nuevos datos
     */
    public void valoracionMedia(Integer idRecetas) {
    	
    	 //PARA CALCULAR MEDIA DE LA VALORACIÓN DE LA RECETA
        
        Recetas recetaGuardada = recetasRepository.findById(idRecetas).get(); //Recuperamos la receta

        List<Valoraciones> valoracionesGuardadas = valoracionesRepository.findByIdRecetas(recetaGuardada.getIdRecetas()); // Recuperamos todas las valoraciones de una receta 
        int sumaMedia = 0; // Creamos una variable para almacenar todas la valoraciones
        for (Valoraciones valoracionMedia : valoracionesGuardadas) { //Recorremos la lista de todas las valoraciones que tenia la receta
            sumaMedia += valoracionMedia.getValor(); //Sumamos todas las valoraciones 
        }

        float valorMedio =  (float) sumaMedia / (valoracionesGuardadas.size()); // Calculamos la media recuperando la cantidad de valoraciones
        recetaGuardada.setValoracionMedia(valorMedio); //Asignamos el nuevo dato
        recetasRepository.save(recetaGuardada); //Guardamos el dato
    	
    }
   
}
