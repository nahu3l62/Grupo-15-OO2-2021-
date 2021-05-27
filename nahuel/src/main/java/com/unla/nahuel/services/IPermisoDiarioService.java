package com.unla.nahuel.services;

import java.util.List;

import com.unla.nahuel.entities.PermisoDiario;

public interface IPermisoDiarioService {
	
	public List<PermisoDiario> getAll();

	public PermisoDiario buscar(long id);

	public void eliminar(long id);
	
	public void save(PermisoDiario permiso);
}
