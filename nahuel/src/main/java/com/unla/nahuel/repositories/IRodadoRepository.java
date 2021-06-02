package com.unla.nahuel.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.Rodado;

@Repository("rodadoRepository")
public interface IRodadoRepository extends JpaRepository<Rodado, Long> {
	@Query("SELECT r FROM Rodado r WHERE r.dominio = (:dominio)")
	public abstract Rodado findByDominio(@Param("dominio") String dominio);

}


