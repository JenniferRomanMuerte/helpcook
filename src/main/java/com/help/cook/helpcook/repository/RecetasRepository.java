package com.help.cook.helpcook.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.help.cook.helpcook.repository.domain.Recetas;

public interface RecetasRepository extends CrudRepository<Recetas, Integer>{
	
	List<Recetas> findAll();
	
	@Query("SELECT r FROM Recetas r LEFT JOIN r.ingredientes i  WHERE ((:categoria is null or r.categoria like %:categoria%) " +
			"AND (:idIngredientes is null or i.ingredientes.idIngredientes in (:idIngredientes)) " +
			"AND (:idUsuario is null or r.id = :idUsuario ))")
	Set<Recetas> findAdvance (@Param("categoria") String categoria, @Param ("idIngredientes") List<Integer> idIngredientes, @Param("idUsuario") Integer idUsuario);
}
