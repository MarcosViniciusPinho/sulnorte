package com.sulnorte.frota.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe que representa a tabela porto no banco de dados.
 */
@Entity
@Table(name = "porto")
public class Porto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @NotBlank(message = "O Campo Nome é Obrigatório")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "cnpj", length = 15)
    private Long cnpj;

    @OneToOne
    @JoinColumn(name = "id_filial")
    private Filial filial;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Porto)) {
            return false;
        }
        Porto porto = (Porto) o;
        return id != null ? id.equals(porto.id) : porto.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
