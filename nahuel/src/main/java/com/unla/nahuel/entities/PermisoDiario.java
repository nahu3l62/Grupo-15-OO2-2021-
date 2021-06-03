package com.unla.nahuel.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "permisoDiario")
@PrimaryKeyJoinColumn(referencedColumnName = "idPermiso")
public class PermisoDiario extends Permiso {

	@Column(name = "motivo")
	@NotEmpty(message = "Ingrese el motivo porfavor!")
	private String motivo;

	public PermisoDiario() {
	}

	public PermisoDiario(LocalDate fecha, Persona persona, String motivo) {
		super(fecha, persona);
		this.motivo = motivo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "PermisoDiario: Motivo: " + motivo;
	}

}
