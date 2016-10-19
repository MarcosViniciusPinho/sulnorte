package com.sulnorte.frota.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe que representa a tabela situacao_rebocador no banco de dados.
 */
@Entity
@Table(name = "situacao_rebocador")
public class SituacaoRebocador implements Serializable {

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
        if (this == o) return true;
        if (!(o instanceof SituacaoRebocador)) return false;
        SituacaoRebocador that = (SituacaoRebocador) o;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
