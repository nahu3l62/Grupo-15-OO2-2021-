package com.unla.nahuel.controllers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.unla.nahuel.entities.Lugar;
import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.ILugarService;
import com.unla.nahuel.services.IPermisoDiarioService;
import com.unla.nahuel.services.IPermisoPeriodoService;
import com.unla.nahuel.services.IPermisoService;
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
	
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;

	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Persona> personas = personaService.getAll();
		model.addAttribute("titulo", "Personas");
		model.addAttribute("personas", personas);
		return ViewRouteHelper.PERMISO_CREAR;
	}

	@GetMapping("lista/permisoDiario/{id}")
	public String traerDiarioXPersona(@PathVariable("id") long id, Model model) {
		List<Permiso> listadoDePermisos = permisoService.findByIdAndFetchPersonaEagerly(id);
		List<PermisoDiario> listadoDePermisosDiarios = permisoService.filtrarPorPermisoDiario(listadoDePermisos);
		model.addAttribute("titulo", "Permisos diarios");
		model.addAttribute("lista", listadoDePermisosDiarios);
		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	}

	@GetMapping("lista/permisoPeriodo/{id}")
	public String traerPeriodoXPersona(@PathVariable("id") long id, Model model) {
		List<Permiso> listadoDePermisos = permisoService.findByIdAndFetchPersonaEagerly(id);
		List<PermisoPeriodo> listadoDePermisosPeriodo = permisoService.filtrarPorPermisoPeriodo(listadoDePermisos);
		model.addAttribute("titulo", "Permisos por periodo");
		model.addAttribute("lista",listadoDePermisosPeriodo);
		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}
	
	@GetMapping("/activo")
	public String activoPeriodo(Model model) {
		model.addAttribute("titulo", "Permisos");
		return ViewRouteHelper.PERMISO_ACTIVO;
	}
	
	@RequestMapping("/fecha")
	public String activoPeriodoXFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha2, Model model){ 
	    List<PermisoPeriodo> listado = permisoPeriodoService.getAll();
		List<PermisoPeriodo> permisos = permisoService.filtrarPorFechaPermisoPeriodo(listado, fecha1, fecha2);
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
	public String activoDiarioXFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1, Model model){ 
	    List<PermisoDiario> listado = permisoDiarioService.getAll();
		List<PermisoDiario> permisos = permisoService.filtrarPorFechaPermisoDiario(listado, fecha1);
		model.addAttribute("titulo", "Permisos diarios activos");
		model.addAttribute("lista", permisos);
		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	} 
	
	@GetMapping("/lugar")
	public String traerLugar(Model model) {
		List<Lugar> lugares = lugarService.getAll();
		model.addAttribute("titulo", "Lugares");
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.PERMISO_TRAER;
	}
	
	@GetMapping("/activoFechaLugarPeriodo")
	public String periodoXFechaYLugar(Model model) {
		List<Lugar> lugares = lugarService.getAll();
		model.addAttribute("titulo", "Lugares");
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.PERMISO_ACTIVOXFECHAYLUGAR_PERIODO;
	}
	
	@RequestMapping("/traerFechaLugarPeriodo")
	public String activoPeriodoXFechaYLugar(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha2, @RequestParam long idLugar, Model model){ 
		List<Permiso> listadoDePermisos = permisoService.findByIdAndFetchLugarEagerly(idLugar);
		List<PermisoPeriodo> listadoDePermisosPeriodos = permisoService.filtrarPorPermisoPeriodo(listadoDePermisos);
		List<PermisoPeriodo> listadoDePermisosPeriodosFiltradosPorFecha = permisoService.filtrarPorFechaPermisoPeriodo(listadoDePermisosPeriodos, fecha1, fecha2);
		model.addAttribute("titulo", "Permisos periodo activos");
		model.addAttribute("lista", listadoDePermisosPeriodosFiltradosPorFecha);
		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	} 
	
	
	@GetMapping("/activoFechaLugarDiario")
	public String diarioXFechaYLugar(Model model) {
		List<Lugar> lugares = lugarService.getAll();
		model.addAttribute("titulo", "Permisos");
		model.addAttribute("lugares", lugares);
		return ViewRouteHelper.PERMISO_ACTIVOXFECHAYLUGAR_DIARIO;
	}
	
	@RequestMapping("/traerFechaLugarDiario")
	public String activoDiarioXFechaYLugar(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1,@RequestParam long idLugar, Model model){ 
		List<Permiso> listadoDePermisos = permisoService.findByIdAndFetchLugarEagerly(idLugar);
		List<PermisoDiario> listadoDePermisosDiarios = permisoService.filtrarPorPermisoDiario(listadoDePermisos);
		List<PermisoDiario> listadoDePermisosPeriodosFiltradosPorFecha = permisoService.filtrarPorFechaPermisoDiario(listadoDePermisosDiarios, fecha1);
		model.addAttribute("titulo", "Permisos diarios activos");
		model.addAttribute("lista", listadoDePermisosPeriodosFiltradosPorFecha);
		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	} 
	


}
