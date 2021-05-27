package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.repositories.IPermisoPeriodoRepository;
import com.unla.nahuel.services.IPermisoPeriodoService;

@Service("permisoPeriodoService")
public class PermisoPeriodoService implements IPermisoPeriodoService {
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	@Override
	public List<PermisoPeriodo> getAll() {
		return permisoPeriodoRepository.findAll();
	}

	@Override
	public PermisoPeriodo buscar(long id) {
		return permisoPeriodoRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(PermisoPeriodo permiso) {
		permisoPeriodoRepository.save(permiso);
	}

	@Override
	public void eliminar(long id) {
		permisoPeriodoRepository.deleteById(id);
	}
}
