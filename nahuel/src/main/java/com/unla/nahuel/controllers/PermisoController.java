package com.unla.nahuel.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.entities.Usuario;
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
	public String listarClientes(Model model) {
		List<Persona> personas = personaService.getAll();
		model.addAttribute("titulo", "Personas");
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_CREAR;
	}

	@GetMapping("lista/permisoDiario/{id}")
	public String editar(@PathVariable("id") long id, Model model) {

		List<Permiso> listado = permisoRepository.findByIdAndFetchPersonaEagerly(id);
		List<PermisoDiario> listado2 = new ArrayList<PermisoDiario>();
		for(Permiso p:listado){
			if(p instanceof PermisoDiario) {
				listado2.add((PermisoDiario) p);
			}
		}
		
		System.out.println(listado);
		
		model.addAttribute("titulo", "Permisos diarios");
		model.addAttribute("lista", listado2);
	
		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	}
	
	
	
	@GetMapping("lista/permisoPeriodo/{id}")
	public String editar2(@PathVariable("id") long id, Model model) {

		List<Permiso> listado = permisoRepository.findByIdAndFetchPersonaEagerly(id);
		List<PermisoPeriodo> listado2 = new ArrayList<PermisoPeriodo>();
		for(Permiso p:listado){
			if(p instanceof PermisoPeriodo) {
				listado2.add((PermisoPeriodo) p);
			}
		}
		
		System.out.println(listado);
		
		model.addAttribute("titulo", "Permisos por periodo");
		model.addAttribute("lista", listado2);
	
		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}
	
	
	

}
