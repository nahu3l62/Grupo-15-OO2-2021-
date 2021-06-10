package com.unla.nahuel.controllers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.nahuel.entities.Rodado;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IRodadoService;

@Controller
@RequestMapping("/rodado")
public class RodadoController {
	
	@Autowired
	@Qualifier("rodadoService")
	private IRodadoService rodadoService;
	
	@GetMapping("/seleccionarDominio")
	public String seleccionarDni(Model model) {
		return ViewRouteHelper.RODADO_SELECCIONAR_DOMINIO;
	}
	
	@GetMapping("/dominio")
	public String listarRodado(@RequestParam String dominio, Model model,RedirectAttributes attribute) {
		List<Rodado> rodados = new ArrayList<Rodado>();
		model.addAttribute("titulo", "Rodado");
		Rodado rodado1 = rodadoService.findByDominio(dominio);
		if(rodado1==null) {
			attribute.addFlashAttribute("success","Este dominio no se encuentra en la base de datos");
			return ViewRouteHelper.RODADO_SELECCIONAR_DOMINIO_REDIRECT;
		}
		/*
		for(int i=0;i<dominio.length();i++) {
			if(dominio[i]==) {
				attribute.addFlashAttribute("success","Este dominio no se encuentra en la base de datos");
				return ViewRouteHelper.RODADO_CREAR;
			}
		}*/
		
		rodados.add(rodado1);
		model.addAttribute("lista", rodados);
		return ViewRouteHelper.RODADO_LISTA;
	}
	
	@GetMapping("/")
	public String crear (Model model) {
		Rodado rodado = new Rodado();
		model.addAttribute("titulo", "Formulario: Nuevo Rodado");
		model.addAttribute("rodado", rodado);
		return ViewRouteHelper.RODADO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar (@Valid @ModelAttribute Rodado rodado, BindingResult result, Model model,RedirectAttributes attribute) {
		if(rodadoService.findByDominio(rodado.getDominio())!=null) {
			FieldError error = new FieldError("rodado", "dominio", "Ya existe un Rodado con ese dominio.");
			result.addError(error);
		}
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Rodado");
			model.addAttribute("rodado", rodado);
			System.out.println("Hubo errores en la creacion del formulario!");
			return ViewRouteHelper.RODADO_CREAR;
		}
		rodadoService.save(rodado);
		System.out.println("Usuario guardado con exito!");
		attribute.addFlashAttribute("success","Rodado agregado con exito");
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
