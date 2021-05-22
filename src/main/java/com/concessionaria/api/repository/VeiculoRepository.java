package com.concessionaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.api.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
