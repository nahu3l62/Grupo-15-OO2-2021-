package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfiles")

public class Perfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="rol")
	private String rol;
	
	
	public Perfiles() {}
	

	public Perfiles(long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}


	public Perfiles(String rol) {
		super();
		this.rol = rol;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return rol;
	}
	


	


	
	
	
}