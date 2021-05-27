package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permisoPeriodo")
public class PermisoPeriodo extends Permiso {
	
	@Column(name = "cantDias")
	private int cantDias;
	
	@Column(name = "vacaciones")
	private boolean vacaciones;
	
	@ManyToOne
	@JoinColumn(name = "rodado_idRodado")
	private Rodado rodado;

	public PermisoPeriodo() {
	}

	public PermisoPeriodo(int cantDias, boolean vacaciones, Rodado rodado) {
		super();
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
