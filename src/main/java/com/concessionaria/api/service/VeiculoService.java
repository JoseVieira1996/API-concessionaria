package com.concessionaria.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.concessionaria.api.model.Veiculo;
import com.concessionaria.api.repository.VeiculoRepository;


@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public Veiculo atualizar(Long id_veiculo, Veiculo agencia) {
		Veiculo veiculoSalvo = veiculoRepository.getOne(id_veiculo);
		if (veiculoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(agencia, veiculoSalvo, "id_veiculo");
		return veiculoRepository.save(veiculoSalvo);
	}
	
	

	
	private Veiculo buscarPessoaPeloCodigo(Long id_veiculo) {
		Veiculo veiculoSalvo = veiculoRepository.getOne(id_veiculo);
		if (veiculoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return veiculoSalvo;
	}


}
