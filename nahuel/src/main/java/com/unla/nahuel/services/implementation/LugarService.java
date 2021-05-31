package com.unla.nahuel.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.nahuel.entities.Lugar;
import com.unla.nahuel.repositories.ILugarRepository;
import com.unla.nahuel.services.ILugarService;

@Service("lugarService")
public class LugarService implements ILugarService  {
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;
	
	public List<Lugar> getAll(){
		return lugarRepository.findAll();
	}

}
