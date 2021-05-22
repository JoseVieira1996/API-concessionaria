package com.concessionaria.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.concessionaria.api.model.Agencia;
import com.concessionaria.api.model.Montadora;
import com.concessionaria.api.model.Veiculo;
import com.concessionaria.api.repository.AgenciaRepository;
import com.concessionaria.api.repository.VeiculoRepository;

@RestController
@RequestMapping("/agencias")
public class AgenciaController {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public List<Agencia> getAgencias(){
		return agenciaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agencia> buscarPeloId (@PathVariable Long id){
		Agencia agencia = agenciaRepository.findById(id).orElse(null);
		return agencia != null ? ResponseEntity.ok(agencia) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Agencia> criar(@Valid @RequestBody Agencia agencia, HttpServletResponse response){
		Agencia agenciaSalva = agenciaRepository.save(agencia);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(agenciaSalva.getId_agencia()).toUri();
				response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(agenciaSalva);

}

	@DeleteMapping("/{id}")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long id) {
		agenciaRepository.deleteById(id);
	}
	
	 @PutMapping("/{agenciaId}/veiculos/{veiculoId}")
	    Agencia addVeiculoToAgencia(
	            @PathVariable Long agenciaId,
	            @PathVariable Long veiculoId
	    ) {
	        Agencia agencia = agenciaRepository.findById(agenciaId).get();
	        Veiculo veiculo = veiculoRepository.findById(veiculoId).get();
	        agencia.getVeiculos_nas_agencias().add(veiculo);
	        return agenciaRepository.save(agencia);
	    }

}
