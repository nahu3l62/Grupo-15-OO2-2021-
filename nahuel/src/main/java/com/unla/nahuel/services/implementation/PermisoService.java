package com.unla.nahuel.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.nahuel.repositories.IPermisoRepository;
import com.unla.nahuel.services.IPermisoService;

@Service("permisoService")
public class PermisoService implements IPermisoService {
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

}
