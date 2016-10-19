package com.sulnorte.frota.business.facade;

import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;

import java.util.List;

/**
 * Classe responsável pela interação do Porto, além de fornecer informações de Filial.
 * @param <T> parâmetro genérico que é passado o Porto.
 */
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

}
