CREATE TABLE endereco(
  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  logradouro VARCHAR(50) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  complemento VARCHAR(80),
  id_pais INTEGER NOT NULL,
  id_estado INTEGER NOT NULL,
  id_municipio INTEGER NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_pais FOREIGN KEY (id_pais) REFERENCES pais (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_estado FOREIGN KEY (id_estado) REFERENCES estado (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_municipio FOREIGN KEY (id_municipio) REFERENCES municipio (id);
