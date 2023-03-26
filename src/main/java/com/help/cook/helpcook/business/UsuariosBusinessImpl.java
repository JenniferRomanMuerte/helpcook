package com.help.cook.helpcook.business;

import com.help.cook.helpcook.models.*;
import com.help.cook.helpcook.repository.domain.Favoritos;
import com.help.cook.helpcook.repository.domain.Valoraciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.repository.UsuariosRepository;
import com.help.cook.helpcook.repository.domain.Usuarios;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosBusinessImpl implements IUsuariosBusiness {

    @Autowired
    private UsuariosRepository usuariosRepository;


    @Override
    public UsuariosResponse crear(UsuariosRequest request) {

        Usuarios usuarios = new Usuarios();

        UsuariosResponse response = new UsuariosResponse();


        usuarios.setNick(request.getNick());
        usuarios.setContrasenia(request.getContraseña());
        usuarios.setNombre(request.getNombre());
        usuarios.setApellido(request.getApellido());
        usuarios.setEmail(request.getEmail());
        usuarios.setFoto(request.getFoto());


        Usuarios datoGuardado = usuariosRepository.save(usuarios);

        response.setIdUsuarios(datoGuardado.getId());
        response.setNick(datoGuardado.getNick());
        response.setContraseña(datoGuardado.getContrasenia());
        response.setNombre(datoGuardado.getNombre());
        response.setApellido(datoGuardado.getApellido());
        response.setEmail(datoGuardado.getEmail());
        response.setFoto(datoGuardado.getFoto());

        return response;
    }


    @Override
    public UsuariosResponse obtener(Integer id) {

        UsuariosResponse response = new UsuariosResponse();
        List<FavoritosResponse> favoritosResponseList = new ArrayList<>();
        List<ValoracionesResponse> valoracionesResponseList = new ArrayList<>();

        Usuarios datoGuardado = usuariosRepository.findById(id).get();
        response.setIdUsuarios(datoGuardado.getId());
        response.setNick(datoGuardado.getNick());
        response.setContraseña(datoGuardado.getContrasenia());
        response.setNombre(datoGuardado.getNombre());
        response.setApellido(datoGuardado.getApellido());
        response.setEmail(datoGuardado.getEmail());
        response.setFoto(datoGuardado.getFoto());

        for (Favoritos favoritos : datoGuardado.getFavoritos()) {
            FavoritosResponse favoritosResponse = new FavoritosResponse();
            favoritosResponse.setDescripcion(favoritos.getDescripcion());
            favoritosResponseList.add(favoritosResponse);
        }

        response.setFavoritos(favoritosResponseList);

        for(Valoraciones valoraciones: datoGuardado.getValoraciones()) {
            ValoracionesResponse valoracionesResponse = new ValoracionesResponse();
            valoracionesResponse.setValor(valoraciones.getValor());
            valoracionesResponseList.add(valoracionesResponse);
        }

        response.setValoraciones(valoracionesResponseList);


        return response;
    }


    public void eliminar(Integer id) {
        usuariosRepository.deleteById(id);

    }


    public UsuariosResponse modificar(UsuariosRequest request, Integer id) {

        UsuariosResponse response = new UsuariosResponse();

        Usuarios usuario = usuariosRepository.findById(id).get();

        usuario.setNick(request.getNick());
        usuario.setContrasenia(request.getContraseña());
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setFoto(request.getFoto());

        Usuarios datoModificado = usuariosRepository.save(usuario);

        response.setIdUsuarios(datoModificado.getId());
        response.setNick(datoModificado.getNick());
        response.setContraseña(datoModificado.getContrasenia());
        response.setNombre(datoModificado.getNombre());
        response.setApellido(datoModificado.getApellido());
        response.setEmail(datoModificado.getEmail());
        response.setFoto(datoModificado.getFoto());

        return response;
    }
	

	/*public List<UsuariosResponse> obtenerTodos() {
	
		return null;
	}
	*/

}
