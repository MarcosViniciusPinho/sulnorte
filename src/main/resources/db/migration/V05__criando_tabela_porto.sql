CREATE TABLE porto(
  id INTEGER NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cnpj INTEGER,
  filial VARCHAR(50) NOT NULL,
  id_endereco INTEGER NOT NULL
);

ALTER TABLE porto ADD CONSTRAINT pk_id_porto PRIMARY KEY (id);

ALTER TABLE porto ADD CONSTRAINT fk_port_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id);