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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.nahuel.entities.Lugar;
import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.entities.Rodado;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.repositories.IPermisoPeriodoRepository;
import com.unla.nahuel.services.ILugarService;
import com.unla.nahuel.services.IPermisoPeriodoService;
import com.unla.nahuel.services.IPersonaService;
import com.unla.nahuel.services.IRodadoService;

@Controller
@RequestMapping("/permiso_periodo")
public class PermisoPeriodoController {
	
	
	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;
	
	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@GetMapping("/seleccionarDni")
	public String seleccionarDni(Model model) {
		model.addAttribute("titulo", "Seleccione el dni");
		return ViewRouteHelper.PERMISO_PERIODO_SELECCIONAR_DNI;
	}
	
	@GetMapping("/")
	public String crear(@RequestParam long dni, Model model) {
		PermisoPeriodo permiso = new PermisoPeriodo();
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona = personaService.findByDni(dni);
		personas.add(persona);
		List<Lugar> lugares = lugarService.getAll();
		List<Rodado> rodados = rodadoService.getAll();
		model.addAttribute("titulo", "Nuevo Permiso");
		model.addAttribute("permiso", permiso);
		model.addAttribute("personas", personas);
		model.addAttribute("lugares", lugares);
		model.addAttribute("rodados", rodados);
		return ViewRouteHelper.PERMISO_PERIODO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute PermisoPeriodo permiso,BindingResult result,Model model) {
		List<Persona> personas = personaService.getAll();
		List<Lugar> lugares = lugarService.getAll();
		List<Rodado> rodados = rodadoService.getAll();
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo Permiso");
			model.addAttribute("permiso", permiso);
			model.addAttribute("personas", personas);
			model.addAttribute("lugares", lugares);
			model.addAttribute("rodados", rodados);
			System.out.println("Hubo errores en el formulario!");
			return ViewRouteHelper.PERMISO_PERIODO_CREAR;
		}	
		permisoPeriodoService.save(permiso);
		System.out.println("Permiso guardado con exito!");
		return ViewRouteHelper.PERMISO_PERIODO_SELECCIONAR_DNI;	
	}
	
	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<PermisoPeriodo> listado = permisoPeriodoService.getAll();
		model.addAttribute("titulo","Lista de perfiles");
		model.addAttribute("lista",listado);
		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}
	

	@GetMapping("rodados/{id}")
	public String editar2(@PathVariable("id") long id, Model model) {
		List<PermisoPeriodo> listado = permisoPeriodoRepository.findByIdAndFetchRodadoEagerly(id);
		Rodado r = rodadoService.buscar(id);
		model.addAttribute("titulo", "Permisos por periodo de " + r.getDominio());
		model.addAttribute("lista", listado);
		return ViewRouteHelper.PERMISO_PERIODO_RODADO;
	}
	
	


}
