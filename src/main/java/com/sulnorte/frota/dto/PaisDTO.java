package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Pais;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public Pais toEntity(){
        Pais pais = new Pais();
        pais.setId(this.id);
        pais.setNome(this.nome);
        return pais;
    }

    public static PaisDTO toDto(Pais pais){
        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(pais.getId());
        paisDTO.setNome(pais.getNome());
        return paisDTO;
    }

    public static List<PaisDTO> convertListEntityToListDto(List<Pais> entities){
        List<PaisDTO> lista = new ArrayList<PaisDTO>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Pais pais : entities){
                lista.add(toDto(pais));
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

    @Override
    public String toString() {
        return id + " , " + nome;
    }
}
