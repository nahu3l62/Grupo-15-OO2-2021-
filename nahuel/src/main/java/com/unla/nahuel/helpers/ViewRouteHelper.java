package com.unla.nahuel.helpers;


public class ViewRouteHelper {
	//Views
	public final static String INDEX = "home/index";
	
	//Redirects
	public final static String ROUTE_INDEX = "/index";
	public final static String ROUTE_REDIRECT = "redirect:/usuarios/lista";
	public final static String USUARIO_REDIRECT= "redirect:/usuarios/";
	public final static String PERFIL_REDIRECT = "redirect:/perfiles/";
	public final static String PERFIL_REDIRECT_LISTA = "redirect:/perfiles/lista";
	public final static String PERSONA_REDIRECT = "redirect:/persona/";
	public final static String PERMISO_DIARIO_REDIRECT = "redirect:/permiso_diario/";
	public final static String PERMISO_PERIODO_REDIRECT = "redirect:/permiso_periodo/";
	public final static String RODADO_REDIRECT = "redirect:/rodado/";


	//Usuario
	public final static String USUARIO_FORM = "usuario/form";
	public final static String USUARIO_INDEX = "usuario/index";
	public final static String USUARIO_LISTA = "usuario/lista";
	
	//Permiso
	public final static String PERMISO_CREAR = "permiso/crear";
	public final static String PERMISO_ACTIVO = "permiso/activo";
	public final static String PERMISO_DIARIO = "permiso/activoDiario";
	public final static String PERMISO_TRAER = "permiso/traer";
	public final static String PERMISO_ACTIVOXFECHAYLUGAR_DIARIO = "permiso/activoLugarDiario";
	public final static String PERMISO_ACTIVOXFECHAYLUGAR_PERIODO = "permiso/activoLugarPeriodo";
	public final static String PERMISO_SELECCIONAR_DNI = "permiso/seleccionarDni";
	public final static String PERMISO_DNI_REDIRECT = "redirect:/permiso/seleccionarDni";
	



	//PermisoDiario
	public final static String PERMISO_DIARIO_SELECCIONAR_DNI = "permiso_diario/activo";
	public final static String PERMISO_DIARIO_CREAR = "permiso_diario/crear";
	public final static String PERMISO_DIARIO_LISTA = "permiso_diario/lista";
	public final static String PERMISO_DIARIO_ERROR = "permiso_diario/activoError";
	public final static String PERMISO_SELECCIONAR_DNI_REDIRECT = "redirect:/permiso_diario/seleccionarDni";
	public final static String PERMISO_DIARIO_QR = "permiso_diario/qr";
	
	
	
	//PermisoPeriodo
	public final static String PERMISO_PERIODO_SELECCIONAR_DNI = "permiso_periodo/activo";
	public final static String PERMISO_PERIODO_CREAR = "permiso_periodo/crear";
	public final static String PERMISO_PERIODO_LISTA = "permiso_periodo/lista";
	public final static String PERMISO_PERIODO_RODADO = "permiso_periodo/rodado";	
	public final static String PERMISO_PERIODO_SELECCIONAR_DNI_REDIRECT = "redirect:/permiso_periodo/seleccionarDni";
	public final static String PERMISO_PERIODO_QR = "permiso_diario/qr";
	
	
	//Persona
	public final static String PERSONA_CREAR = "persona/crear";
	
	//Rodado
	public final static String RODADO_CREAR = "rodado/crear";
	public final static String RODADO_LISTA = "rodado/lista";
	public final static String RODADO_SELECCIONAR_DOMINIO = "rodado/seleccionarRodado";
	public final static String RODADO_SELECCIONAR_DOMINIO_REDIRECT = "redirect:/rodado/seleccionarDominio";

	//Perfiles
	public final static String PERFIL_CREAR = "perfil/crear";
	public final static String PERFIL_LISTA = "perfil/lista";

	//Redirects
	public final static String ROUTE = "/index";
	public final static String USUARIO_ROOT = "/usuarios/";

	
	

}
