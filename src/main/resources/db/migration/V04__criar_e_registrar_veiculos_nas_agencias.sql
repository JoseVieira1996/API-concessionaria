CREATE TABLE veiculos_nas_agencias (
	id_veiculo BIGINT(20) NOT NULL,
	id_agencia BIGINT(20) NOT NULL, 
	FOREIGN KEY (id_veiculo) REFERENCES veiculo (id_veiculo),
	FOREIGN KEY (id_agencia) REFERENCES agencia (id_agencia)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO veiculos_nas_agencias (id_veiculo, id_agencia) values (1,1);
INSERT INTO veiculos_nas_agencias (id_veiculo, id_agencia) values (4,1);
INSERT INTO veiculos_nas_agencias (id_veiculo, id_agencia) values (3,2);
INSERT INTO veiculos_nas_agencias (id_veiculo, id_agencia) values (2,1);
