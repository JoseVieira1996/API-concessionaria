package com.concessionaria.api.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Veiculo> veiculos(Pageable pageable) {
		return veiculoRepository.findAll();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscarPeloId (@PathVariable Long id){
		Veiculo veiculo = veiculoRepository.findById(id).orElse(null);
		return veiculo != null ? ResponseEntity.ok(veiculo) : ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public ResponseEntity<Veiculo> criar(@Valid @RequestBody Veiculo veiculo, HttpServletResponse response){
		Veiculo veiculoSalvo = veiculoRepository.save(veiculo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(veiculoSalvo.getId_veiculo()).toUri();
				response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(veiculoSalvo);

}
	
	
	@DeleteMapping("/{id}")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long id) {
		veiculoRepository.deleteById(id);
	}
	
	
	
}
