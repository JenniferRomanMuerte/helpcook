package com.help.cook.helpcook.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Recetas;

public interface RecetasRepository extends CrudRepository<Recetas, Integer>{
	List<Recetas> findAll();
}
