package com.help.cook.helpcook.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.models.PasosResponse;
import com.help.cook.helpcook.models.RecetasIngredientesRequest;
import com.help.cook.helpcook.models.RecetasPasosRequest;
import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;
import com.help.cook.helpcook.repository.PasosRepository;
import com.help.cook.helpcook.repository.RecetasIngredientesRepository;
import com.help.cook.helpcook.repository.RecetasRepository;
import com.help.cook.helpcook.repository.domain.Ingredientes;
import com.help.cook.helpcook.repository.domain.Pasos;
import com.help.cook.helpcook.repository.domain.Recetas;
import com.help.cook.helpcook.repository.domain.RecetasIngredientes;

@Service
/**
 * Usamos ésta clase para subir al contexto de Spring la información
 * @author Jennifer
 * @version 1.0, 2022/11/05
 */
public class RecetasBusinessImpl implements IRecetasBusiness {

    @Autowired
    private RecetasRepository recetasRepository;

    @Autowired
    private RecetasIngredientesRepository recetasIngredientesRepository;

    @Autowired
    private PasosRepository pasosRepository;

    @Override
    /**
	 * 
	 * Método para crear una Receta
	 * 
	 * @param recetas. Creamos una receta a la cúal le asignaremos los valores que manda el usuario
	 * @param response. Creamos la receta que vamos a devolver
	 * Se asignan los valores recibidos del front(del objeto Recetas request) a los atributos de la receta 
	 * @param datoGuardado. Creamos un nuevo objeto recetas (datoGuardado) asignandole la receta que hemos creado y guardamos en el repositorio
	 * 
	 * 
	 * Asignamos a la receta que vamos a devolver(response) los valores de la receta (datoGuardo)  
	 * 
	 * Como uno de los atributos de la receta es ingredientes
	 * 
	 * @return. Devuelve la receta que hemos creado con los datos dados por el usuario
	 */
    public RecetasResponse crear(RecetasRequest request) {
        Recetas recetas = new Recetas();
        RecetasResponse response = new RecetasResponse();


        recetas.setDescripcion(request.getDescripcion());
        recetas.setTiempo(request.getTiempo());
        recetas.setFoto(request.getFoto());
        recetas.setTitulo(request.getTitulo());
        recetas.setIdUsuarios(request.getIdUsuarios());
        recetas.setCategoria(request.getCategoria());
        recetas.setValoracionMedia(0F);
        recetas.setFechaAlta(Timestamp.valueOf(request.getFechaAlta().atStartOfDay()));
        recetas.setComensales(request.getComensales());

        Recetas datoGuardado = recetasRepository.save(recetas); // Guardamos la receta

        for (RecetasIngredientesRequest recetasIngredientesRequest : request.getIngredientes()) { //Recorremos el objeto de ingrediente q nos envia el front

            Ingredientes ingredienteIntermedio = new Ingredientes(); //Creamos este objeto que es para la relación
            Recetas recetasIntermedio = new Recetas(); //Creamos este objeto que es para la relación

            RecetasIngredientes recetasIngredientes = new RecetasIngredientes(); //Creamos el objeto que guardaremos en repositorio con los datos obtenidos de los objetos intermedios


            ingredienteIntermedio.setIdIngredientes(recetasIngredientesRequest.getId()); //Asignamos el id del ingredinete que llega del front al objeto ingrediente intermedio
            recetasIntermedio.setIdRecetas(datoGuardado.getIdRecetas()); //Asignamos el id de la receta que acabamos de crear al objeto de receta intermedio

            recetasIngredientes.setIngredientes(ingredienteIntermedio); //Asignamos al objeto ue vamos a guardar los valores que acabamos de conseguir
            recetasIngredientes.setRecetas(recetasIntermedio);
            recetasIngredientes.setCantidad(recetasIngredientesRequest.getCantidad());


            recetasIngredientesRepository.save(recetasIngredientes); //Guardamos en el repositorio
        }


        for (RecetasPasosRequest pasosRequest : request.getPasos()) { //Recorremos el objeto que nos llega del front

            Pasos recetaPaso = new Pasos(); //Creamos el objeto para almacenar los datos
            Recetas recetasIntermedio = new Recetas(); //Creamos este objeto intermedio para almacenar los datos de la receta que acabamos de crear

            recetasIntermedio.setIdRecetas(datoGuardado.getIdRecetas()); //Asignamos a este objeto el id de la receta 

            recetaPaso.setRecetas(recetasIntermedio); //Asignamos los valores de los atributos de éste objeto
            recetaPaso.setTipo(pasosRequest.getTipo());
            recetaPaso.setDescripcion(pasosRequest.getDescripcion());
            recetaPaso.setFoto(pasosRequest.getFoto());

            pasosRepository.save(recetaPaso);//Lo guardamos en el repositorio

        }


        response.setIdRecetas(datoGuardado.getIdRecetas());
        response.setIdUsuarios(datoGuardado.getIdUsuarios());
        response.setDescripcion(datoGuardado.getDescripcion());
        response.setTiempo(datoGuardado.getTiempo());
        response.setFoto(datoGuardado.getFoto());
        response.setTitulo(datoGuardado.getTitulo());
        response.setCategoria(datoGuardado.getCategoria());
        response.setFechaAlta(datoGuardado.getFechaAlta().toLocalDateTime().toLocalDate());
        response.setValoracionMedia(datoGuardado.getValoracionMedia());
        response.setComensales(datoGuardado.getComensales());


        return response;

    }

