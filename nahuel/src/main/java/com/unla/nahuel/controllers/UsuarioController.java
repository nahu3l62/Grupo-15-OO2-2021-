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
import com.unla.nahuel.entities.Usuario;
import com.unla.nahuel.helpers.ViewRouteHelper;
import com.unla.nahuel.services.IPerfilesService;
import com.unla.nahuel.services.IUsuarioService;



@Controller
@RequestMapping("/usuarios")

public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	@Autowired
	@Qualifier("perfilesService")
	private IPerfilesService perfilesService;
	

	@GetMapping("/")
	public String crear(Model model) {

		Usuario usuario = new Usuario();
		List<Perfiles> listaPerfiles = perfilesService.getAll();
		if(listaPerfiles.isEmpty()) {
			Perfiles perfil1 = new Perfiles("Auditor");
			Perfiles perfil2 = new Perfiles("Administrador");
			perfilesService.save(perfil1);
			perfilesService.save(perfil2);
		}
		listaPerfiles = perfilesService.getAll();
		List<Perfiles> perfiles = new ArrayList<Perfiles>();
		for (Perfiles p : listaPerfiles) {
			if (p.isDeshabilitado() == false) {
				perfiles.add(p);
			}
		}
		model.addAttribute("titulo", "Formulario: Nuevo Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfiles", perfiles);

		return ViewRouteHelper.USUARIO_INDEX;
	}

	@PostMapping("/")
	public String guardar(@ModelAttribute Usuario usuario, Model model) {
		List<Perfiles> listaPerfiles = perfilesService.getAll();

		model.addAttribute("titulo", "Formulario: Nuevo Usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("perfiles", listaPerfiles);

		usuarioService.save(usuario);
		
		System.out.println("Usuario guardado con exito!");
		
		
		
		return "redirect:/usuarios/";

	}

	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<Usuario> listado = usuarioService.getAll();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (Usuario u : listado) {
			if (u.isDeshabilitado() == false) {
				usuarios.add(u);
			}
		}
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("lista", usuarios);

		return ViewRouteHelper.USUARIO_LISTA;
	}

	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id, Model model) {

		Usuario usuario1 = usuarioService.buscar(id);
		List<Perfiles> listaPerfiles = perfilesService.getAll();

		model.addAttribute("titulo", "Editar usuario");
		model.addAttribute("usuario", usuario1);
		model.addAttribute("perfiles", listaPerfiles);

		return ViewRouteHelper.USUARIO_FORM;
	}

	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id) {
		Usuario u = usuarioService.buscar(id);
		u.setDeshabilitado(true);
		usuarioService.save(u);
		System.out.println("Registro eliminado con exito");

		return ViewRouteHelper.ROUTE_REDIRECT;
	}

}