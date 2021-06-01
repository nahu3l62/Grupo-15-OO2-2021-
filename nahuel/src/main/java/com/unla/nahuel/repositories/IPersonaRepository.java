package com.unla.nahuel.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.Persona;


@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
	@Query("SELECT p FROM Persona p WHERE p.dni = (:dni)")
	public abstract Persona findByDni(@Param("dni") Long dni);
}
