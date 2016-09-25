package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Propulsao;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PropulsaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public Propulsao toEntity(){
        Propulsao propulsao = new Propulsao();
        propulsao.setId(this.id);
        propulsao.setNome(this.nome);
        return propulsao;
    }

    public static PropulsaoDTO toDto(Propulsao propulsao){
        ParameterExceptionUtil.validateObjectNull(propulsao);
        PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
        propulsaoDTO.setId(propulsao.getId());
        propulsaoDTO.setNome(propulsao.getNome());
        return propulsaoDTO;
    }

    public static List<PropulsaoDTO> convertListEntityToListDto(List<Propulsao> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<PropulsaoDTO> lista = new ArrayList<PropulsaoDTO>();
        for(Propulsao propulsao : entities){
            lista.add(toDto(propulsao));
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

    @Override
    public String toString() {
        return id + " , " + nome;
    }
}