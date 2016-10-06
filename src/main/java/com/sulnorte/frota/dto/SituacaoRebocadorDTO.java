package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.SituacaoRebocador;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SituacaoRebocadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public SituacaoRebocador toEntity(){
        SituacaoRebocador situacaoRebocador = new SituacaoRebocador();
        situacaoRebocador.setId(this.id);
        situacaoRebocador.setNome(this.nome);
        return situacaoRebocador;
    }

    public static SituacaoRebocadorDTO toDto(SituacaoRebocador situacaoRebocador){
        ParameterExceptionUtil.validateObjectNull(situacaoRebocador);
        SituacaoRebocadorDTO situacaoRebocadorDTO = new SituacaoRebocadorDTO();
        situacaoRebocadorDTO.setId(situacaoRebocador.getId());
        situacaoRebocadorDTO.setNome(situacaoRebocador.getNome());
        return situacaoRebocadorDTO;
    }

    public static List<SituacaoRebocadorDTO> convertListEntityToListDto(List<SituacaoRebocador> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<SituacaoRebocadorDTO> lista = new ArrayList<SituacaoRebocadorDTO>();
        for(SituacaoRebocador situacaoRebocador : entities){
            lista.add(toDto(situacaoRebocador));
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

}
