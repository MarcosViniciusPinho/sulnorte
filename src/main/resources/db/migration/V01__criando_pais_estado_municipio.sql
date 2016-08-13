CREATE SEQUENCE sq_pais INCREMENT BY 1 START WITH 1000;

CREATE TABLE pais(
  id NUMBER(11) NOT NULL,
  nome varchar(50) NOT NULL,
);

ALTER TABLE pais ADD CONSTRAINT pk_id_pais PRIMARY KEY (id);

CREATE SEQUENCE sq_estado INCREMENT BY 1 START WITH 1000;

CREATE TABLE estado(
  id NUMBER(11) NOT NULL,
  id_pais NUMBER(11) NOT NULL,
  nome varchar(50) NOT NULL,
);

ALTER TABLE estado ADD CONSTRAINT pk_id_estado PRIMARY KEY (id);

ALTER TABLE estado ADD CONSTRAINT fk_id_pais FOREIGN KEY (id_pais) REFERENCES pais (id);

CREATE SEQUENCE sq_municipio INCREMENT BY 1 START WITH 1000;                                                                      

CREATE TABLE municipio(
  id NUMBER(11) NOT NULL,
  id_estado NUMBER(11) NOT NULL,
  nome varchar(50) NOT NULL,
);

ALTER TABLE municipio ADD CONSTRAINT pk_id_municipio PRIMARY KEY (id);                                                                          

ALTER TABLE municipio ADD CONSTRAINT fk_id_estado FOREIGN KEY (id_estado) REFERENCES estado (id);                                                                                                                                             




