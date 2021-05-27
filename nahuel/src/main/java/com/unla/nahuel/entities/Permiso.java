package com.unla.nahuel.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permiso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Permiso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idPermiso;
	
	@Column(name = "fecha")
	protected LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "persona_idPersona")
	protected Persona persona;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="lugar_idLugar", nullable=false)
	protected Set<Lugar> desdeHasta;

	public Permiso() {}

	public Permiso(LocalDate fecha, Persona persona) {
		super();
		this.fecha = fecha;
		this.setPersona(persona);
	}

	public int getIdPermiso() {
		return idPermiso;
	}

	protected void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Set<Lugar> getDesdeHasta() {
		return desdeHasta;
	}

	public void setDesdeHasta(Set<Lugar> desdeHasta) {
		this.desdeHasta = desdeHasta;
	}

	

	@Override
	public String toString() {
		return "Permiso: " + idPermiso + " Fecha: " + fecha;
	}

}