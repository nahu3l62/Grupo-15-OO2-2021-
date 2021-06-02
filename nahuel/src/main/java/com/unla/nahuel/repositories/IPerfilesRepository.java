package com.unla.nahuel.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unla.nahuel.entities.Perfiles;


@Repository("perfilesRepository")
public interface IPerfilesRepository extends JpaRepository<Perfiles, Long>{
	@Query("SELECT p FROM Perfiles p WHERE p.rol = (:rol)")
	public abstract Perfiles findByRol(@Param("rol") String rol);

}
