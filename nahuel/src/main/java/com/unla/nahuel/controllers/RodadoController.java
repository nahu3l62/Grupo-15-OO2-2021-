package com.unla.nahuel.controllers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.nahuel.entities.Rodado;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IRodadoService;

@Controller
@RequestMapping("/rodado")
public class RodadoController {
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@GetMapping("/")
	public String crear (Model model) {
		Rodado rodado = new Rodado();
		
		model.addAttribute("titulo", "Formulario: Nuevo Rodado");
		model.addAttribute("rodado", rodado);
		return ViewRouteHelper.RODADO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar (@Valid @ModelAttribute Rodado rodado, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Rodado");
			model.addAttribute("rodado", rodado);
			System.out.println("Hubo errores en la creacion del formulario!");
			return ViewRouteHelper.RODADO_CREAR;
		}
		rodadoService.save(rodado);
		System.out.println("Usuario guardado con exito!");
		return ViewRouteHelper.RODADO_REDIRECT;
	}
	
	@GetMapping("/lista")
	public String listarRodados(Model model) {
		List<Rodado> rodados = rodadoService.getAll();
		model.addAttribute("titulo", "Rodados");
		model.addAttribute("lista", rodados);
		return ViewRouteHelper.RODADO_LISTA;
	}
	
}
