package com.sulnorte.frota.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "armador")
public class Armador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @NotBlank(message = "O Campo Nome é Obrigatório")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "contato", length = 50)
    private String contato;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name = "armador_porto", joinColumns = {
            @JoinColumn(name = "id_armador", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_porto", nullable = false)
    })
    @JsonIgnore
    private List<Porto> portoList = new ArrayList<Porto>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Porto> getPortoList() {
        return portoList;
    }

    public void setPortoList(List<Porto> portoList) {
        this.portoList = portoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armador)) return false;
        Armador armador = (Armador) o;
        return id != null ? id.equals(armador.id) : armador.id == null;
    }

}
