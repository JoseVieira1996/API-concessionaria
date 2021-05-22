package com.concessionaria.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="montadora")
public class Montadora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_montadora;
	
	@NotNull
	@Size(min=2)
	private String nome;


	

	public Long getId_montadora() {
		return id_montadora;
	}

	public void setId_montadora(Long id_montadora) {
		this.id_montadora = id_montadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_montadora == null) ? 0 : id_montadora.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Montadora other = (Montadora) obj;
		if (id_montadora == null) {
			if (other.id_montadora != null)
				return false;
		} else if (!id_montadora.equals(other.id_montadora))
			return false;
		return true;
	}
	
	

}
