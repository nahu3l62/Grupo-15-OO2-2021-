package com.unla.nahuel.controllers;

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

import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPermisoDiarioService;
import com.unla.nahuel.services.IPersonaService;

@Controller
@RequestMapping("/permiso_diario")
public class PermisoDiarioController {
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService permisoDiarioService;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@GetMapping("/")
	public String crear(Model model) {
		
		PermisoDiario permiso = new PermisoDiario();
		List<Persona> personas = personaService.getAll();

		model.addAttribute("titulo", "Nuevo Permiso");
		model.addAttribute("permiso", permiso);
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_DIARIO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute PermisoDiario permiso,BindingResult result,Model model) {
		permisoDiarioService.save(permiso);
		System.out.println("Perfil guardado con exito!");
		return ViewRouteHelper.PERMISO_DIARIO_REDIRECT;
		
	}
	
	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<PermisoDiario> listado = permisoDiarioService.getAll();
		model.addAttribute("titulo","Lista de perfiles");
		model.addAttribute("lista",listado);
		
		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	}

}
