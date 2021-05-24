package com.unla.nahuel.helpers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class ViewRouteHelper {
	//Views
	public final static String INDEX = "home/index";
	public final static String HELLO = "home/hello";
	
	//Redirects
	public final static String ROUTE_INDEX = "/index";
	public final static String ROUTE_REDIRECT = "redirect:/usuarios/lista";
	
	//Usuario
	public final static String USUARIO_FORM = "usuario/form";
	public final static String USUARIO_NEW = "usuario/new";
	public final static String USUARIO_INDEX = "usuario/index";
	public final static String USUARIO_LISTA = "usuario/lista";
	
	//Redirects
	public final static String ROUTE = "/index";
	public final static String USUARIO_ROOT = "/usuarios/";
	
	/*public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";*/

	
	

}
