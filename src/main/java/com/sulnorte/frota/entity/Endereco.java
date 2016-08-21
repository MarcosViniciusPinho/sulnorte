package com.sulnorte.frota.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_endereco")
    @SequenceGenerator(name = "sq_endereco", sequenceName = "sq_endereco")
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @Column(name = "logradouro", length = 150, nullable = false)
    private String logradouro;

    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;

    @Column(name = "numero", length = 10)
    private String numero;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

    @OneToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Porto porto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Porto getPorto() {
        return porto;
    }

    public void setPorto(Porto porto) {
        this.porto = porto;
    }

    @Override
    public String toString() {
        return id + ", " + logradouro + ", " + bairro + ", " + numero;
    }
}
