CREATE TABLE municipio(
  id INTEGER NOT NULL,
  id_estado INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL
);

ALTER TABLE municipio ADD CONSTRAINT pk_id_municipio PRIMARY KEY (id);

ALTER TABLE municipio ADD CONSTRAINT fk_muni_id_estado FOREIGN KEY (id_estado) REFERENCES estado (id);