    @Override
    /**
	 * Método para recuperar los datos de una receta por su id
	 * 
	 * @param response. Creamos el objeto recetas que vamos a devolver
	 * @param ingredientesResponseList. Creamos una lista para almacenar los ingredientes que posee la receta
	 * @param pasosResponseList. Creamos una lista para almacenar los pasos que posee la receta
	 * @param datoGuardado. Recuperamos la receta del repositorio y la almacenamos
	 * Asignamos al objeto recetas a devolver los valores de la receta guardada
	 * @param ingredientesResponse. Recorremos la lista de ingredientes de la receta guardada y almacenamos los datos de cada ingrediente en el ingrediente a devolver,
	 * los añadimos a su lista
	 * @param pasosResponse.Recorremos la lista de pasos de la receta guardada y almacenamos los datos de cada paso en el paso a devolver,
	 * los añadimos a su lista
	 * Añadimos a la receta a devolver la lista de ingredientes y la lista de pasos
	 * @return. Devolvemos la receta
	 * 
	 */
    public RecetasResponse obtener(Integer id) {

        RecetasResponse response = new RecetasResponse();

        List<IngredientesResponse> ingredientesResponseList = new ArrayList<>();
        List<PasosResponse> pasosResponseList = new ArrayList<>();


        Recetas datoGuardado = recetasRepository.findById(id).get();

        response.setIdRecetas(datoGuardado.getIdRecetas());
        response.setDescripcion(datoGuardado.getDescripcion());
        response.setTiempo(datoGuardado.getTiempo());
        response.setFoto(datoGuardado.getFoto());
        response.setTitulo(datoGuardado.getTitulo());
        response.setCategoria(datoGuardado.getCategoria());
        response.setFechaAlta(datoGuardado.getFechaAlta().toLocalDateTime().toLocalDate());
        response.setValoracionMedia(datoGuardado.getValoracionMedia());
        response.setComensales(datoGuardado.getComensales());

        for (RecetasIngredientes ingredientesRecetas : datoGuardado.getIngredientes()) {
            IngredientesResponse ingredientesResponse = new IngredientesResponse();
            ingredientesResponse.setIdIngredientes(ingredientesRecetas.getIngredientes().getIdIngredientes());
            ingredientesResponse.setTipo(ingredientesRecetas.getIngredientes().getTipo());
            ingredientesResponse.setNombre(ingredientesRecetas.getIngredientes().getNombre());
            ingredientesResponse.setCantidad(ingredientesRecetas.getCantidad());
            ingredientesResponseList.add(ingredientesResponse);
        }

        for (Pasos pasos : datoGuardado.getPasos()) {

            PasosResponse pasosResponse = new PasosResponse();
            pasosResponse.setDescripcion(pasos.getDescripcion());
            pasosResponse.setTipo(pasos.getTipo());
            pasosResponse.setFoto(pasos.getFoto());


            pasosResponseList.add(pasosResponse);

        }

        response.setIngredientesResponse(ingredientesResponseList);
        response.setPasosResponse(pasosResponseList);

        return response;

    }
    
    /**
	 * Método para borrar una receta
	 * Borramos de la base de datos la receta mediante su id
	 */
    public void eliminar(Integer id) {
        recetasRepository.deleteById(id);
    }

