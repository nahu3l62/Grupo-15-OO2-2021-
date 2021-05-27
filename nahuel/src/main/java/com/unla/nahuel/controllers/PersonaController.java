package com.unla.nahuel.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String guardar(@Valid @ModelAttribute Persona persona, Model model) {

		model.addAttribute("titulo", "Formulario: Nueva Persona");
		model.addAttribute("persona", persona);
		personaService.save(persona);
		System.out.println("Usuario guardado con exito!");
		return ViewRouteHelper.PERSONA_REDIRECT;
	}

}
