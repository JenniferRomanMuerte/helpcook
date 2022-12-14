package com.help.cook.helpcook.repository;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Favoritos;
import com.help.cook.helpcook.repository.domain.Ingredientes;

public interface FavoritosRepository extends CrudRepository<Favoritos, Integer>{

}
