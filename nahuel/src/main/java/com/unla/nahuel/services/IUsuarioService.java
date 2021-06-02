package com.unla.nahuel.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.unla.nahuel.entities.Usuario;


public interface IUsuarioService {
	
	public List<Usuario> getAll();

	public Usuario buscar(long id);

	public void eliminar(long id);
	
	public void save(Usuario usuario);
	
	public Usuario findByDni(@Param("documento") int documento);

	public Usuario findByEmail(@Param("correoElectronico") String correoElectronico);
	
	public Usuario findByUsername(@Param("nombreDeUsuario") String nombreDeUsuario);	


	
}
