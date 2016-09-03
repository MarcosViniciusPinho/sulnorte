CREATE TABLE endereco(
  id INTEGER NOT NULL,
  logradouro VARCHAR(150) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  numero VARCHAR(10),
  id_pais INTEGER NOT NULL,
  id_estado INTEGER NOT NULL,
  id_municipio INTEGER NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT pk_id_endereco PRIMARY KEY (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_pais FOREIGN KEY (id_pais) REFERENCES pais (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_estado FOREIGN KEY (id_estado) REFERENCES estado (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_municipio FOREIGN KEY (id_municipio) REFERENCES municipio (id);
