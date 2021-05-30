package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.repositories.IPersonaRepository;
import com.unla.nahuel.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	public void save(Persona persona) {
		personaRepository.save(persona);
	}
	
	public List<Persona> getAll(){
		return personaRepository.findAll();
	}
	
	public Persona buscar(long id) {
		return personaRepository.findById(id).orElse(null);
	}

}
