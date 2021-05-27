package com.unla.nahuel.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.Persona;


@Repository("personaRepository")
public interface IPersonaRepository extends JpaRepository<Persona, Serializable> {

}
