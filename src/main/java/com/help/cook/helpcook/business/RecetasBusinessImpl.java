package com.help.cook.helpcook.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
public class RecetasBusinessImpl implements IRecetasBusiness {

    @Autowired
    private RecetasRepository recetasRepository;

    @Autowired
    private RecetasIngredientesRepository recetasIngredientesRepository;
    
    @Autowired
    private PasosRepository pasosRepository;
    
    @Override
    public RecetasResponse crear(RecetasRequest request) {
        Recetas recetas = new Recetas();
        RecetasResponse response = new RecetasResponse();


        recetas.setDescripcion(request.getDescripcion());
        recetas.setTiempo(request.getTiempo());
        recetas.setFoto(request.getFoto());
        recetas.setTipo(request.getTipo());
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
        	
        	pasosRepository.save(recetaPaso);//Lo guardamos en el repositorio
        	
        }
        
         

        
        

        response.setIdRecetas(datoGuardado.getIdRecetas());
        response.setDescripcion(datoGuardado.getDescripcion());
        response.setTiempo(datoGuardado.getTiempo());
        response.setFoto(datoGuardado.getFoto());
        response.setTipo(datoGuardado.getTipo());
        response.setCategoria(datoGuardado.getCategoria());
        response.setFechaAlta(datoGuardado.getFechaAlta().toLocalDateTime().toLocalDate());
        response.setValoracionMedia(datoGuardado.getValoracionMedia());
        response.setComensales(datoGuardado.getComensales());


        return response;

    }

    @Override
    public RecetasResponse obtener(Integer id) {

        RecetasResponse response = new RecetasResponse();

        List<IngredientesResponse> ingredientesResponseList = new ArrayList<>();
        List<PasosResponse> pasosResponseList = new ArrayList<>();


        Recetas datoGuardado = recetasRepository.findById(id).get();

        response.setIdRecetas(datoGuardado.getIdRecetas());
        response.setDescripcion(datoGuardado.getDescripcion());
        response.setTiempo(datoGuardado.getTiempo());
        response.setFoto(datoGuardado.getFoto());
        response.setTipo(datoGuardado.getTipo());
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
        
        for(Pasos pasos: datoGuardado.getPasos()) {
        	
        	PasosResponse pasosResponse = new PasosResponse();
        	pasosResponse.setDescripcion(pasos.getDescripcion());
        
        	
        	pasosResponseList.add(pasosResponse);
        	
        }

        response.setIngredientesResponse(ingredientesResponseList);
        response.setPasosResponse(pasosResponseList);

        return response;

    }

    public void eliminar(Integer id) {
        recetasRepository.deleteById(id);
    }

    @Override
    public RecetasResponse modificar(RecetasRequest request, Integer id) {

        RecetasResponse response = new RecetasResponse();

        Recetas datoGuardado = recetasRepository.findById(id).get();

        datoGuardado.setDescripcion(request.getDescripcion());
        datoGuardado.setTiempo(request.getTiempo());
        datoGuardado.setFoto(request.getFoto());
        datoGuardado.setTipo(request.getTipo());
        datoGuardado.setCategoria(request.getCategoria());
        datoGuardado.setFechaAlta(Timestamp.valueOf(request.getFechaAlta().atStartOfDay()));
        datoGuardado.setValoracionMedia(request.getValoracionMedia());
        datoGuardado.setComensales(request.getComensales());

        Recetas datoModificado = recetasRepository.save(datoGuardado);

        response.setIdRecetas(datoModificado.getIdRecetas());
        response.setDescripcion(datoModificado.getDescripcion());
        response.setTiempo(datoModificado.getTiempo());
        response.setFoto(datoModificado.getFoto());
        response.setTipo(datoModificado.getTipo());
        response.setCategoria(datoModificado.getCategoria());
        response.setFechaAlta(datoModificado.getFechaAlta().toLocalDateTime().toLocalDate());
        response.setValoracionMedia(datoModificado.getValoracionMedia());
        response.setComensales(datoModificado.getComensales());

        return response;
    }

    @Override
    public List<RecetasResponse> obtenerTodos() {
        List<RecetasResponse> recetasResponseLista = new ArrayList();

        List<Recetas> recetasLista = recetasRepository.findAll();

        for (Recetas receta : recetasLista) {
            RecetasResponse recetasResponse = new RecetasResponse();

            recetasResponse.setIdRecetas(receta.getIdRecetas());
            recetasResponse.setIdUsuarios(receta.getIdUsuarios());
            recetasResponse.setDescripcion(receta.getDescripcion());
            recetasResponse.setTiempo(receta.getTiempo());
            recetasResponse.setFoto(receta.getFoto());
            recetasResponse.setTipo(receta.getTipo());
            recetasResponse.setCategoria(receta.getCategoria());
            recetasResponse.setFechaAlta(receta.getFechaAlta().toLocalDateTime().toLocalDate());
            recetasResponse.setValoracionMedia(receta.getValoracionMedia());
            recetasResponse.setComensales(receta.getComensales());

            recetasResponseLista.add(recetasResponse);
        }

        return recetasResponseLista;
    }

}
