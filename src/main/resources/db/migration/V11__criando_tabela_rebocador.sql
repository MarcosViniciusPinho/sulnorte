CREATE TABLE rebocador(
  id INTEGER NOT NULL,
  nome VARCHAR(100) NOT NULL,
  ano INTEGER(4),
  bp NUMERIC(10,2),
  bhp NUMERIC(10,2),
  observacao VARCHAR(255),
  id_situacao_rebocador INTEGER NOT NULL,
  id_propulsao INTEGER,
  id_armador INTEGER NOT NULL,
  id_porto INTEGER NOT NULL
);

ALTER TABLE rebocador ADD CONSTRAINT pk_id_rebocador PRIMARY KEY (id);

ALTER TABLE rebocador ADD CONSTRAINT fk_sire_id FOREIGN KEY (id_situacao_rebocador) REFERENCES situacao_rebocador (id);

ALTER TABLE rebocador ADD CONSTRAINT fk_prop_id FOREIGN KEY (id_propulsao) REFERENCES propulsao (id);

ALTER TABLE rebocador ADD CONSTRAINT fk_arma_id FOREIGN KEY (id_armador) REFERENCES armador (id);

ALTER TABLE rebocador ADD CONSTRAINT fk_port_id FOREIGN KEY (id_porto) REFERENCES porto (id);