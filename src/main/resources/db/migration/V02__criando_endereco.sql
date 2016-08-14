CREATE SEQUENCE sq_endereco INCREMENT BY 1 START WITH 1000;

CREATE TABLE endereco(
  id NUMBER(11) NOT NULL,
  logradouro VARCHAR(150) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  numero NUMBER(10),
  id_pais NUMBER(11) NOT NULL,
  id_estado NUMBER(11) NOT NULL,
  id_municipio NUMBER(11) NOT NULL
);

ALTER TABLE endereco ADD CONSTRAINT pk_id_endereco PRIMARY KEY (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_pais FOREIGN KEY (id_pais) REFERENCES pais (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_estado FOREIGN KEY (id_estado) REFERENCES estado (id);

ALTER TABLE endereco ADD CONSTRAINT fk_ende_id_municipio FOREIGN KEY (id_municipio) REFERENCES municipio (id);
