package com.help.cook.helpcook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.help.cook.helpcook.repository.domain.Ingredientes;
import com.help.cook.helpcook.repository.domain.Usuarios;
/**
 * Generada Interfaz de la tabla Usuarios para acceder a la base datos
 * @author Hugo
 * @version 1.0, 2022/11/05
 */
public interface UsuariosRepository extends CrudRepository<Usuarios, Integer>{
	
	List<Usuarios> findAll();

	
	/**
	 * Declarado el Usuario que almacenará el usuario que contenga los valores que recibe
	 * @param email. Email que debe contener el usuario
	 * @param contrasenia. Contraseña que debe tener el usuario
	 * @return Devuelve el Usuario que posea esa contraseña y ese email
	 */
	@Query("SELECT u FROM Usuarios u WHERE u.email = :email AND u.contrasenia = :contrasenia")
	Usuarios findByEmailAndContrasenia(@Param ("email")String email, @Param ("contrasenia")String contrasenia);
	
	

	
}
