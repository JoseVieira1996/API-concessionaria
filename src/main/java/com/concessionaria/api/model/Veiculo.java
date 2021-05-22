package com.concessionaria.api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_veiculo;
	
	
	@ManyToOne
	@JoinColumn(name = "id_montadora")
	private Montadora montadora;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String ano;
	
	@JsonIgnore
	@ManyToMany(mappedBy="veiculos_nas_agencias")
	private Set<Agencia> agencias = new HashSet<>();

	

	

	public Set<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(Set<Agencia> agencias) {
		this.agencias = agencias;
	}

	public Long getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Long id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	
	

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_veiculo == null) ? 0 : id_veiculo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (id_veiculo == null) {
			if (other.id_veiculo != null)
				return false;
		} else if (!id_veiculo.equals(other.id_veiculo))
			return false;
		return true;
	}
	
	
	
}

