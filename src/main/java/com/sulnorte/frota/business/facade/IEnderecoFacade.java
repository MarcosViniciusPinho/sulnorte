package com.sulnorte.frota.business.facade;

import com.sulnorte.frota.dto.EstadoDTO;
import com.sulnorte.frota.dto.MunicipioDTO;
import com.sulnorte.frota.dto.PaisDTO;

import java.util.List;

/**
 * Classe responsável por disponibilizar informações de Pais, Estado e Municipio.
 */
public interface IEnderecoFacade {

    /**
     * Método que faz a busca de todos os estados que são de um determinado pais.
     * @param idPais codigo do pais
     * @return List<EstadoDTO>
     */
    List<EstadoDTO> findByEstadoPerPais(Long idPais);

    /**
     * Método que faz a busca de todos os municipios que são de um determinado estado.
     * @param idEstado codigo do estado
     * @return List<MunicipioDTO>
     */
    List<MunicipioDTO> findByMunicipioPerEstado(Long idEstado);

    /**
     * Método que faz a busca de todos os paises encontrados na base.
     * @return List<PaisDTO>
     */
    List<PaisDTO> findAllPais();

}
