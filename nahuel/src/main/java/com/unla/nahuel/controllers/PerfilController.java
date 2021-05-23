package com.unla.nahuel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.nahuel.entities.Perfiles;
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
		
		model.addAttribute("titulo", "Nuevo Perfil");
		model.addAttribute("perfil", perfil);
		List<Perfiles> listaPerfiles = perfilesService.getAll();
		if(listaPerfiles.isEmpty()) {
			Perfiles perfil1 = new Perfiles("auditor");
			Perfiles perfil2 = new Perfiles("administrador");
			perfilesService.save(perfil1);
			perfilesService.save(perfil2);
		}
		perfilesService.save(perfil);
		System.out.println("Perfil guardado con exito!");
		return "redirect:/perfiles/";
		
	}
	
	
	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<Perfiles> listado = perfilesService.getAll();
		List<Perfiles> perfiles = new ArrayList<Perfiles>();
		if(listado.isEmpty()) {
			Perfiles perfil1 = new Perfiles("auditor");
			Perfiles perfil2 = new Perfiles("administrador");
			perfilesService.save(perfil1);
			perfilesService.save(perfil2);
		}
		listado = perfilesService.getAll();
		for (Perfiles p : listado) {
			if (p.isDeshabilitado() == false) {
				perfiles.add(p);
			}
		}
		
		model.addAttribute("titulo","Lista de perfiles");
		model.addAttribute("lista",perfiles);

		return "perfil/lista";
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id, Model model) {

		Perfiles perfil1 = perfilesService.buscar(id); 
		

		model.addAttribute("titulo", "Editar perfil");
		model.addAttribute("perfil", perfil1);

		return "perfil/crear";
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id) {
		Perfiles p = perfilesService.buscar(id);
		p.setDeshabilitado(true);
		perfilesService.save(p);
		System.out.println("Perfil eliminado con exito");

		return "redirect:/perfiles/lista";
	}

}
