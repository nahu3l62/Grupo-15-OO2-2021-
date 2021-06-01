package com.unla.nahuel.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unla.nahuel.entities.Persona;



public interface IPersonaService {
	
	public void save(Persona persona);
	public List<Persona> getAll();
	public Persona buscar(long id);
	public Persona findByDni(@Param("dni") Long dni);


}
