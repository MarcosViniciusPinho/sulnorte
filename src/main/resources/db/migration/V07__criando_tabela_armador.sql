CREATE TABLE armador(
  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  contato VARCHAR(50),
  id_endereco INTEGER NOT NULL
);

ALTER TABLE armador ADD CONSTRAINT fk_arma_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id);