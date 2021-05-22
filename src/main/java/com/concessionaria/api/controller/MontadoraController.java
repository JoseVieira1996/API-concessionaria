package com.concessionaria.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.concessionaria.api.model.Montadora;
import com.concessionaria.api.repository.MontadoraRepository;
import com.concessionaria.api.service.MontadoraService;

@RestController
@RequestMapping("/montadoras")
public class MontadoraController {

	@Autowired
	private MontadoraRepository montadoraRepository;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Montadora> montadoras() {
		return montadoraRepository.findAll();
	}
	


	
	@GetMapping("/{id}")
	public ResponseEntity <Montadora> buscarPeloId (@PathVariable Long id){
		Montadora montadora = montadoraRepository.findById(id).orElse(null);
		return montadora != null ? ResponseEntity.ok(montadora) : ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public ResponseEntity<Montadora> criar(@Valid @RequestBody Montadora montadora, HttpServletResponse response){
		Montadora montadoraSalva = montadoraRepository.save(montadora);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(montadoraSalva.getId_montadora()).toUri();
				response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(montadoraSalva);
}
	
	@DeleteMapping("/{id}")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long id) {
		montadoraRepository.deleteById(id);
	}
	
	/*
	@PutMapping("/{id}")
	public ResponseEntity<Montadora> atualizar(@PathVariable Long codigo, @Valid @RequestBody Montadora montadora) {
		Montadora montadoraSalva = MontadoraService.atualizar(codigo, montadora);
		return ResponseEntity.ok(montadoraSalva);
	}
	
	*/
	
	
}

