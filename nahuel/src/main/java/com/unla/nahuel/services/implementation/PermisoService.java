package com.unla.nahuel.services.implementation;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.repositories.IPermisoRepository;
import com.unla.nahuel.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	@Override
	public List<Permiso> getAll() {
		return permisoRepository.findAll();
	}

	@Override
	public void save(Permiso permiso) {
		permisoRepository.save(permiso);
	}

	@Override
	public void eliminar(long id) {
		permisoRepository.deleteById(id);
	}

	@Override
	public Permiso buscar(long id) {
		return permisoRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Permiso> findByIdAndFetchPersonaEagerly(long idPersona){
		return permisoRepository.findByIdAndFetchPersonaEagerly(idPersona);
	}
	
	@Override
	public List<Permiso> findByIdAndFetchLugarEagerly(long idLugar){
		return permisoRepository.findByIdAndFetchLugarEagerly(idLugar);
	}
	
	public List<PermisoDiario> filtrarPorPermisoDiario(List<Permiso> listaDePermisos){
		List<PermisoDiario> listado = new ArrayList<PermisoDiario>();
		
		for (Permiso p : listaDePermisos) {
			if (p instanceof PermisoDiario) {
				listado.add((PermisoDiario) p);
			}
		}
		return listado;	
	}
	
	public List<PermisoPeriodo> filtrarPorPermisoPeriodo(List<Permiso> listaDePermisos){
		List<PermisoPeriodo> listado = new ArrayList<PermisoPeriodo>();
		for (Permiso p : listaDePermisos) {
			if (p instanceof PermisoPeriodo) {
				listado.add((PermisoPeriodo) p);
			}
		}
		return listado;	
	}
	
	
	public List<PermisoPeriodo> filtrarPorFechaPermisoPeriodo(List<PermisoPeriodo> listaDePermisosPeriodo,LocalDate fecha1,LocalDate fecha2){
		List<PermisoPeriodo> listado = new ArrayList<PermisoPeriodo>();
		for (PermisoPeriodo p : listaDePermisosPeriodo) {
			LocalDate fechaVencimiento = p.getFecha().plusDays(p.getCantDias());
			if (fecha1.isEqual(p.getFecha()) && fecha2.isBefore(fechaVencimiento)|| fecha1.isAfter(p.getFecha())&&fecha2.isEqual(fechaVencimiento) || fecha1.isAfter(p.getFecha()) && fecha2.isBefore(fechaVencimiento)
					|| fecha1.isEqual(p.getFecha()) && fecha2.isEqual(fechaVencimiento)) {
				listado.add(p);
			}
		}
		return listado;	
	}
	
	
	public List<PermisoDiario> filtrarPorFechaPermisoDiario(List<PermisoDiario> listaDePermisos,LocalDate fecha){
		List<PermisoDiario> listado = new ArrayList<PermisoDiario>();
		for (PermisoDiario p : listaDePermisos) {
			if (p.getFecha().isEqual(fecha)) {
				listado.add(p);
			}
		}
		return listado;	
	}
	
	
	
	
}
