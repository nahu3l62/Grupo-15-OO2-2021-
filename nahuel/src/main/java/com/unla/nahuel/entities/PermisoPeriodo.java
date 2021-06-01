package com.unla.nahuel.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "permisoPeriodo")
@PrimaryKeyJoinColumn(referencedColumnName="idPermiso") 
public class PermisoPeriodo extends Permiso {
	
	@Column(name = "cantDias")
	@NotNull
	private int cantDias;
	
	@Column(name = "vacaciones")
	@NotNull(message="Porfavor seleccione la opcion correcta!")
	private boolean vacaciones;
	
	@ManyToOne
	@JoinColumn(name = "rodado_idRodado")
	private Rodado rodado;

	public PermisoPeriodo() {
	}

	public PermisoPeriodo(LocalDate fecha, Persona persona, int cantDias, boolean vacaciones, Rodado rodado) {
		super(fecha, persona);
		this.cantDias = cantDias;
		this.vacaciones = vacaciones;
		this.rodado = rodado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}
	
	@Override
	public String toString() {
		return "PermisoPeriodo: " + getIdPermiso() + " CantDias: " + cantDias + " Vacaciones: " + vacaciones;
	}

}
