CREATE TABLE propulsao(
  id INTEGER NOT NULL,
  nome VARCHAR(20) NOT NULL
);

ALTER TABLE propulsao ADD CONSTRAINT pk_id_prop PRIMARY KEY (id);