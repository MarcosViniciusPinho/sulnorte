package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Endereco;
import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Pais;

import java.io.Serializable;
import java.util.Set;

public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Set<Estado> estadoSet;

    private Endereco endereco;

    public Pais toEntity(){
        Pais pais = new Pais();
        pais.setId(this.id);
        pais.setNome(this.nome);
        pais.setEstadoSet(this.estadoSet);
        pais.setEndereco(this.endereco);
        return pais;
    }

    public static PaisDTO toDto(Pais pais){
        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(pais.getId());
        paisDTO.setNome(pais.getNome());
        paisDTO.setEstadoSet(pais.getEstadoSet());
        paisDTO.setEndereco(pais.getEndereco());
        return paisDTO;
    }

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return id + " , " + nome;
    }
}
