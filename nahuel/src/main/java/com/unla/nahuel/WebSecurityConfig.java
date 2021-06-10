package com.unla.nahuel;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passEncoder)
		.usersByUsernameQuery("SELECT nombre_de_usuario, contrasena, deshabilitado from usuario where nombre_de_usuario=?")
		.authoritiesByUsernameQuery("SELECT u.nombre_de_usuario, p.rol from perfiles p inner join usuario u on p.id=u.perfiles_id where u.nombre_de_usuario=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/index","/","/css/**","/images/**","/js/**","/vendor/**").permitAll()
		.antMatchers("/permiso/lista/permisoDiario/qr/**").anonymous()
		.antMatchers("/permiso/lista/permisoPeriodo/qr/**").anonymous()
		.antMatchers("/permiso/**").access("anonymous or hasAuthority('Auditor')")//traer permiso por persona
		.antMatchers("/permiso/seleccionarDni").access("anonymous or hasAuthority('Auditor')")//traer permiso por persona
		.antMatchers("/permiso/lugar").hasAuthority("Auditor")//traer permiso por lugar
		.antMatchers("/permiso/periodoXlugar/**").hasAuthority("Auditor")//traer permiso por lugar(diario)
		.antMatchers("/permiso/diarioXlugar/**").hasAuthority("Auditor")//traer permiso por lugar(periodo)
		.antMatchers("/permiso/activo").hasAuthority("Auditor")//traer permiso activo
		.antMatchers("/permiso/fecha").hasAuthority("Auditor")//traer permiso activo(diario)
		.antMatchers("/permiso/activoDiario").hasAuthority("Auditor")//traer permiso activo
		.antMatchers("/permiso/activoFechaLugarDiario").hasAuthority("Auditor")//traer permiso activo
		.antMatchers("/permiso/activoFechaLugarPeriodo").hasAuthority("Auditor")//traer permiso activo
		.antMatchers("/permiso/traerFechaLugarPeriodo").hasAuthority("Auditor")//traer permiso activo
		.antMatchers("/permiso/traerFechaLugarDiario").hasAuthority("Auditor")//traer permiso activo
		.antMatchers("/permiso/fechaDiario").hasAuthority("Auditor")//traer permiso activo(periodo)
		.antMatchers("/permiso_periodo/rodados/**").hasAuthority("Auditor")
		.antMatchers("/permiso/lista/permisoDiario/**").access("anonymous or hasAuthority('Auditor')")//traer permiso por persona(diario)
		.antMatchers("/permiso/lista/permisoPeriodo/**").access("anonymous or hasAuthority('Auditor')")//traer permiso por persona(periodo)
		.antMatchers("/permiso_diario/").anonymous()
		.antMatchers("/permiso_diario/**").anonymous()
		.antMatchers("/permiso_diario/lista").permitAll()
		.antMatchers("/permiso_diario/seleccionarDni").anonymous()
		.antMatchers("/permiso_periodo/").anonymous()
		.antMatchers("/permiso_periodo/**").anonymous()
		.antMatchers("/permiso_periodo/lista").permitAll()
		.antMatchers("/permiso_periodo/seleccionarDni").anonymous()
		.antMatchers("/persona/").anonymous()
		.antMatchers("/perfiles/").hasAuthority("Administrador")
		.antMatchers("/perfiles/lista").hasAnyAuthority("Auditor", "Administrador")
		.antMatchers("/perfiles/lista/edit/**").hasAuthority("Administrador")
		.antMatchers("/perfiles/lista/delete/**").hasAuthority("Administrador")
		.antMatchers("/perfiles/lista").hasAnyAuthority("Auditor", "Administrador")
		.antMatchers("/perfiles/lista/**").hasAnyAuthority("Auditor", "Administrador")//pdf
		.antMatchers("/rodado/").anonymous()
		.antMatchers("/rodado/seleccionarDominio").hasAuthority("Auditor")
		.antMatchers("/rodado/dominio").hasAuthority("Auditor")
		.antMatchers("/rodado/lista").hasAuthority("Auditor")
		.antMatchers("/usuarios/").hasAuthority("Administrador")
		.antMatchers("/usuarios/lista").hasAnyAuthority("Auditor", "Administrador")
		.antMatchers("/usuarios/lista/**").hasAnyAuthority("Auditor", "Administrador")//pdf
		.antMatchers("/usuarios/lista/edit/**").hasAuthority("Administrador")
		.antMatchers("/usuarios/lista/delete/**").hasAuthority("Administrador")
		
				
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
	}
	
}
