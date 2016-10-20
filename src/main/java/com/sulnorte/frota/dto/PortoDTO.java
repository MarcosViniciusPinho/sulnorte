package com.sulnorte.frota.dto;


import com.sulnorte.frota.dto.util.PatternUtil;
import com.sulnorte.frota.dto.util.ReplaceUtil;
import com.sulnorte.frota.entity.Endereco;
import com.sulnorte.frota.entity.Filial;
import com.sulnorte.frota.entity.Porto;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a tela em Porto.
 */
public class PortoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String cnpj;

    private Filial filial;

    private Endereco endereco;

    private boolean usado;

    /**
     * Método que converte um dto para uma entidade.
     * @return Porto
     */
    public Porto toEntity(){
        Porto porto = new Porto();
        porto.setId(this.getId());
        porto.setNome(this.getNome());
        porto.setCnpj(ReplaceUtil.retirarMascaraPadraoCnpj(this.getCnpj()));
        porto.setFilial(this.getFilial());
        porto.setEndereco(this.getEndereco());
        return porto;
    }

    /**
     * Método que converte uma entidade para um dto.
     * @param porto porto
     * @return PortoDTO
     */
    public static PortoDTO toDto(Porto porto){
        ParameterExceptionUtil.validateObjectNull(porto);
        PortoDTO portoDTO = new PortoDTO();
        portoDTO.setId(porto.getId());
        portoDTO.setNome(porto.getNome());
        portoDTO.setCnpj(PatternUtil.mascaraPadraoCnpj(porto.getCnpj()));
        portoDTO.setFilial(porto.getFilial());
        portoDTO.setEndereco(porto.getEndereco());
        return portoDTO;
    }

    /**
     * Método que faz o cast de uma classe genérica para a classe Porto
     * @param entity entity
     * @param <T> classe generica
     * @return Porto
     */
    public static <T> Porto beforeFromSaveConvertToPorto(T entity){
        ParameterExceptionUtil.validateObjectNull(entity);
        return (Porto)entity;
    }

    /**
     * Método que converte uma lista de entidade para uma lista de dto.
     * @param entities entities
     * @return List<PortoDTO>
     */
    public static List<PortoDTO> convertListEntityToListDto(List<Porto> entities){
        List<PortoDTO> lista = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Porto porto : entities){
                lista.add(toDto(porto));
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PortoDTO)) {
            return false;
        }
        PortoDTO portoDTO = (PortoDTO) o;
        return id != null ? id.equals(portoDTO.id) : portoDTO.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
