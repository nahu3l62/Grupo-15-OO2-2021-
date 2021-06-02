package com.unla.nahuel.repositories;


import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.entities.Usuario;


@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	@Query("SELECT u FROM Usuario u WHERE u.documento = (:documento)")
	public abstract Usuario findByDni(@Param("documento") int documento);
	
	@Query("SELECT u FROM Usuario u WHERE u.correoElectronico = (:correoElectronico)")
	public abstract Usuario findByEmail(@Param("correoElectronico") String correoElectronico);
	
	@Query("SELECT u FROM Usuario u WHERE u.nombreDeUsuario = (:nombreDeUsuario)")
	public abstract Usuario findByUsername(@Param("nombreDeUsuario") String nombreDeUsuario);	
	
}
