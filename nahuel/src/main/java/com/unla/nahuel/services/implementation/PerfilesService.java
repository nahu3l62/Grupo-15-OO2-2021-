package com.unla.nahuel.services.implementation;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.Perfiles;
import com.unla.nahuel.repositories.IPerfilesRepository;
import com.unla.nahuel.services.IPerfilesService;

@Service("perfilesService")
public class PerfilesService implements IPerfilesService {
	
	@Autowired
	@Qualifier("perfilesRepository")
	private IPerfilesRepository perfilesRepository;

	
	@Override
	public List<Perfiles> getAll() {
		return perfilesRepository.findAll();
	}
	
	
	
}
