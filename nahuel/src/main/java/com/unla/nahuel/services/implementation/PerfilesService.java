package com.unla.nahuel.services.implementation;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
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
	
	@Override
	public void save(Perfiles perfil) {
		perfilesRepository.save(perfil);
	
	}
	
	@Override
	public Perfiles buscar(long id) {
		return perfilesRepository.findById(id).orElse(null);
	}
	
	@Override
	public void eliminar (long id) {
		perfilesRepository.deleteById(id);
	}
	
	public Perfiles findByRol(@Param("rol") String rol) {
		return perfilesRepository.findByRol(rol);
	}

	
}
