package com.unla.nahuel.customvalidations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*@Autowired
@Qualifier("personaRepository")
private IPersonaRepository personaRepository;*/

@Constraint(validatedBy = SinRepetirValidacion.class)//Clase con logica de validacion
@Target( { ElementType.METHOD, ElementType.FIELD }) //Destino validacion a metodo o campo
@Retention(RetentionPolicy.RUNTIME) //Chequea en tiempo de ejecucion
public @interface SinRepetir {
	
    //String value() default dniBD
	
	String message() default "Ese dni ya lo tiene otra persona";
    
    Class<?>[] groups() default {};//grupos por los que valida (no lo utilizo)
    
    Class<? extends Payload>[] payload() default {}; //contiene los datos que pueden ser almacenados
}
