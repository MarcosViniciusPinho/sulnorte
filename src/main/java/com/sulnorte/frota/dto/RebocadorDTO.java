package com.sulnorte.frota.dto;


import com.sulnorte.frota.entity.Rebocador;
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

    private SituacaoRebocadorDTO situacaoRebocador;

    private PropulsaoDTO propulsao;

    private ArmadorDTO armador;

    private PortoDTO porto;


    public Rebocador toEntity(){
        Rebocador rebocador = new Rebocador();
        rebocador.setId(this.id);
        rebocador.setNome(this.nome);
        rebocador.setAno(this.ano);
        rebocador.setBp(this.bp);
        rebocador.setBhp(this.bhp);
        rebocador.setObservacao(this.observacao);
        rebocador.setPropulsao(this.propulsao.toEntity());
        rebocador.setSituacaoRebocador(this.situacaoRebocador.toEntity());
        rebocador.setArmador(this.armador.toEntity());
        rebocador.setPorto(this.porto.toEntity());
        return rebocador;
    }

    public static RebocadorDTO toDto(Rebocador rebocador){
        ParameterExceptionUtil.validateObjectNull(rebocador);
        RebocadorDTO rebocadorDTO = new RebocadorDTO();
        rebocadorDTO.setId(rebocador.getId());
        rebocadorDTO.setNome(rebocador.getNome());
        rebocadorDTO.setBp(rebocador.getBp());
        rebocadorDTO.setBhp(rebocador.getBhp());
        rebocadorDTO.setObservacao(rebocador.getObservacao());
        rebocadorDTO.setPropulsao(PropulsaoDTO.toDto(rebocador.getPropulsao()));
        rebocadorDTO.setSituacaoRebocador(SituacaoRebocadorDTO.toDto(rebocador.getSituacaoRebocador()));
        rebocadorDTO.setArmador(ArmadorDTO.toDto(rebocador.getArmador()));
        rebocadorDTO.setPorto(PortoDTO.toDto(rebocador.getPorto()));
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

    public SituacaoRebocadorDTO getSituacaoRebocador() {
        return situacaoRebocador;
    }

    public void setSituacaoRebocador(SituacaoRebocadorDTO situacaoRebocador) {
        this.situacaoRebocador = situacaoRebocador;
    }

    public PropulsaoDTO getPropulsao() {
        return propulsao;
    }

    public void setPropulsao(PropulsaoDTO propulsao) {
        this.propulsao = propulsao;
    }

    public ArmadorDTO getArmador() {
        return armador;
    }

    public void setArmador(ArmadorDTO armador) {
        this.armador = armador;
    }

    public PortoDTO getPorto() {
        return porto;
    }

    public void setPorto(PortoDTO porto) {
        this.porto = porto;
    }

    @Override
    public String toString() {
        return id + " , " + nome + " , " + ano + " , " + bp + " , " + bhp + " , " + observacao;
    }
}
