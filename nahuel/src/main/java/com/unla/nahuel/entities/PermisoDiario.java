package com.unla.nahuel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permisoDiario")
public class PermisoDiario extends Permiso {
	
	@Column(name = "motivo")
	private String motivo;

	public PermisoDiario() {}
	
	public PermisoDiario(String motivo) {
		super();
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
		return "PermisoDiario: " + getIdPermiso() + " Motivo=" + motivo;
	}

}
