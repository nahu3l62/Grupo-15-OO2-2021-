package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "rodado", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"dominio"})
		})


public class Rodado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRodado;
	
	@Column(name = "dominio")
	@NotEmpty
	private String dominio;
	
	@Column(name = "vehiculo")
	@NotEmpty
	private String vehiculo;
	

	public Rodado() {}

	public Rodado(String dominio, String vehiculo) {
		super();
		this.dominio = dominio;
		this.vehiculo = vehiculo;
	}
	
	public long getIdRodado() {
		return idRodado;
	}

	protected void setIdRodado(long idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return " Dominio: " + dominio + "-Vehiculo: " + vehiculo;
	}

}