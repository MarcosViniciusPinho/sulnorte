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

public class PortoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String cnpj;

    private Filial filial;

    private Endereco endereco;

    private boolean usado;

    public Porto toEntity(){
        Porto porto = new Porto();
        porto.setId(this.id);
        porto.setNome(this.nome);
        porto.setCnpj(ReplaceUtil.retirarMascaraPadraoCnpj(this.cnpj));
        porto.setFilial(this.filial);
        porto.setEndereco(this.endereco);
        return porto;
    }

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

    public static <T> Porto beforeFromSaveConvertToPorto(T entity){
        ParameterExceptionUtil.validateObjectNull(entity);
        return (Porto)entity;
    }

    public static List<PortoDTO> convertListEntityToListDto(List<Porto> entities){
        List<PortoDTO> lista = new ArrayList<PortoDTO>();
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
        return id + " , " + nome + " , " + cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PortoDTO)) return false;
        PortoDTO portoDTO = (PortoDTO) o;
        return id.equals(portoDTO.id);
    }

}
