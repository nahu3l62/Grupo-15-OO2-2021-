package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.repositories.IPermisoRepository;
import com.unla.nahuel.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	@Override
	public List<Permiso> getAll() {
		return permisoRepository.findAll();
	}

	
	@Override
	public void save(Permiso permiso) {
		permisoRepository.save(permiso);
	}

	@Override
	public void eliminar(long id) {
		permisoRepository.deleteById(id);
	}


	@Override
	public Permiso buscar(long id) {
		return permisoRepository.findById(id).orElse(null);
	}

}
