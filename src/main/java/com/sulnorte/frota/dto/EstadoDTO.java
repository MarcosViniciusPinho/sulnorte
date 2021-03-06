package com.sulnorte.frota.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Pais;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que compõe as telas de Porto e Armador.
 */
public class EstadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String sigla;

    @JsonIgnore
    private Pais pais;

    /**
     * Método que converte um dto para uma entidade.
     * @return Estado
     */
    public Estado toEntity(){
        Estado estado = new Estado();
        estado.setId(this.getId());
        estado.setNome(this.getNome());
        estado.setSigla(this.getSigla());
        estado.setPais(this.getPais());
        return estado;
    }

    /**
     * Método que converte uma entidade para um dto.
     * @param estado estado
     * @return ArmadorDTO
     */
    public static EstadoDTO toDto(Estado estado){
        ParameterExceptionUtil.validateObjectNull(estado);
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setId(estado.getId());
        estadoDTO.setNome(estado.getNome());
        estadoDTO.setSigla(estado.getSigla());
        estadoDTO.setPais(estado.getPais());
        return estadoDTO;
    }

    /**
     * Método que converte uma lista de entidade para uma lista de dto.
     * @param entities entities
     * @return List<EstadoDTO>
     */
    public static List<EstadoDTO> convertListEntityToListDto(List<Estado> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<EstadoDTO> lista = new ArrayList<>();
        for(Estado estado : entities){
            lista.add(toDto(estado));
        }
        return lista;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EstadoDTO)) {
            return false;
        }
        EstadoDTO estadoDTO = (EstadoDTO) o;
        return id != null ? id.equals(estadoDTO.id) : estadoDTO.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
