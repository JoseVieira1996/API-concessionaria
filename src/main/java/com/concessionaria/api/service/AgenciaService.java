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

	public Agencia atualizar(Long id_agencia, Agencia agencia) {
		Agencia agenciaSalva = agenciaRepository.getOne(id_agencia);
		if (agenciaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(agencia, agenciaSalva, "id_agencia");
		return agenciaRepository.save(agenciaSalva);
	}
	
	

	
	
	
	private Agencia buscarAgenciaPeloCodigo(Long id_agencia) {
		Agencia agenciaSalva = agenciaRepository.getOne(id_agencia);
		if (agenciaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return agenciaSalva;
	}


}
