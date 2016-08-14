package com.sulnorte.frota.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "porto")
public class Porto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_porto")
    @SequenceGenerator(name = "sq_porto", sequenceName = "sq_porto")
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "cnpj", length = 15)
    private Long cnpj;

    @Column(name = "filial", length = 50, nullable = false)
    private String filial;

    @OneToOne
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

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
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
        return id + " , " + nome + " , " + cnpj + " , " + filial;
    }
}
