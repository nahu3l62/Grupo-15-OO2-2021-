package com.unla.nahuel.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Persona persona = new Persona();
		model.addAttribute("titulo", "Formulario: Nueva Persona");
		model.addAttribute("persona", persona);
		return ViewRouteHelper.PERSONA_CREAR;
	}

	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Persona persona,BindingResult result, Model model,RedirectAttributes attribute) {
		String dni = String.valueOf(persona.getDni());
		if(personaService.findByDni(persona.getDni())!=null) {
			FieldError error = new FieldError("persona", "dni", "Ya existe una persona con ese DNI");
			result.addError(error);
		}
		if(persona.getDni()==0) {
			FieldError error = new FieldError("persona", "dni", "El dni de la persona no puede ser 0");
			result.addError(error);
		}
		if(dni.length()<8 || dni.length()>8) {
			FieldError error = new FieldError("persona", "dni", "Los caracteres del dni deben ser 7 como minimo y 8 como maximo");
			result.addError(error);
		}
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nueva Persona");
			model.addAttribute("persona", persona);
			System.out.println("Hubo errores en la creacion del formulario!");
			return ViewRouteHelper.PERSONA_CREAR;
		}
		personaService.save(persona);
		System.out.println("Usuario guardado con exito!");
		attribute.addFlashAttribute("success","Persona agregada con exito");
		return ViewRouteHelper.PERSONA_REDIRECT;
	}

}
