package com.help.cook.helpcook.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Ingredientes;
import com.help.cook.helpcook.repository.domain.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Integer>{
	
	List<Usuarios> findAll();

	
}
