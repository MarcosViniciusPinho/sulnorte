package com.sulnorte.frota.business.facade;

import com.sulnorte.frota.dto.PropulsaoDTO;
import com.sulnorte.frota.dto.RebocadorDTO;
import com.sulnorte.frota.dto.SituacaoRebocadorDTO;

import java.util.List;

public interface IRebocadorFacade<T> extends ICrudFacade<T> {

    /**
     * Método que busca todos os rebocadores na base.
     * @return List<PortoDTO>
     */
    List<RebocadorDTO> findAll();

    /**
     * Método que busca todos as propulsões na base.
     * @return List<PropulsaoDTO>
     */
    List<PropulsaoDTO> findAllPropulsao();

    /**
     * Método que busca todos as situações de rebocador na base.
     * @return List<SituacaoRebocadorDTO>
     */
    List<SituacaoRebocadorDTO> findAllSituacao();

    /**
     * Método que busca um rebocador pelo seu respectivo id.
     * @param idRebocador idRebocador
     * @return RebocadorDTO
     */
    RebocadorDTO findById(Long idRebocador);

}