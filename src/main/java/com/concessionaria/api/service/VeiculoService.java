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

	public Veiculo atualizar(Long codigo, Veiculo agencia) {
		Veiculo veiculoSalva = veiculoRepository.getOne(codigo);
		if (veiculoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(agencia, veiculoSalva, "codigo");
		return veiculoRepository.save(veiculoSalva);
	}
	
	

	
	
	
	private Veiculo buscarPessoaPeloCodigo(Long codigo) {
		Veiculo veiculoSalva = veiculoRepository.getOne(codigo);
		if (veiculoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return veiculoSalva;
	}


}
