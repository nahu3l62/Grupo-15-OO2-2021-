package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column(name = "nombre")
	private String nombre;


	@Column(name = "apellido")
	private String apellido;
	

	@Column(name = "tipoDocumento")
	private String tipoDocumento;

	
	@Column(name = "documento")
	private int documento;


	@Column(name = "correoElectronico")
	private String correoElectronico;


	@Column(name = "nombreDeUsuario")
	private String nombreDeUsuario;


	@Column(name = "contrasena")
	private String contrasena;

	@ManyToOne
	@JoinColumn(name = "perfiles_id")
	private Perfiles perfiles;

	@Column(name = "deshabilitado")
	private boolean deshabilitado;

	public Usuario() {
	}

	public Usuario(long id, String nombre, String apellido, String tipoDocumento, int documento,
			String correoElectronico, String nombreDeUsuario, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correoElectronico = correoElectronico;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;

	}

	public Usuario(String nombre, String apellido, String tipoDocumento, int documento, String correoElectronico,
			String nombreDeUsuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correoElectronico = correoElectronico;
		this.nombreDeUsuario = nombreDeUsuario;
		this.contrasena = contrasena;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Perfiles getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Perfiles perfiles) {
		this.perfiles = perfiles;
	}

	public boolean isDeshabilitado() {
		return deshabilitado;
	}

	public void setDeshabilitado(boolean deshabilitado) {
		this.deshabilitado = deshabilitado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento="
				+ tipoDocumento + ", documento=" + documento + ", correoElectronico=" + correoElectronico
				+ ", nombreDeUsuario=" + nombreDeUsuario + ", contrasena=" + contrasena + ", perfiles=" + perfiles
				+ "]";
	}

}