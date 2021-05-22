package com.unla.nahuel.repositories;

import java.util.List;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.Usuario;




@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	
	/*public abstract List<Usuario> findAll();
	//public abstract void guardar(Usuario usuario);
	public abstract Usuario findByNombre(String nombre);
	public abstract Usuario findByDocumentoAndNombreDeUsuario(int documento, String nombreDeUsuario);
	public abstract List<Usuario> findByDocumento(int documento);*/
	
	

}
