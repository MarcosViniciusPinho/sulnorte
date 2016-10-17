package com.sulnorte.frota.business.facade;

import com.sulnorte.frota.dto.ArmadorDTO;

import java.util.List;

public interface IArmadorFacade<T> extends ICrudFacade<T> {

    /**
     * Método que busca todos os armadores na base.
     * @return List<ArmadorDTO>
     */
    List<ArmadorDTO> findAll();

    /**
     * Método que busca um armador pelo seu respectivo id.
     * @param idArmador idArmador
     * @return ArmadorDTO
     */
    ArmadorDTO findById(Long idArmador);

}
