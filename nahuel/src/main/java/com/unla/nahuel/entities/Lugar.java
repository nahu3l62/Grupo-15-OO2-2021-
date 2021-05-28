package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lugar")
public class Lugar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLugar;
	
	@Column(name = "lugar")
	private String lugar;
	
	@Column(name = "codPostal")
	private String codPostal;
	
	public Lugar() {
	}
	
	public Lugar(String lugar, String codPostal) {
		super();
		this.lugar = lugar;
		this.codPostal = codPostal;
	}

	public long getIdLugar() {
		return idLugar;
	}

	protected void setIdLugar(long idLugar) {
		this.idLugar = idLugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}


	@Override
	public String toString() {
		return "Lugar: " + idLugar + " Lugar: " + lugar + " CodigoPostal: " + codPostal;
	}
	
}