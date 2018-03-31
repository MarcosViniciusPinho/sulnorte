CREATE TABLE estado(
  id INTEGER NOT NULL,
  id_pais INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL,
  sigla VARCHAR(5) NOT NULL
);

ALTER TABLE estado ADD CONSTRAINT pk_id_estado PRIMARY KEY (id);

ALTER TABLE estado ADD CONSTRAINT fk_esta_id_pais FOREIGN KEY (id_pais) REFERENCES pais (id);
