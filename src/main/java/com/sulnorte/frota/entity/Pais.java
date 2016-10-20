package com.sulnorte.frota.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe que representa a tabela pais no banco de dados.
 */
@Entity
@Table(name = "pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pais)) {
            return false;
        }
        Pais pais = (Pais) o;
        return id != null ? id.equals(pais.id) : pais.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
