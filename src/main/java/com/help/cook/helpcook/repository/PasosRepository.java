package com.help.cook.helpcook.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Pasos;

public interface PasosRepository  extends CrudRepository<Pasos, Integer> {
	
	List<Pasos> findAll();

}
