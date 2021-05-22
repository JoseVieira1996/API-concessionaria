CREATE TABLE veiculo (
	id_veiculo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	id_montadora BIGINT(20) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	ano BIGINT(20) NOT NULL,
	FOREIGN KEY (id_montadora) REFERENCES montadora (id_montadora)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO veiculo (id_montadora, nome, ano) values (1, 'Onix', 2018);
INSERT INTO veiculo (id_montadora, nome, ano) values (5, 'Ranger', 2009);
INSERT INTO veiculo (id_montadora, nome, ano) values (2, 'Corolla', 2008);
INSERT INTO veiculo (id_montadora, nome, ano) values (3, 'Gol', 2020);
INSERT INTO veiculo (id_montadora, nome, ano) values (4, 'Toro', 2017);

