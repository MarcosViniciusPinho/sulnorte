package com.sulnorte.frota.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estado")
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_municipio")
    @SequenceGenerator(name = "sq_municipio", sequenceName = "sq_municipio")
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
