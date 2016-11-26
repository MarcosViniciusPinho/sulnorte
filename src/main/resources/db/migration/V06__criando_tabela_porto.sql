CREATE TABLE porto(
  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cnpj BIGINT,
  id_endereco INTEGER NOT NULL,
  id_filial INTEGER
);

ALTER TABLE porto ADD CONSTRAINT fk_port_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id);

ALTER TABLE porto ADD CONSTRAINT fk_port_id_filial FOREIGN KEY (id_filial) REFERENCES filial (id);