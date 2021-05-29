package com.unla.nahuel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.Permiso;

@Repository("permisoRepository")
public interface IPermisoRepository extends JpaRepository<Permiso, Long> {
	
	@Query("SELECT p FROM Permiso p INNER JOIN FETCH p.persona pr WHERE pr.idPersona = (:idPersona)")
	public abstract List<Permiso> findByIdAndFetchPersonaEagerly(@Param("idPersona") long idPersona);
}
