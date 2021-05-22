package com.unla.nahuel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.nahuel.entities.Perfiles;
import com.unla.nahuel.entities.Usuario;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPerfilesService;

@Controller
@RequestMapping("/perfiles")
public class PerfilController {
	
	@Autowired
	@Qualifier("perfilesService")
	private IPerfilesService perfilesService;
	
	@GetMapping("/")
	public String crear(Model model) {
		
		Perfiles perfil = new Perfiles();
		
		model.addAttribute("titulo", "Formulario: Nuevo Perfil");
		model.addAttribute("perfil", perfil);
		
		
		return "perfil/crear";
	}
	
	@PostMapping("/")
	public String guardar(@ModelAttribute Perfiles perfil,Model model) {
		
		model.addAttribute("titulo", "Formulario: Nuevo Perfil");
		model.addAttribute("perfil", perfil);
		

		perfilesService.save(perfil);
		System.out.println("Perfil guardado con exito!");
		return "redirect:/perfiles/";
		
	}
	
	
	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<Perfiles> listado = perfilesService.getAll();
		
		
		model.addAttribute("titulo","Lista de perfiles");
		model.addAttribute("lista",listado);

		return "perfil/lista";
	}

}
