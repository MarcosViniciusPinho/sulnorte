package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Pais;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que compõe as telas de Porto e Armador.
 */
public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    /**
     * Método que converte um dto para uma entidade.
     * @return Pais
     */
    public Pais toEntity(){
        Pais pais = new Pais();
        pais.setId(this.getId());
        pais.setNome(this.getNome());
        return pais;
    }

    /**
     * Método que converte uma entidade para um dto.
     * @param pais pais
     * @return PaisDTO
     */
    public static PaisDTO toDto(Pais pais){
        ParameterExceptionUtil.validateObjectNull(pais);
        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(pais.getId());
        paisDTO.setNome(pais.getNome());
        return paisDTO;
    }

    /**
     * Método que converte uma lista de entidade para uma lista de dto.
     * @param entities entities
     * @return List<PaisDTO>
     */
    public static List<PaisDTO> convertListEntityToListDto(List<Pais> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<PaisDTO> lista = new ArrayList<>();
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

    @Override
    public int hashCode() {
        return 0;
    }

}
