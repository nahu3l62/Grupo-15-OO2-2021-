package com.unla.nahuel.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.nahuel.entities.User;
import com.unla.nahuel.helpers.ViewRouteHelper;



@Controller
@RequestMapping("/")
public class HomeController {
	
	
		@GetMapping("/index")
		public ModelAndView index() {
			ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
			//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//modelAndView.addObject("username", user.getUsername());
			return modelAndView;
		}
	
		/*@GetMapping("/usuario")
		public String degree(Model model) {
			model.addAttribute("usuario", new UsuarioModel());
			return ViewRouteHelper.USUARIO_INDEX;
		}*/
	
	
	/*Ejemplo server/index
			@GetMapping("/index")
			public String index() {
				return "home/index";
			}
			
			//Ejemplo server/hello?name=someName
			@GetMapping("/hello")
			public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null")String name) {
				ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
				mV.addObject("name",name);
				return mV;	
			}
			
			//Ejemplo server/hello/someName
			@GetMapping("/hello/{name}")
			public ModelAndView helloParams2(@PathVariable("name") String name) {
				ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
				mV.addObject("name",name);
				return mV;
			}
			
			/*@GetMapping("/")
			public RedirectView redirectToHomeIndex() {
				return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
			}*/
	
			
			
			


}
