CREATE TABLE armador(
  id INTEGER NOT NULL,
  nome VARCHAR(100) NOT NULL,
  contato INTEGER,
  id_endereco INTEGER NOT NULL
);

ALTER TABLE armador ADD CONSTRAINT pk_id_armador PRIMARY KEY (id);

ALTER TABLE armador ADD CONSTRAINT fk_arma_id_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id);