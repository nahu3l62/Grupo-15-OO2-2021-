package com.unla.nahuel.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.nahuel.repositories.IRodadoRepository;
import com.unla.nahuel.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService {
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

}
