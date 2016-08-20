package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Endereco;
import com.sulnorte.frota.entity.Porto;

import java.io.Serializable;

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

    public PortoDTO toDto(Porto porto){
        PortoDTO portoDTO = new PortoDTO();
        portoDTO.setId(porto.getId());
        portoDTO.setNome(porto.getNome());
        portoDTO.setCnpj(porto.getCnpj());
        portoDTO.setFilial(porto.getFilial());
        portoDTO.setEndereco(porto.getEndereco());
        return portoDTO;
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
