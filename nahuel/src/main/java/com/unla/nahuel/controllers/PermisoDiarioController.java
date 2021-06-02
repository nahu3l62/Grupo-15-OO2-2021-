package com.unla.nahuel.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.nahuel.entities.Lugar;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.ILugarService;
import com.unla.nahuel.services.IPermisoDiarioService;
import com.unla.nahuel.services.IPermisoService;
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
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	
	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;
	
	@GetMapping("/seleccionarDni")
	public String seleccionarDni(Model model) {
		model.addAttribute("titulo", "Seleccione el dni");
		return ViewRouteHelper.PERMISO_DIARIO_SELECCIONAR_DNI;
	}
	
	@RequestMapping("/")
	public String crear(@RequestParam long dni, Model model) {
		
		PermisoDiario permiso = new PermisoDiario();
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = personaService.findByDni(dni);
		personas.add(persona);
		List<Lugar> lugares = lugarService.getAll();
		model.addAttribute("titulo", "Nuevo Permiso");
		model.addAttribute("permiso", permiso);
		model.addAttribute("personas", personas);
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.PERMISO_DIARIO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid PermisoDiario permiso, BindingResult result,Model model) {
		
		List<Persona> personas = personaService.getAll();
		List<Lugar> lugares = lugarService.getAll();
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo Permiso");
			model.addAttribute("permiso", permiso);
			model.addAttribute("personas", personas);
			model.addAttribute("lugares", lugares);
			System.out.println("Hubo error en el formulario!");
			return ViewRouteHelper.PERMISO_DIARIO_CREAR;
		}
		permisoDiarioService.save(permiso);
		System.out.println("Permiso guardado con exito!");
		return ViewRouteHelper.PERMISO_DIARIO_SELECCIONAR_DNI;
		
	}


}
