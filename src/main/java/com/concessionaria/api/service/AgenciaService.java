package com.concessionaria.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.concessionaria.api.model.Agencia;
import com.concessionaria.api.repository.AgenciaRepository;


@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;

	public Agencia atualizar(Long codigo, Agencia agencia) {
		Agencia agenciaSalva = agenciaRepository.getOne(codigo);
		if (agenciaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(agencia, agenciaSalva, "codigo");
		return agenciaRepository.save(agenciaSalva);
	}
	
	

	
	
	
	private Agencia buscarAgenciaPeloCodigo(Long codigo) {
		Agencia agenciaSalva = agenciaRepository.getOne(codigo);
		if (agenciaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return agenciaSalva;
	}


}
