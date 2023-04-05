package com.help.cook.helpcook.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.help.cook.helpcook.repository.domain.Ingredientes;
import com.help.cook.helpcook.repository.domain.Usuarios;
/**
 * Generada Interfaz de la tabla Usuarios para acceder a la base datos
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public interface UsuariosRepository extends CrudRepository<Usuarios, Integer>{
	
	List<Usuarios> findAll();

	
}
