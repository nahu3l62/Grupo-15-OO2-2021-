package com.unla.nahuel.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.repositories.IPermisoRepository;
import com.unla.nahuel.services.IPersonaService;

@Controller
@RequestMapping("/permiso")
public class PermisoController {
	
	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@GetMapping("/")
	public String seleccionar(Model model) {
		List<Persona> personas = personaService.getAll();
		model.addAttribute("titulo", "Personas");
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_CREAR;
	}
	
	@PostMapping("/lista")
	public String guardar(@Valid @ModelAttribute Persona persona, Model model) {
		List<Permiso> listado = permisoRepository.findByIdAndFetchPersonaEagerly(persona.getIdPersona());
		model.addAttribute("titulo", "Permisos");
		model.addAttribute("permisos", listado);
		return ViewRouteHelper.PERMISO_LISTA;
		
	}

}
