package com.unla.nahuel.services;

import java.util.List;

import com.unla.nahuel.entities.Rodado;

public interface IRodadoService {
	
	public List<Rodado> getAll();

	public Rodado buscar(long id);

	public void eliminar(long id);
	
	public void save(Rodado rodado);
	
}
