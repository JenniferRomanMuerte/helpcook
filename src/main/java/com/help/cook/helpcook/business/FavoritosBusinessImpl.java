package com.help.cook.helpcook.business;

import java.util.ArrayList;
import java.util.List;

import com.help.cook.helpcook.repository.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.cook.helpcook.models.FavoritosRequest;
import com.help.cook.helpcook.models.FavoritosResponse;
import com.help.cook.helpcook.repository.FavoritosRepository;
import com.help.cook.helpcook.repository.domain.Favoritos;

@Service
public class FavoritosBusinessImpl implements IFavoritosBusiness {

	@Autowired
	private FavoritosRepository favoritosRepository;

	@Override
	public FavoritosResponse crear(FavoritosRequest request) {

		Favoritos favoritos = new Favoritos();

		FavoritosResponse response = new FavoritosResponse();
		Usuarios usuarios = new Usuarios();

		favoritos.setIdRecetas(request.getIdRecetas());
		favoritos.setDescripcion(request.getDescripcion());

		usuarios.setId(request.getIdUsuarios());
		favoritos.setUsuarios(usuarios);

		Favoritos datoGuardado = favoritosRepository.save(favoritos);

		response.setIdFavoritos(datoGuardado.getIdFavoritos());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getUsuarios().getId());
		response.setDescripcion(datoGuardado.getDescripcion());

		return response;
	}

	@Override
	public FavoritosResponse obtener(Integer id) {

		FavoritosResponse response = new FavoritosResponse(); // Creamos el objeto que devolveremos al front

		Favoritos datoGuardado = favoritosRepository.findById(id).get(); // Recuperamos el objeto de la base de datos

		response.setIdFavoritos(datoGuardado.getIdFavoritos());
		response.setIdRecetas(datoGuardado.getIdRecetas());
		response.setIdUsuarios(datoGuardado.getUsuarios().getId());
		response.setDescripcion(datoGuardado.getDescripcion());

		return response;
	}

	@Override
	public void eliminar(Integer id) {

		favoritosRepository.deleteById(id);

	}

	@Override
	public FavoritosResponse modificar(FavoritosRequest request, Integer id) {

		FavoritosResponse response = new FavoritosResponse();

		Favoritos datoGuardado = favoritosRepository.findById(id).get();

		datoGuardado.setIdRecetas(request.getIdRecetas());
		datoGuardado.getUsuarios().setId(request.getIdUsuarios());
		datoGuardado.setDescripcion(request.getDescripcion());

		Favoritos datoModificado = favoritosRepository.save(datoGuardado);

		response.setIdFavoritos(datoModificado.getIdFavoritos());
		response.setIdRecetas(datoModificado.getIdRecetas());
		response.setIdUsuarios(datoModificado.getUsuarios().getId());
		response.setDescripcion(datoModificado.getDescripcion());

		return response;
	}
	
	 public List <FavoritosResponse> obtenerTodos(Integer IdUsuarios) {
		 
		List<FavoritosResponse> favoritosResponseLista = new ArrayList<>(); //Creamos una lista que nos devolvera los favoritos a mostrar
			
		List<Favoritos> favoritosLista = favoritosRepository.findByUsuarios(IdUsuarios); //Creamos una lista que almacena todos los objetos de favoritos de la BBDD con ese Usuario
			
			
			//Recorremos la lista
			for(Favoritos favorito: favoritosLista) {
				FavoritosResponse favoritosResponse = new FavoritosResponse(); //Creamos el objeto favoritos a devolver
				
				//Le asignamos los datos que capturamos del objeto favorito de la tabla
				favoritosResponse.setIdFavoritos(favorito.getIdFavoritos());
				favoritosResponse.setIdRecetas(favorito.getIdRecetas());
				favoritosResponse.setDescripcion(favorito.getDescripcion());
				favoritosResponse.setIdUsuarios(favorito.getUsuarios().getId());
				
				
				
				//Metemos en la lista a devolver los objetos
				favoritosResponseLista.add(favoritosResponse);
			}
		 
		 return favoritosResponseLista;
	 }
	 
	

}
