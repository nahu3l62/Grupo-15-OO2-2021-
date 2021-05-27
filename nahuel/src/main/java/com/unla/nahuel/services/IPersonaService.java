package com.unla.nahuel.services;

import java.util.List;

import com.unla.nahuel.entities.Persona;



public interface IPersonaService {
	
	public void save(Persona persona);
	public List<Persona> getAll();

}
