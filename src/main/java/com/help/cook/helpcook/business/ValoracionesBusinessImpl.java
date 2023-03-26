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
public class ValoracionesBusinessImpl implements IValoracionesBusiness {

    @Autowired
    private ValoracionesRepository valoracionesRepository;

    @Autowired
    private RecetasRepository recetasRepository;

    @Override
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

    public void eliminar(Integer id) {
    	
    	Integer idReceta = valoracionesRepository.findById(id).get().getIdRecetas();
    	
        valoracionesRepository.deleteById(id);
        
        
        valoracionMedia(idReceta);
        
        
    }

    @Override
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

    
    public void valoracionMedia(Integer idRecetas) {
    	
    	 //PARA CALCULAR MEDIA DE LA VALORACIÓN DE LA RECETA
        
        Recetas recetaGuardada = recetasRepository.findById(idRecetas).get(); //Recuperamos la receta

        List<Valoraciones> valoracionesGuardadas = valoracionesRepository.findByIdRecetas(recetaGuardada.getIdRecetas()); // Recuperamos todas las valoraciones de una receta 
        int sumaMedia = 0; // Creamos una variable para alamacenar todas la valoraciones
        for (Valoraciones valoracionMedia : valoracionesGuardadas) { //Recorremos la lista de todas las valoraciones que tenia la receta
            sumaMedia += valoracionMedia.getValor(); //Sumamos todas las valoraciones 
        }

        float valorMedio =  (float) sumaMedia / (valoracionesGuardadas.size()); // Calculamos la media recuperando la cantidad de valoraciones
        recetaGuardada.setValoracionMedia(valorMedio); //Asignamos el nuevo dato
        recetasRepository.save(recetaGuardada); //Guardamos el dato
    	
    }
   
}
