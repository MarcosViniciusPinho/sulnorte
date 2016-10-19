package com.sulnorte.frota.dto;


import com.sulnorte.frota.dto.util.ReplaceUtil;
import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.entity.Endereco;
import com.sulnorte.frota.entity.Porto;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArmadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String contato;

    private Endereco endereco;

    private List<Porto> portoList = new ArrayList<>(0);

    private boolean usado;

    public Armador toEntity(){
        Armador armador = new Armador();
        armador.setId(this.getId());
        armador.setNome(this.getNome());
        armador.setContato(this.getContato());
        armador.setEndereco(this.getEndereco());
        armador.setPortoList(this.getPortoList());
        return armador;
    }

    public static ArmadorDTO toDto(Armador armador){
        ParameterExceptionUtil.validateObjectNull(armador);
        ArmadorDTO armadorDTO = new ArmadorDTO();
        armadorDTO.setId(armador.getId());
        armadorDTO.setNome(armador.getNome());
        armadorDTO.setContato(armador.getContato());
        armadorDTO.setEndereco(armador.getEndereco());
        armadorDTO.setPortoList(armador.getPortoList());
        return armadorDTO;
    }

    public static <T> Armador beforeFromSaveConvertToArmador(T entity){
        ParameterExceptionUtil.validateObjectNull(entity);
        return (Armador)entity;
    }

    public static List<ArmadorDTO> convertListEntityToListDto(List<Armador> entities){
        List<ArmadorDTO> lista = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Armador armador : entities){
                lista.add(toDto(armador));
            }
        }
        return lista;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getContato() {
        return contato;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setPortoList(List<Porto> portoList) {
        this.portoList = portoList;
    }

    public List<Porto> getPortoList() {
        return portoList;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    /**
     * Usado para exibir os portos cadastrados na tela de detalhar.
     * @return String
     */
    public String getPortosEscolhidos(){
        return ReplaceUtil.somenteTexto(this.getPortoList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArmadorDTO)) return false;
        ArmadorDTO that = (ArmadorDTO) o;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
