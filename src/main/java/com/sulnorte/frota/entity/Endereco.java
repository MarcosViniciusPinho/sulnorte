package com.sulnorte.frota.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @NotBlank(message = "O Campo Logradouro é Obrigatório")
    @Column(name = "logradouro", length = 50, nullable = false)
    private String logradouro;

    @NotBlank(message = "O Campo Bairro é Obrigatório")
    @Column(name = "bairro", length = 100, nullable = false)
    private String bairro;

    @NotBlank(message = "O Campo Complemento é Obrigatório")
    @Column(name = "complemento", length = 80, nullable = false)
    private String complemento;

    @NotNull(message = "O Campo País é Obrigatório")
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

    @NotNull(message = "O Campo Estado é Obrigatório")
    @OneToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @NotNull(message = "O Campo Município é Obrigatório")
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

}