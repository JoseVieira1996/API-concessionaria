CREATE TABLE montadora (
	id_montadora BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO montadora (nome) values ('Chevrolet');
INSERT INTO montadora (nome) values ('Toyota');
INSERT INTO montadora (nome) values ('Volkswagen');
INSERT INTO montadora (nome) values ('Fiat');
INSERT INTO montadora (nome) values ('Ford');
INSERT INTO montadora (nome) values ('Honda');
INSERT INTO montadora (nome) values ('Peugeot');
INSERT INTO montadora (nome) values ('Citroen');
INSERT INTO montadora (nome) values ('Hyundai');
INSERT INTO montadora (nome) values ('Kia');