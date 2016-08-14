package com.sulnorte.frota.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_pais")
    @SequenceGenerator(name = "sq_pais", sequenceName = "sq_pais")
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private Set<Estado> estadoSet;

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

    public Set<Estado> getEstadoSet() {
        return estadoSet;
    }

    public void setEstadoSet(Set<Estado> estadoSet) {
        this.estadoSet = estadoSet;
    }
}
