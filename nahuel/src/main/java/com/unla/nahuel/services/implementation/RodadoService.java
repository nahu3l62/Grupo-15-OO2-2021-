package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.Rodado;
import com.unla.nahuel.repositories.IRodadoRepository;
import com.unla.nahuel.services.IRodadoService;

@Service("rodadoService")
public class RodadoService implements IRodadoService {
	
	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;
	
	@Override
	public List<Rodado> getAll() {
		return rodadoRepository.findAll();
	}

	@Override
	public Rodado buscar(long id) {
		return rodadoRepository.findById(id).orElse(null);
	}
	
	@Override
	public void save(Rodado rodado) {
		rodadoRepository.save(rodado);
	}

	@Override
	public void eliminar(long id) {
		rodadoRepository.deleteById(id);
	}

}
