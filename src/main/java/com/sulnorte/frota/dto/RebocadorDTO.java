package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.*;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RebocadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Integer ano;

    private BigDecimal bp;

    private BigDecimal bhp;

    private String observacao;

    private SituacaoRebocador situacaoRebocador;

    private Propulsao propulsao;

    private Armador armador;

    private Porto porto;


    public Rebocador toEntity(){
        Rebocador rebocador = new Rebocador();
        rebocador.setId(this.id);
        rebocador.setNome(this.nome);
        rebocador.setAno(this.ano);
        rebocador.setBp(this.bp);
        rebocador.setBhp(this.bhp);
        rebocador.setObservacao(this.observacao);
        rebocador.setPropulsao(this.propulsao);
        rebocador.setArmador(this.armador);
        rebocador.setPorto(this.porto);
        return rebocador;
    }

    public static RebocadorDTO toDto(Rebocador rebocador){
        ParameterExceptionUtil.validateObjectNull(rebocador);
        RebocadorDTO armadorDTO = new RebocadorDTO();
        armadorDTO.setId(rebocador.getId());
        armadorDTO.setNome(rebocador.getNome());
        rebocador.setBp(rebocador.getBp());
        rebocador.setBhp(rebocador.getBhp());
        rebocador.setObservacao(rebocador.getObservacao());
        rebocador.setPropulsao(rebocador.getPropulsao());
        rebocador.setArmador(rebocador.getArmador());
        rebocador.setPorto(rebocador.getPorto());
        return armadorDTO;
    }

    public static <T> Rebocador beforeFromSaveConvertToPorto(T entity){
        ParameterExceptionUtil.validateObjectNull(entity);
        return (Rebocador)entity;
    }

    public static List<RebocadorDTO> convertListEntityToListDto(List<Rebocador> entities){
        List<RebocadorDTO> lista = new ArrayList<RebocadorDTO>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Rebocador rebocador : entities){
                lista.add(toDto(rebocador));
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public BigDecimal getBp() {
        return bp;
    }

    public void setBp(BigDecimal bp) {
        this.bp = bp;
    }

    public BigDecimal getBhp() {
        return bhp;
    }

    public void setBhp(BigDecimal bhp) {
        this.bhp = bhp;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public SituacaoRebocador getSituacaoRebocador() {
        return situacaoRebocador;
    }

    public void setSituacaoRebocador(SituacaoRebocador situacaoRebocador) {
        this.situacaoRebocador = situacaoRebocador;
    }

    public Propulsao getPropulsao() {
        return propulsao;
    }

    public void setPropulsao(Propulsao propulsao) {
        this.propulsao = propulsao;
    }

    public Armador getArmador() {
        return armador;
    }

    public void setArmador(Armador armador) {
        this.armador = armador;
    }

    public Porto getPorto() {
        return porto;
    }

    public void setPorto(Porto porto) {
        this.porto = porto;
    }

    @Override
    public String toString() {
        return id + " , " + nome + " , " + ano + " , " + bp + " , " + bhp + " , " + observacao;
    }
}
