package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.UsuariosResponse;
import com.help.cook.helpcook.repository.RecetasRepository;
import com.help.cook.helpcook.repository.domain.Recetas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.ValoracionesRequest;
import com.help.cook.helpcook.models.ValoracionesResponse;
import com.help.cook.helpcook.repository.ValoracionesRepository;
import com.help.cook.helpcook.repository.domain.Valoraciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ValoracionesBusinessImpl implements IValoracionesBusiness {

    @Autowired
    private ValoracionesRepository valoracionesRepository;

    @Autowired
    private RecetasRepository recetasRepository;

    @Override
    public ValoracionesResponse crear(ValoracionesRequest request) {

        Valoraciones valoraciones = new Valoraciones();
        List<Integer> media = new ArrayList<>();

        ValoracionesResponse response = new ValoracionesResponse();
        UsuariosResponse usuariosResponse = new UsuariosResponse();
        valoraciones.setIdRecetas(request.getIdRecetas());
        valoraciones.getUsuarios().setIdUsuarios(request.getIdUsuarios());
        valoraciones.setValor(request.getValor());

        Valoraciones datoGuardado = valoracionesRepository.save(valoraciones);

        Recetas recetaGuardada = recetasRepository.findById(datoGuardado.getIdRecetas()).get();

        List<Valoraciones> valoracionesGuardadas = valoracionesRepository.findAll();
        long sumaMedia = request.getValor();
        for (Valoraciones valoracionMedia : valoracionesGuardadas) {
            sumaMedia += valoracionMedia.getValor();
        }

        Float valorMedio =  (float) sumaMedia / (valoracionesGuardadas.size() + 1);
        recetaGuardada.setValoracionMedia(valorMedio);
        recetasRepository.save(recetaGuardada);

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
        valoracionesRepository.deleteById(id);
    }

    @Override
    public ValoracionesResponse modificar(ValoracionesRequest request, Integer id) {

        ValoracionesResponse response = new ValoracionesResponse();

        Valoraciones datoGuardado = valoracionesRepository.findById(id).get();

        datoGuardado.setIdRecetas(request.getIdRecetas());
        datoGuardado.getUsuarios().setIdUsuarios(request.getIdUsuarios());
        datoGuardado.setValor(request.getValor());

        Valoraciones datoModificado = valoracionesRepository.save(datoGuardado);

        response.setIdValoraciones(datoModificado.getIdValoraciones());
        response.setIdRecetas(datoModificado.getIdRecetas());
        response.setValor(datoModificado.getValor());

        UsuariosResponse usuariosResponse = new UsuariosResponse();

        usuariosResponse.setApellido(datoGuardado.getUsuarios().getApellido());
        usuariosResponse.setNombre(datoGuardado.getUsuarios().getNombre());
        usuariosResponse.setNick(datoGuardado.getUsuarios().getNick());

        response.setUsuario(usuariosResponse);

        return response;
    }


}
