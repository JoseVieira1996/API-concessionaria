package com.concessionaria.api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_agencia;
	
	@NotNull
	private String nome;
	
	@ManyToMany
	@JoinTable(name="veiculos_nas_agencias",
	joinColumns = @JoinColumn(name="id_agencia"),
	inverseJoinColumns = @JoinColumn(name="id_veiculo"))
	private Set<Veiculo> veiculos_nas_agencias  = new HashSet<>();

	
	

	public void setVeiculos_nas_agencias(Set<Veiculo> veiculos_nas_agencias) {
		this.veiculos_nas_agencias = veiculos_nas_agencias;
	}



	public Set<Veiculo> getVeiculos_nas_agencias() {
		return veiculos_nas_agencias;
	}

	

	public Long getId_agencia() {
		return id_agencia;
	}

	public void setId_agencia(Long id_agencia) {
		this.id_agencia = id_agencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void veiculos_nas_agencias(Veiculo veiculo) {
		veiculos_nas_agencias.add(veiculo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_agencia == null) ? 0 : id_agencia.hashCode());
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
		Agencia other = (Agencia) obj;
		if (id_agencia == null) {
			if (other.id_agencia != null)
				return false;
		} else if (!id_agencia.equals(other.id_agencia))
			return false;
		return true;
	}
	
	
}


