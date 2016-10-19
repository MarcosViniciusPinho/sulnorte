package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Propulsao;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que compõe a tela de Rebocador.
 */
public class PropulsaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    /**
     * Método que converte um dto para uma entidade.
     * @return Propulsao
     */
    public Propulsao toEntity(){
        Propulsao propulsao = new Propulsao();
        propulsao.setId(this.getId());
        propulsao.setNome(this.getNome());
        return propulsao;
    }

    /**
     * Método que converte uma entidade para um dto.
     * @param propulsao propulsao
     * @return PropulsaoDTO
     */
    public static PropulsaoDTO toDto(Propulsao propulsao){
        ParameterExceptionUtil.validateObjectNull(propulsao);
        PropulsaoDTO propulsaoDTO = new PropulsaoDTO();
        propulsaoDTO.setId(propulsao.getId());
        propulsaoDTO.setNome(propulsao.getNome());
        return propulsaoDTO;
    }

    /**
     * Método que converte uma lista de entidade para uma lista de dto.
     * @param entities entities
     * @return List<PropulsaoDTO>
     */
    public static List<PropulsaoDTO> convertListEntityToListDto(List<Propulsao> entities){
        ParameterExceptionUtil.validateCollectionNull(entities);
        List<PropulsaoDTO> lista = new ArrayList<>();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropulsaoDTO)) return false;
        PropulsaoDTO that = (PropulsaoDTO) o;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
