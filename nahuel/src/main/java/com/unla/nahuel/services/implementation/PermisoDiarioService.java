package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.repositories.IPermisoDiarioRepository;
import com.unla.nahuel.services.IPermisoDiarioService;

@Service("permisoDiarioService")
public class PermisoDiarioService implements IPermisoDiarioService {
	
	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;
	
	@Override
	public List<PermisoDiario> getAll() {
		return permisoDiarioRepository.findAll();
	}

	@Override
	public void save(PermisoDiario permiso) {
		permisoDiarioRepository.save(permiso);
	}

	@Override
	public PermisoDiario buscar(long id) {
		return permisoDiarioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	

}
