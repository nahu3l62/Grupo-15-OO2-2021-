/*package com.unla.nahuel.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPermisoPeriodoService;
import com.unla.nahuel.services.IPersonaService;

@Controller
@RequestMapping("/permiso_periodo")
public class PermisoController {
	
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@GetMapping("/")
	public String crear(Model model) {
		
		PermisoPeriodo permiso = new PermisoPeriodo();
		List<Persona> personas = personaService.getAll();

		model.addAttribute("titulo", "Nuevo Permiso");
		model.addAttribute("permiso", permiso);
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute PermisoPeriodo permiso,BindingResult result,Model model) {
		permisoPeriodoService.save(permiso);
		System.out.println("Perfil guardado con exito!");
		
		PermisoPeriodo permiso1 = new PermisoPeriodo();
		List<Persona> personas = personaService.getAll();
		model.addAttribute("titulo", "Nuevo Permiso");
		model.addAttribute("permiso", permiso1);
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_REDIRECT;
		
	}
	
	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<PermisoPeriodo> listado = permisoPeriodoService.getAll();
		model.addAttribute("titulo","Lista de perfiles");
		model.addAttribute("lista",listado);
		
		return ViewRouteHelper.PERMISO_LISTA;
	}

}*/
