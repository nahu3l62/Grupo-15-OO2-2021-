package com.unla.nahuel.customvalidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.repositories.IPersonaRepository;

/*@Autowired
@Qualifier("personaRepository")
private IPersonaRepository personaRepository;*/

public class SinRepetirValidacion implements ConstraintValidator<SinRepetir, Long> {

	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	/*@Override
    public void initialize(SinRepetir dni) {
    }*/
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		
		boolean valido = false;
		
		Persona p1 = personaRepository.findByDni(value);
		
		System.out.println(p1);
		
		if(p1==null) valido=true;
		
		
		return valido;
	}

	//private Long dniBD;
	
}
