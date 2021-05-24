package com.unla.nahuel.controllers;


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


import com.unla.nahuel.helpers.ViewRouteHelper;



@Controller
@RequestMapping("/")
public class HomeController {
	
	
		@GetMapping("/")
		public ModelAndView index() {
			ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
			return modelAndView;
		}
		
		@GetMapping("/index")
		public ModelAndView indexx() {
			ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
			return modelAndView;
		}
		
}
