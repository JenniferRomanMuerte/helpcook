package com.help.cook.helpcook.repository;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Valoraciones;

import java.util.List;

public interface ValoracionesRepository extends CrudRepository<Valoraciones, Integer>{

    List<Valoraciones> findAll();

    
    List<Valoraciones> findByIdRecetas(Integer idReceta);
}
