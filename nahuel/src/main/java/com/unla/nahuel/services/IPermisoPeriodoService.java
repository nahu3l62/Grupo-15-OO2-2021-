package com.unla.nahuel.services;

import java.util.List;

import com.unla.nahuel.entities.PermisoPeriodo;

public interface IPermisoPeriodoService {
	
	public List<PermisoPeriodo> getAll();

	public PermisoPeriodo buscar(long id);

	public void eliminar(long id);
	
	public void save(PermisoPeriodo permiso);
}
