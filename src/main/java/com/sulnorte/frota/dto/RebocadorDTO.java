package com.sulnorte.frota.dto;


import com.sulnorte.frota.dto.util.PatternUtil;
import com.sulnorte.frota.dto.util.ReplaceUtil;
import com.sulnorte.frota.entity.*;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.collections.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a tela em Rebocador.
 */
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

    /**
     * Método que converte um dto para uma entidade.
     * @return Rebocador
     */
    public Rebocador toEntity(){
        Rebocador rebocador = new Rebocador();
        rebocador.setId(this.getId());
        rebocador.setNome(this.getNome());
        rebocador.setAno(this.getAno());
        rebocador.setBp(ReplaceUtil.retirarMascaraPadraoDecimalBr(this.getBp()));
        rebocador.setBhp(ReplaceUtil.retirarMascaraPadraoDecimalBr(this.getBhp()));
        rebocador.setObservacao(this.getObservacao());
        rebocador.setPropulsao(this.getPropulsao());
        rebocador.setSituacaoRebocador(this.getSituacaoRebocador());
        rebocador.setArmador(this.getArmador());
        rebocador.setPorto(this.getPorto());
        return rebocador;
    }

    /**
     * Método que converte uma entidade para um dto.
     * @param rebocador rebocador
     * @return RebocadorDTO
     */
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

    /**
     * Método que faz o cast de uma classe genérica para a classe Rebocador
     * @param entity entity
     * @param <T> classe generica
     * @return Rebocador
     */
    public static <T> Rebocador beforeFromSaveConvertToRebocador(T entity){
        ParameterExceptionUtil.validateObjectNull(entity);
        return (Rebocador)entity;
    }

    /**
     * Método que converte uma lista de entidade para uma lista de dto.
     * @param entities entities
     * @return List<RebocadorDTO>
     */
    public static List<RebocadorDTO> convertListEntityToListDto(List<Rebocador> entities){
        List<RebocadorDTO> lista = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(entities)){
            for(Rebocador rebocador : entities){
                lista.add(toDto(rebocador));
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

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getAno() {
        return ano;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getBp() {
        return bp;
    }

    public void setBhp(String bhp) {
        this.bhp = bhp;
    }

    public String getBhp() {
        return bhp;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setSituacaoRebocador(SituacaoRebocador situacaoRebocador) {
        this.situacaoRebocador = situacaoRebocador;
    }

    public SituacaoRebocador getSituacaoRebocador() {
        return situacaoRebocador;
    }

    public void setPropulsao(Propulsao propulsao) {
        this.propulsao = propulsao;
    }

    public Propulsao getPropulsao() {
        return propulsao;
    }

    public void setArmador(Armador armador) {
        this.armador = armador;
    }

    public Armador getArmador() {
        return armador;
    }

    public void setPorto(Porto porto) {
        this.porto = porto;
    }

    public Porto getPorto() {
        return porto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RebocadorDTO)) {
            return false;
        }
        RebocadorDTO that = (RebocadorDTO) o;
        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
