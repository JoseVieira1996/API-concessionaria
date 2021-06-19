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

	public Montadora atualizar(Long id_montadora, Montadora montadora) {
		Montadora montadoraSalva = buscarPessoaPeloCodigo(id_montadora);
		
		BeanUtils.copyProperties(montadora, montadoraSalva,"id_montadora");
		return montadoraRepository.save(montadoraSalva);
	}
	
	

	
	
	
	private Montadora buscarPessoaPeloCodigo(Long id_montadora) {
		Montadora montadoraSalva = montadoraRepository.getOne(id_montadora);
		if (montadoraSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return montadoraSalva;
	}


}
