package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Endereco;
import com.sulnorte.frota.entity.Porto;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PortoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Long cnpj;

    private String filial;

    private Endereco endereco;

    public Porto toEntity(){
        Porto porto = new Porto();
        porto.setId(this.id);
        porto.setNome(this.nome);
        porto.setCnpj(this.cnpj);
        porto.setFilial(this.filial);
        porto.setEndereco(this.endereco);
        return porto;
    }

    public static PortoDTO toDto(Porto porto){
        PortoDTO portoDTO = new PortoDTO();
        portoDTO.setId(porto.getId());
        portoDTO.setNome(porto.getNome());
        portoDTO.setCnpj(porto.getCnpj());
        portoDTO.setFilial(porto.getFilial());
        portoDTO.setEndereco(porto.getEndereco());
        return portoDTO;
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

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return id + " , " + nome + " , " + cnpj + " , " + filial;
    }
}