    @Override
    /**
	 * Método para modificar una receta
	 * 
	 * @param response. Creamos la receta que se va a devolver
	 * @param datoGuardado. Recuperamos la receta del repositorio mediante su id
	 * Asignamos a la receta que hemos recuperado los valores dados por el usuario
	 * @param datoModificado. Creamos una receta con los datos ya modificados y guardamos en el repositorio
	 * Asignamos a la receta a devolver los nuevos datos
	 * 
	 * @return. Devolvemos la receta ya modificada.
	 */
    public RecetasResponse modificar(RecetasRequest request, Integer id) {

        RecetasResponse response = new RecetasResponse();

        Recetas datoGuardado = recetasRepository.findById(id).get();

        datoGuardado.setDescripcion(request.getDescripcion());
        datoGuardado.setTiempo(request.getTiempo());
        datoGuardado.setFoto(request.getFoto());
        datoGuardado.setTitulo(request.getTitulo());
        datoGuardado.setCategoria(request.getCategoria());
        datoGuardado.setFechaAlta(Timestamp.valueOf(request.getFechaAlta().atStartOfDay()));
        datoGuardado.setValoracionMedia(request.getValoracionMedia());
        datoGuardado.setComensales(request.getComensales());

        Recetas datoModificado = recetasRepository.save(datoGuardado);

        response.setIdRecetas(datoModificado.getIdRecetas());
        response.setDescripcion(datoModificado.getDescripcion());
        response.setTiempo(datoModificado.getTiempo());
        response.setFoto(datoModificado.getFoto());
        response.setTitulo(datoModificado.getTitulo());
        response.setCategoria(datoModificado.getCategoria());
        response.setFechaAlta(datoModificado.getFechaAlta().toLocalDateTime().toLocalDate());
        response.setValoracionMedia(datoModificado.getValoracionMedia());
        response.setComensales(datoModificado.getComensales());

        return response;
    }

    @Override
    /**
	 * Método para obtener todas las recetas de la base de datos
	 * 
	 * @param recetasResponseLista. Declaramos la lista de recetas que vamos a devolver
	 * @param recetasLista. Declaramos una lista de recetas que almacenará las recetas del repositorio, 
	 * pudiendo filtrar las recetas que nos devuelve dependiendo de los datos que mande el usuario, mostrando todas, sólo las que posean la categoria que mande el usuario,
	 * las que contengan esos ingredientes o las que haya añadido un Usuario.
	 * Recorremos la lista de recetas recuperando todas las recetas que necesitemos según los datos mandados
	 * @param recetasResponse. Creamos la receta que vamos a devolver asignandole los valores que recuperamos de la receta guardada
	 * 
	 * @param ingredientesResponseList. Declaramos un lista de ingredientes para almacenar los ingredientes que posee la receta
	 * @param pasosResponseList. Declaramos un lista de pasos para almacenar los pasos que posee la receta
	 * 
	 * Recorremos los ingredientes y los pasos de la receta los almacenamos en el objeto a devolver y lo añadimos a su respectiva lista añadiendola después a la receta a devolver
	 * 
	 * @return. Devolvemos la lista de las recetas que hemos recuperado del repositorio
	 * 
	 */
    public List<RecetasResponse> obtenerTodos(String categoria, List<Integer> idIngredientes, Integer idUsuario) {
    	
        List<RecetasResponse> recetasResponseLista = new ArrayList();

        Set<Recetas> recetasLista = recetasRepository.findAdvance(categoria, idIngredientes, idUsuario);

        for (Recetas receta : recetasLista) {
            RecetasResponse recetasResponse = new RecetasResponse();
            List<IngredientesResponse> ingredientesResponseList = new ArrayList<>();
            List<PasosResponse> pasosResponseList = new ArrayList<>();

            recetasResponse.setIdRecetas(receta.getIdRecetas());
            recetasResponse.setIdUsuarios(receta.getIdUsuarios());
            recetasResponse.setDescripcion(receta.getDescripcion());
            recetasResponse.setTiempo(receta.getTiempo());
            recetasResponse.setFoto(receta.getFoto());
            recetasResponse.setTitulo(receta.getTitulo());
            recetasResponse.setCategoria(receta.getCategoria());
            recetasResponse.setFechaAlta(receta.getFechaAlta().toLocalDateTime().toLocalDate());
            recetasResponse.setValoracionMedia(receta.getValoracionMedia());
            recetasResponse.setComensales(receta.getComensales());


            for (RecetasIngredientes ingrediente : receta.getIngredientes()) {
                IngredientesResponse ingredientesResponse = new IngredientesResponse();
                ingredientesResponse.setIdIngredientes(ingrediente.getIngredientes().getIdIngredientes());
                ingredientesResponse.setNombre(ingrediente.getIngredientes().getNombre());
                ingredientesResponse.setTipo(ingrediente.getIngredientes().getTipo());
                ingredientesResponseList.add(ingredientesResponse);
            }
            recetasResponse.setIngredientesResponse(ingredientesResponseList);
            recetasResponseLista.add(recetasResponse);
            
            for (Pasos paso : receta.getPasos()) {
                PasosResponse pasosResponse = new PasosResponse();
                pasosResponse.setIdPasos(paso.getIdPasos());
                pasosResponse.setTipo(paso.getTipo());
                pasosResponse.setDescripcion(paso.getDescripcion());
                pasosResponse.setFoto(paso.getFoto());
                pasosResponseList.add(pasosResponse);
            }
            recetasResponse.setPasosResponse(pasosResponseList);
            recetasResponseLista.add(recetasResponse);
            
        }

        return recetasResponseLista;
    }

}
