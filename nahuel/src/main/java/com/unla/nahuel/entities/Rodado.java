package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rodado", uniqueConstraints = { @UniqueConstraint(columnNames = { "dominio" }) })

public class Rodado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRodado;

	@Column(name = "dominio")
	@NotEmpty(message="El dominio no debe estar vacio")
	@Pattern(regexp="^[A-Z]{3}[0-9]{3}|[A-Z]{2}[0-9]{3}[A-Z]{2}", message="Dominio invalido. El formato tiene que ser del tipo 'AAA111' o 'AA111AA' ")
	
	private String dominio;

	@Column(name = "vehiculo")
	@NotEmpty(message="El vehiculo no debe estar vacio")
	private String vehiculo;

	public Rodado() {
	}

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
		return " Dominio: " + dominio + " Vehiculo: " + vehiculo;
	}

}