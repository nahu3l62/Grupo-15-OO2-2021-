package com.unla.nahuel.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.nahuel.repositories.IPersonaRepository;
import com.unla.nahuel.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService {
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;

}
