package com.unla.nahuel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.PermisoPeriodo;

@Repository("permisoPeriodoRepository")
public interface IPermisoPeriodoRepository extends JpaRepository<PermisoPeriodo, Long>  {

	@Query("SELECT p FROM PermisoPeriodo p INNER JOIN FETCH p.rodado r WHERE r.idRodado = (:idRodado)")
	public abstract List<PermisoPeriodo> findByIdAndFetchRodadoEagerly(@Param("idRodado") long idRodado);
	
}
