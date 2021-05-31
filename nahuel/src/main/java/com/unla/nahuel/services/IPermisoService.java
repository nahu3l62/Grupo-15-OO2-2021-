package com.unla.nahuel.services;


import java.util.List;

import com.unla.nahuel.entities.Permiso;


public interface IPermisoService {
	
	public List<Permiso> getAll();

	public Permiso buscar(long id);

	public void eliminar(long id);
	
	public void save(Permiso permiso);
	
	public List<Permiso> findByIdAndFetchPersonaEagerly(long idPersona);
	
	public List<Permiso> findByIdAndFetchLugarEagerly(long idLugar);
	
}
