package com.sulnorte.frota.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe que representa a tabela rebocador no banco de dados.
 */
@Entity
@Table(name = "rebocador")
public class Rebocador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Long id;

    @NotBlank(message = "O Campo Nome é Obrigatório")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "ano", length = 4)
    private Integer ano;

    @Column(name = "bp", length = 10, precision = 10, scale = 2)
    private BigDecimal bp;

    @Column(name = "bhp", length = 10, precision = 10, scale = 2)
    private BigDecimal bhp;

    @Column(name = "observacao", length = 250)
    private String observacao;

    @NotNull(message = "O Campo Situação é Obrigatório")
    @OneToOne
    @JoinColumn(name = "id_situacao_rebocador", nullable = false)
    private SituacaoRebocador situacaoRebocador;

    @OneToOne
    @JoinColumn(name = "id_propulsao")
    private Propulsao propulsao;

    @NotNull(message = "O Campo Armador é Obrigatório")
    @OneToOne
    @JoinColumn(name = "id_armador", nullable = false)
    private Armador armador;

    @NotNull(message = "O Campo Porto é Obrigatório")
    @OneToOne
    @JoinColumn(name = "id_porto", nullable = false)
    private Porto porto;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rebocador)) return false;
        Rebocador rebocador = (Rebocador) o;
        return id != null ? id.equals(rebocador.id) : rebocador.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
