package com.concessionaria.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.concessionaria.api.model.Montadora;
import com.concessionaria.api.repository.MontadoraRepository;


@Service
public class MontadoraService {
	
	@Autowired
	private MontadoraRepository montadoraRepository;

	public Montadora atualizar(Long codigo, Montadora montadora) {
		Montadora montadoraSalva = montadoraRepository.getOne(codigo);
		if (montadoraSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(montadora, montadoraSalva, "codigo");
		return montadoraRepository.save(montadoraSalva);
	}
	
	

	
	
	
	private Montadora buscarPessoaPeloCodigo(Long codigo) {
		Montadora montadoraSalva = montadoraRepository.getOne(codigo);
		if (montadoraSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return montadoraSalva;
	}


}
