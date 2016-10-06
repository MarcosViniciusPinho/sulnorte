package com.sulnorte.frota.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Pais;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String sigla;

    @JsonIgnore
    private Pais pais;

    public Estado toEntity(){
        Estado estado = new Estado();
        estado.setId(this.id);
        estado.setNome(this.nome);
        estado.setSigla(this.sigla);
        estado.setPais(this.pais);
        return estado;
    }

    public static EstadoDTO toDto(Estado estado){
        ParameterExceptionUtil.validateObjectNull(estado);
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setId(estado.getId());
        estadoDTO.setNome(estado.getNome());
        estadoDTO.setSigla(estado.getSigla());
        estadoDTO.setPais(estado.getPais());
        return estadoDTO;
    }

    public static List<EstadoDTO> convertListEntityToListDto(List<Estado> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<EstadoDTO> lista = new ArrayList<EstadoDTO>();
        for(Estado estado : entities){
            lista.add(toDto(estado));
        }
        return lista;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return id + " , " + nome + " , " + sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstadoDTO)) return false;
        EstadoDTO estadoDTO = (EstadoDTO) o;
        return id.equals(estadoDTO.id);
    }

}
