package com.unla.nahuel.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.nahuel.repositories.ILugarRepository;
import com.unla.nahuel.services.ILugarService;

@Service("lugarService")
public class LugarService implements ILugarService  {
	
	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;

}
