package com.sulnorte.frota.business.facade;

import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Porto;

import java.util.List;

public interface IPortoFacade<T> extends ICrudFacade<T> {

    /**
     * Método que busca todos os portos na base.
     * @return List<PortoDTO>
     */
    List<PortoDTO> findAll();

    /**
     * Método que busca todas as filiais na base.
     * @return List<FilialDTO>
     */
    List<FilialDTO> findAllFilial();

    /**
     * Método que busca um porto pelo seu respectivo id.
     * @param idPorto idPorto
     * @return PortoDTO
     */
    PortoDTO findById(Long idPorto);

    /**
     * Método que busca todos os portos de acordo com a lista de ids informada.
     * @param idsPorto idsPorto
     * @return List<Porto>
     */
    List<Porto> findAllById(Long[] idsPorto);

}
