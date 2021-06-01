package com.unla.nahuel.services;


import java.time.LocalDate;
import java.util.List;

import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.PermisoPeriodo;


public interface IPermisoService {
	
	public List<Permiso> getAll();

	public Permiso buscar(long id);

	public void eliminar(long id);
	
	public void save(Permiso permiso);
	
	public List<Permiso> findByIdAndFetchPersonaEagerly(long idPersona);
	
	public List<Permiso> findByIdAndFetchLugarEagerly(long idLugar);
	
	public List<PermisoDiario> filtrarPorPermisoDiario(List<Permiso> listaDePermisos);
	
	public List<PermisoPeriodo> filtrarPorPermisoPeriodo(List<Permiso> listaDePermisos);
	
	public List<PermisoPeriodo> filtrarPorFechaPermisoPeriodo(List<PermisoPeriodo> listaDePermisosPeriodo,LocalDate fecha1,LocalDate fecha2);
	
	public List<PermisoDiario> filtrarPorFechaPermisoDiario(List<PermisoDiario> listaDePermisos,LocalDate fecha);
	
}
