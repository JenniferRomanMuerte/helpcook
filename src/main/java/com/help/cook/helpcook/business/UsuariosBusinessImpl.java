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
/**
 * Clase con la lógica del Negocio
 * @author Jennifer
 * @version 1.0, 2022/11/05
 */
public class UsuariosBusinessImpl implements IUsuariosBusiness {

    @Autowired
    private UsuariosRepository usuariosRepository;


    @Override
    /**
	 * 
	 * Método para crear un usuario
	 * 
	 * @param ususarios. Creamos un usuario al cúal le asignaremos los valores que manda el usuario
	 * @param response. Creamos el usuario que vamos a devolver
	 * Se asignan los valores recibidos del front(del objeto usuarios request) a los atributos del usuario
	 * @param datoGuardado. Creamos un nuevo objeto usuarios (datoGuardado) asignandole el usuario que hemos creado y guardado en el repositorio
	 * Asignamos al usuario que vamos a devolver(response) los valores del usuario (datoGuardo)  
	 * 
	 * @return. Devuelve el usuario que hemos creado con los datos dados por el usuario
	 */
    public UsuariosResponse crear(UsuariosRequest request) {

        Usuarios usuarios = new Usuarios();

        UsuariosResponse response = new UsuariosResponse();


        usuarios.setNick(request.getNick());
        usuarios.setContrasenia(request.getContrasenia());
        usuarios.setNombre(request.getNombre());
        usuarios.setApellido(request.getApellido());
        usuarios.setEmail(request.getEmail());
        usuarios.setFoto(request.getFoto());


        Usuarios datoGuardado = usuariosRepository.save(usuarios);

        response.setIdUsuarios(datoGuardado.getId());
        response.setNick(datoGuardado.getNick());
        response.setContrasenia(datoGuardado.getContrasenia());
        response.setNombre(datoGuardado.getNombre());
        response.setApellido(datoGuardado.getApellido());
        response.setEmail(datoGuardado.getEmail());
        response.setFoto(datoGuardado.getFoto());

        return response;
    }


    @Override
    /**
	 * Método para recuperar los datos de un usuario por su id
	 * 
	 * @param respònse. Creamos el objeto usuario que vamos a devolver
	 * @param datoGuardado. Recuperamos el usuario por su id del repositorio y lo almacenamos
	 * Asignamos al usuario a devolver los valores del usuario guardado
	 * 
	 * @param favoritosResponseList. Creamos una lista para almacenar los favoritos que tiene guardado el usuario
	 * @favoritos. Recorremos la lista de favoritos del usuario guardado en el repositorio, y los guardamos
	 * @favoritosResponse. Asignamos los valores del favorito que acabamos de recuperar y lo metemos en la lista de Favoritos que vamos a devolver
	 * Asignamosa los favoritos del Usuario que vamos a devolver la lista de favoritos 
	 * 
	 * @param valoracionesResponseList. Creamos una lista para almacenar las valoraciones que tiene guardado el usuario
	 * @param valoraciones. Recorremos la lista de valoraciones del usuario guardado en el repositorio, y los guardamos
	 * @param valoracionesResponse. Asignamos los valores de las valoraciones que acabamos de recuperar y lo metemos en la lista de Valoraciones que vamos a devolver
	 * Asignamos las valoraciones del Usuario que vamos a devolver la lista de valoraciones 
	 * 
	 * @return. Devolvemos el usuario
	 * 
	 */
    public UsuariosResponse obtener(Integer id) {

        UsuariosResponse response = new UsuariosResponse();
        
        List<FavoritosResponse> favoritosResponseList = new ArrayList<>();
        
        List<ValoracionesResponse> valoracionesResponseList = new ArrayList<>();

        Usuarios datoGuardado = usuariosRepository.findById(id).get();
        
        response.setIdUsuarios(datoGuardado.getId());
        response.setNick(datoGuardado.getNick());
        response.setContrasenia(datoGuardado.getContrasenia());
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
    
    
    
    public UsuariosResponse validarUsuario(String email, String contrasenia) {
    	
    	UsuariosResponse response = new UsuariosResponse();
    	
    	 List<FavoritosResponse> favoritosResponseList = new ArrayList<>();
         List<ValoracionesResponse> valoracionesResponseList = new ArrayList<>();
    	
    	Usuarios datoGuardado = usuariosRepository.findByEmailAndContrasenia(email,contrasenia);
    	
    	  response.setIdUsuarios(datoGuardado.getId());
          response.setNick(datoGuardado.getNick());
          response.setContrasenia(datoGuardado.getContrasenia());
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

    /**
	 * Método para borrar un usuario
	 * Borramos de la base de datos el usuario mediante su id
	 */
    public void eliminar(Integer id) {
        usuariosRepository.deleteById(id);

    }


    
    /**
	 * Método para modificar los valores de un usuario
	 * 
	 * @param response. Creamos el usuario que se va a devolver
	 * @param datoGuardado. Recuperamos el usuario del repositorio mediante su id
	 * Asignamos al usuario que hemos recuperado los valores dados por el usuario
	 * @param datoModificado. Creamos un usuario con los datos ya modificados y guardamos en el repositorio
	 * Asignamos al usuario a devolver los nuevos datos
	 * 
	 * @return. Devolvemos el usuario ya modificado.
	 */
    public UsuariosResponse modificar(UsuariosRequest request, Integer id) {

        UsuariosResponse response = new UsuariosResponse();

        Usuarios usuario = usuariosRepository.findById(id).get();

        usuario.setNick(request.getNick());
        usuario.setContrasenia(request.getContrasenia());
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setFoto(request.getFoto());

        Usuarios datoModificado = usuariosRepository.save(usuario);

        response.setIdUsuarios(datoModificado.getId());
        response.setNick(datoModificado.getNick());
        response.setContrasenia(datoModificado.getContrasenia());
        response.setNombre(datoModificado.getNombre());
        response.setApellido(datoModificado.getApellido());
        response.setEmail(datoModificado.getEmail());
        response.setFoto(datoModificado.getFoto());

        return response;
    }
	
    /**
	 * Método para obtener todos los usuarios de la base de datos
	 * 
	 * @param usuariosResponseLista. Declaramos la lista de usuarios que vamos a devolver
	 * @param usuariosLista. Declaramos una lista de usuarios que almacenará los usuarios del repositorio
	 * 
	 * Recorremos la lista de usuarios recuperando todos los usuarios
	 * @param usuariosResponse. Creamos el usuario a devolver para almacenar los valores del usuario del repositorio y lo añadimos a la lista que vamos a devolver
	 * 
	 * @return. Devolvemosla lista de los usuarios que hemos recuperado del repositorio
	 * 
	 */
	public List<UsuariosResponse> obtenerTodos() {
		
		List<UsuariosResponse> usuariosResponseLista = new ArrayList<>();
		
		List<Usuarios> usuariosLista = usuariosRepository.findAll();
		
		for(Usuarios usuario: usuariosLista) {
			
			UsuariosResponse usuariosResponse = new UsuariosResponse();
			
			usuariosResponse.setIdUsuarios(usuario.getId());
			usuariosResponse.setContrasenia(usuario.getContrasenia());
			usuariosResponse.setNick(usuario.getNick());
			usuariosResponse.setNombre(usuario.getNombre());
			usuariosResponse.setApellido(usuario.getApellido());
			usuariosResponse.setEmail(usuario.getEmail());
			usuariosResponse.setFoto(usuario.getFoto());
			
			usuariosResponseLista.add(usuariosResponse);	
			
		}
		
		
	
		return usuariosResponseLista;
	}
	

}
