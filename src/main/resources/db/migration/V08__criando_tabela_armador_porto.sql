CREATE TABLE armador_porto(
  id_armador INTEGER NOT NULL,
  id_porto INTEGER NOT NULL
);

ALTER TABLE armador_porto ADD CONSTRAINT fk_arpo_id_armador FOREIGN KEY (id_armador) REFERENCES armador (id);

ALTER TABLE armador_porto ADD CONSTRAINT fk_arpo_id_porto FOREIGN KEY (id_porto) REFERENCES porto (id);