package com.unla.nahuel.services;

import java.util.List;

import com.unla.nahuel.entities.Perfiles;

public interface IPerfilesService {
	public List<Perfiles> getAll();
	
	public void save(Perfiles perfil);
	
	public Perfiles buscar(long id);
	
	public void eliminar (long id);
}
