CREATE TABLE porto(
  id INTEGER NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cnpj INTEGER,
  id_endereco INTEGER NOT NULL,
  id_filial INTEGER
);

ALTER TABLE porto ADD CONSTRAINT pk_id_porto PRIMARY KEY (id);

ALTER TABLE porto ADD CONSTRAINT fk_port_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id);

ALTER TABLE porto ADD CONSTRAINT fk_port_id_filial FOREIGN KEY (id_filial) REFERENCES filial (id);