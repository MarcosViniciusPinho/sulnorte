CREATE TABLE filial(
  id INTEGER NOT NULL,
  nome VARCHAR(50) NOT NULL
);

ALTER TABLE filial ADD CONSTRAINT pk_id_filial PRIMARY KEY (id);