package com.unla.nahuel.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.nahuel.entities.Permiso;
import com.unla.nahuel.entities.PermisoDiario;
import com.unla.nahuel.entities.PermisoPeriodo;
import com.unla.nahuel.entities.Persona;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPermisoPeriodoService;
import com.unla.nahuel.repositories.IPermisoRepository;
import com.unla.nahuel.services.IPersonaService;

@Controller
@RequestMapping("/permiso")
public class PermisoController {

	@Autowired
	@Qualifier("permisoRepository")
	private IPermisoRepository permisoRepository;

	@Autowired
	@Qualifier("permisoPeriodoService")
	private IPermisoPeriodoService permisoPeriodoService;

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
	public String traerDiario(@PathVariable("id") long id, Model model) {

		List<Permiso> listado = permisoRepository.findByIdAndFetchPersonaEagerly(id);
		List<PermisoDiario> listado2 = new ArrayList<PermisoDiario>();
		for (Permiso p : listado) {
			if (p instanceof PermisoDiario) {
				listado2.add((PermisoDiario) p);
			}
		}

		System.out.println(listado);

		model.addAttribute("titulo", "Permisos diarios");
		model.addAttribute("lista", listado2);

		return ViewRouteHelper.PERMISO_DIARIO_LISTA;
	}

	@GetMapping("lista/permisoPeriodo/{id}")
	public String traerPeriodo(@PathVariable("id") long id, Model model) {

		List<Permiso> listado = permisoRepository.findByIdAndFetchPersonaEagerly(id);
		List<PermisoPeriodo> listado2 = new ArrayList<PermisoPeriodo>();
		for (Permiso p : listado) {
			if (p instanceof PermisoPeriodo) {
				listado2.add((PermisoPeriodo) p);
			}
		}

		System.out.println(listado);

		model.addAttribute("titulo", "Permisos por periodo");
		model.addAttribute("lista", listado2);

		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}

	@GetMapping("/activo")
	public String activo(Model model) {
		LocalDate fecha1 = LocalDate.now();
		LocalDate fecha2 = LocalDate.now();
		model.addAttribute("titulo", "Permisos");
		model.addAttribute("fecha1", "fecha1");
		model.addAttribute("fecha2", "fecha2");
		return ViewRouteHelper.PERMISO_ACTIVO;
	}
	
	/*@GetMapping("/{fecha1}+{fecha2}")
	public String periodoActivo(@PathVariable("fecha1") LocalDate fecha1, @PathVariable("fecha2") LocalDate fecha2, Model model) {

		List<PermisoPeriodo> listado = permisoPeriodoService.getAll();
		List<PermisoPeriodo> permisos = new ArrayList<PermisoPeriodo>();
		for (PermisoPeriodo p : listado) {
			LocalDate fechaVencimiento = p.getFecha().plusDays(p.getCantDias());
			if (fecha1.isAfter(p.getFecha()) && fecha2.isBefore(fechaVencimiento)
					|| fecha1.isEqual(p.getFecha()) || fecha2.isEqual(fechaVencimiento)) {
				permisos.add(p);
			}

		}
		model.addAttribute("titulo", "Permisos Activos");
		model.addAttribute("lista", permisos);

		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}*/
	
	@GetMapping("/fecha1")
	public String periodoActivo(@PathVariable("fecha1") LocalDate fecha1, Model model) {

		List<PermisoPeriodo> listado = permisoPeriodoService.getAll();
		List<PermisoPeriodo> permisos = new ArrayList<PermisoPeriodo>();
		for (PermisoPeriodo p : listado) {
			LocalDate fechaVencimiento = p.getFecha().plusDays(p.getCantDias());
			if (fecha1.isAfter(p.getFecha()) && fecha1.plusDays(10).isBefore(fechaVencimiento)
					|| fecha1.isEqual(p.getFecha()) || fecha1.isEqual(fechaVencimiento)) {
				permisos.add(p);
			}

		}
		model.addAttribute("titulo", "Permisos Activos");
		model.addAttribute("lista", permisos);

		return ViewRouteHelper.PERMISO_PERIODO_LISTA;
	}

}
