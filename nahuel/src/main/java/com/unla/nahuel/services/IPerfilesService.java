package com.unla.nahuel.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unla.nahuel.entities.Perfiles;

public interface IPerfilesService {
	public List<Perfiles> getAll();
	
	public void save(Perfiles perfil);
	
	public Perfiles buscar(long id);
	
	public void eliminar (long id);
	
	public Perfiles findByRol(@Param("rol") String rol);

}
