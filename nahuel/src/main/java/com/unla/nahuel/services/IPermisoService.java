package com.unla.nahuel.services;

import java.util.List;

import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.Persona;

public interface IPermisoService {
	
	public List<Permiso> getAll();

	public Permiso buscar(long id);

	public void eliminar(long id);
	
	public void save(Permiso permiso);
	
}
