package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.IngredientesRecetasResponse;
import com.help.cook.helpcook.models.IngredientesResponse;
import com.help.cook.helpcook.repository.domain.Ingredientes;
import com.help.cook.helpcook.repository.domain.RecetasIngredientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.RecetasRequest;
import com.help.cook.helpcook.models.RecetasResponse;
import com.help.cook.helpcook.repository.RecetasRepository;
import com.help.cook.helpcook.repository.domain.Recetas;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecetasBusinessImpl implements IRecetasBusiness {

    @Autowired
    private RecetasRepository recetasRepository;

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
        //    recetas.setValoracionMedia(request.getValoracionMedia());
        recetas.setComensales(request.getComensales());
        Set<RecetasIngredientes> recetasIngredientesSet = new HashSet<>();

        for (IngredientesRecetasResponse ingredientesRecetasResponse : request.getIngredientes()) {

            Ingredientes ingredienteIntermedio = new Ingredientes();
            Recetas recetasIntermedio = new Recetas();

            RecetasIngredientes recetasIngredientes = new RecetasIngredientes();


            ingredienteIntermedio.setIdIngredientes(ingredientesRecetasResponse.getId());
            recetasIntermedio.setIdRecetas(request.getIdRecetas());

            recetasIngredientes.setIngredientes(ingredienteIntermedio);
            recetasIngredientes.setRecetas(recetasIntermedio);
            recetasIngredientes.setCantidad(ingredientesRecetasResponse.getCantidad());

            recetasIngredientesSet.add(recetasIngredientes);
        }

        recetas.setIngredientes(recetasIngredientesSet);
        Recetas datoGuardado = recetasRepository.save(recetas);

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

        response.setIngredientesResponse(ingredientesResponseList);

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
