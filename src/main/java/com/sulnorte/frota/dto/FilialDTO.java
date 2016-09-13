package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Filial;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public Filial toEntity(){
        Filial filial = new Filial();
        filial.setId(this.id);
        filial.setNome(this.nome);
        return filial;
    }

    public static FilialDTO toDto(Filial filial){
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setId(filial.getId());
        filialDTO.setNome(filial.getNome());
        return filialDTO;
    }

    public static List<FilialDTO> convertListEntityToListDto(List<Filial> entities){
        List<FilialDTO> lista = new ArrayList<FilialDTO>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Filial filial : entities){
                lista.add(toDto(filial));
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
