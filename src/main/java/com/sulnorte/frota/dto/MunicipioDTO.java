package com.sulnorte.frota.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Municipio;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    @JsonIgnore
    private Estado estado;

    public Municipio toEntity(){
        Municipio estado = new Municipio();
        estado.setId(this.id);
        estado.setNome(this.nome);
        estado.setEstado(this.estado);
        return estado;
    }

    public static MunicipioDTO toDto(Municipio municipio){
        ParameterExceptionUtil.validateObjectNull(municipio);
        MunicipioDTO municipioDTO = new MunicipioDTO();
        municipioDTO.setId(municipio.getId());
        municipioDTO.setNome(municipio.getNome());
        municipioDTO.setEstado(municipio.getEstado());
        return municipioDTO;
    }

    public static List<MunicipioDTO> convertListEntityToListDto(List<Municipio> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<MunicipioDTO> lista = new ArrayList<MunicipioDTO>();
        for(Municipio municipio : entities){
            lista.add(toDto(municipio));
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id + ", " + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MunicipioDTO)) return false;
        MunicipioDTO that = (MunicipioDTO) o;
        return id.equals(that.id);
    }

}
