package com.unla.nahuel.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.nahuel.repositories.IPermisoPeriodoRepository;
import com.unla.nahuel.services.IPermisoPeriodoService;

@Service("permisoPeriodoService")
public class PermisoPeriodoService implements IPermisoPeriodoService {
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;

}
