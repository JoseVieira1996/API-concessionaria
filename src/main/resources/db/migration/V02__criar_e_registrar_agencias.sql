CREATE TABLE agencia (
	id_agencia BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO agencia (nome) values ('Lojão do carro');
INSERT INTO agencia (nome) values ('+ Barato');
INSERT INTO agencia (nome) values ('Localiza Cars');
INSERT INTO agencia (nome) values ('Best Cars');
INSERT INTO agencia (nome) values ('Carro Mil');
INSERT INTO agencia (nome) values ('CompreCarro');