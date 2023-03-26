package com.help.cook.helpcook.repository;

import com.help.cook.helpcook.repository.domain.Favoritos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoritosRepository extends CrudRepository<Favoritos, Integer>{
	
	@Query ("SELECT f FROM Favoritos f  LEFT JOIN f.usuarios u WHERE (:IdUsuarios is null or u.id = :IdUsuarios)")
	List<Favoritos> findByUsuarios(@Param("IdUsuarios") Integer IdUsuarios);
	

}
