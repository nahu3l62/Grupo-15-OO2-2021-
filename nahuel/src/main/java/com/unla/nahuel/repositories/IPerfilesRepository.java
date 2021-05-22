package com.unla.nahuel.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unla.nahuel.entities.Perfiles;





@Repository("perfilesRepository")
public interface IPerfilesRepository extends JpaRepository<Perfiles, Long>{
	public abstract List<Perfiles> findAll();
	
	
}
