package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Pais;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public Pais toEntity(){
        Pais pais = new Pais();
        pais.setId(this.getId());
        pais.setNome(this.getNome());
        return pais;
    }

    public static PaisDTO toDto(Pais pais){
        ParameterExceptionUtil.validateObjectNull(pais);
        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(pais.getId());
        paisDTO.setNome(pais.getNome());
        return paisDTO;
    }

    public static List<PaisDTO> convertListEntityToListDto(List<Pais> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<PaisDTO> lista = new ArrayList<PaisDTO>();
        for(Pais pais : entities){
            lista.add(toDto(pais));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaisDTO)) return false;
        PaisDTO paisDTO = (PaisDTO) o;
        return id != null ? id.equals(paisDTO.id) : paisDTO.id == null;
    }

}
