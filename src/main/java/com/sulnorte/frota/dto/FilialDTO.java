package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Filial;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que compõe a tela de Porto.
 */
public class FilialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    /**
     * Método que converte um dto para uma entidade.
     * @return Filial
     */
    public Filial toEntity(){
        Filial filial = new Filial();
        filial.setId(this.getId());
        filial.setNome(this.getNome());
        return filial;
    }

    /**
     * Método que converte uma entidade para um dto.
     * @param filial filial
     * @return FilialDTO
     */
    public static FilialDTO toDto(Filial filial){
        ParameterExceptionUtil.validateObjectNull(filial);
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setId(filial.getId());
        filialDTO.setNome(filial.getNome());
        return filialDTO;
    }

    /**
     * Método que converte uma lista de entidade para uma lista de dto.
     * @param entities entities
     * @return List<FilialDTO>
     */
    public static List<FilialDTO> convertListEntityToListDto(List<Filial> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<FilialDTO> lista = new ArrayList<>();
        for(Filial filial : entities){
            lista.add(toDto(filial));
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof FilialDTO)) {
            return false;
        }
        FilialDTO filialDTO = (FilialDTO) o;
        return id != null ? id.equals(filialDTO.id) : filialDTO.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
