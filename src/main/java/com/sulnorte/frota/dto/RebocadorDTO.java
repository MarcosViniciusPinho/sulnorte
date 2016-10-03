package com.sulnorte.frota.dto;


import com.sulnorte.frota.dto.util.PatternUtil;
import com.sulnorte.frota.dto.util.ReplaceUtil;
import com.sulnorte.frota.entity.*;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RebocadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private Integer ano;

    private String bp;

    private String bhp;

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
        rebocador.setBp(ReplaceUtil.retirarMascaraPadraoDecimalBr(this.bp));
        rebocador.setBhp(ReplaceUtil.retirarMascaraPadraoDecimalBr(this.bhp));
        rebocador.setObservacao(this.observacao);
        rebocador.setPropulsao(this.propulsao);
        rebocador.setSituacaoRebocador(this.situacaoRebocador);
        rebocador.setArmador(this.armador);
        rebocador.setPorto(this.porto);
        return rebocador;
    }

    public static RebocadorDTO toDto(Rebocador rebocador){
        ParameterExceptionUtil.validateObjectNull(rebocador);
        RebocadorDTO rebocadorDTO = new RebocadorDTO();
        rebocadorDTO.setId(rebocador.getId());
        rebocadorDTO.setNome(rebocador.getNome());
        rebocadorDTO.setAno(rebocador.getAno());
        rebocadorDTO.setBp(PatternUtil.mascaraPadraoDecimalBr(rebocador.getBp()));
        rebocadorDTO.setBhp(PatternUtil.mascaraPadraoDecimalBr(rebocador.getBhp()));
        rebocadorDTO.setObservacao(rebocador.getObservacao());
        rebocadorDTO.setPropulsao(rebocador.getPropulsao());
        rebocadorDTO.setSituacaoRebocador(rebocador.getSituacaoRebocador());
        rebocadorDTO.setArmador(rebocador.getArmador());
        rebocadorDTO.setPorto(rebocador.getPorto());
        return rebocadorDTO;
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

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getBhp() {
        return bhp;
    }

    public void setBhp(String bhp) {
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
