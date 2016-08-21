package com.sulnorte.frota.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sulnorte.frota.entity.Endereco;
import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Municipio;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    @JsonIgnore
    private Estado estado;

    private Endereco endereco;

    public Municipio toEntity(){
        Municipio estado = new Municipio();
        estado.setId(this.id);
        estado.setNome(this.nome);
        estado.setEstado(this.estado);
        estado.setEndereco(this.endereco);
        return estado;
    }

    public static MunicipioDTO toDto(Municipio municipio){
        MunicipioDTO municipioDTO = new MunicipioDTO();
        municipioDTO.setId(municipio.getId());
        municipioDTO.setNome(municipio.getNome());
        municipioDTO.setEstado(municipio.getEstado());
        municipioDTO.setEndereco(municipio.getEndereco());
        return municipioDTO;
    }

    public static List<MunicipioDTO> convertListEntityToListDto(List<Municipio> entities){
        List<MunicipioDTO> lista = new ArrayList<MunicipioDTO>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Municipio municipio : entities){
                lista.add(toDto(municipio));
            }
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return id + ", " + nome;
    }
}
