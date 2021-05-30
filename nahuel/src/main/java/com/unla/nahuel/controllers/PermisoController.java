package com.unla.nahuel.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.el.parser.ParseException;
import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPermisoDiarioService;
import com.unla.nahuel.services.IPermisoPeriodoService;
import com.unla.nahuel.services.IPermisoService;
import com.unla.nahuel.repositories.IPermisoRepository;
import com.unla.nahuel.services.IPersonaService;

@Controller
@RequestMapping("/permiso")
public class PermisoController {

	@Autowired
	@Qualifier("permisoService")
	private IPermisoService permisoService;

	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@Autowired
	@Qualifier("permisoDiarioService")
	private IPermisoDiarioService permisoDiarioService;

	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Persona> personas = personaService.getAll();
		model.addAttribute("titulo", "Personas");
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_CREAR;
	}

	@GetMapping("lista/permisoDiario/{id}")
	public String traerDiario(@PathVariable("id") long id, Model model) {

		List<Permiso> listado = permisoService.findByIdAndFetchPersonaEagerly(id);
		List<PermisoDiario> listado2 = new ArrayList<PermisoDiario>();
		for (Permiso p : listado) {
			if (p instanceof PermisoDiario) {
				listado2.add((PermisoDiario) p);
			}
		}
		model.addAttribute("titulo", "Permisos diarios");
		model.addAttribute("lista", listado2);

		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	}

	@GetMapping("lista/permisoPeriodo/{id}")
	public String traerPeriodo(@PathVariable("id") long id, Model model) {

		List<Permiso> listado = permisoService.findByIdAndFetchPersonaEagerly(id);
		List<PermisoPeriodo> listado2 = new ArrayList<PermisoPeriodo>();
		for (Permiso p : listado) {
			if (p instanceof PermisoPeriodo) {
				listado2.add((PermisoPeriodo) p);
			}
		}
		model.addAttribute("titulo", "Permisos por periodo");
		model.addAttribute("lista", listado2);

		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}
	
	@GetMapping("/activo")
	public String activo(Model model) {
		model.addAttribute("titulo", "Permisos");
		return ViewRouteHelper.PERMISO_ACTIVO;
	}
	
	@RequestMapping("/fecha")
	public String mostrar(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha2, Model model){ 
	    List<PermisoPeriodo> listado = permisoPeriodoService.getAll();
		List<PermisoPeriodo> permisos = new ArrayList<PermisoPeriodo>();
		for (PermisoPeriodo p : listado) {
			LocalDate fechaVencimiento = p.getFecha().plusDays(p.getCantDias());
			if (fecha1.isAfter(p.getFecha()) && fecha2.isBefore(fechaVencimiento)
					|| fecha1.isEqual(p.getFecha()) && fecha2.isEqual(fechaVencimiento)) {
				permisos.add(p);
			}
		}
		
		model.addAttribute("titulo", "Permisos periodo activos");
		model.addAttribute("lista", permisos);

		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	} 
	
	
	
	
	@GetMapping("/activoDiario")
	public String activoDiario(Model model) {
		model.addAttribute("titulo", "Permisos");
		return ViewRouteHelper.PERMISO_DIARIO;
	}
	
	@RequestMapping("/fechaDiario")
	public String mostrarDiario(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1, Model model){ 
	    List<PermisoDiario> listado = permisoDiarioService.getAll();
		List<PermisoDiario> permisos = new ArrayList<PermisoDiario>();
		for (PermisoDiario p : listado) {
			if (p.getFecha().isEqual(fecha1)) {
				permisos.add(p);
			}
			
		}
		model.addAttribute("titulo", "Permisos diarios activos");
		model.addAttribute("lista", permisos);

		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	} 
	

}
