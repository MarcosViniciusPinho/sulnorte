package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Rebocador;

import java.util.List;

/**
 * Classe responsável pelo repositório de Rebocador.
 */
public interface IRebocadorService extends ICrudService<Rebocador>{

    /**
     * Método que faz a busca de todos os rebocadores e os ordena em ordem alfabética.
     * @return List<Rebocador>
     */
    List<Rebocador> findAllByOrderByNomeAsc();

    /**
     * Método que busca um armador em rebocador.
     * @param idArmador idArmador
     * @return Rebocador
     */
    Rebocador findFirstByArmadorId(Long idArmador);

    /**
     * Método que busca um porto em rebocador.
     * @param idPorto idPorto
     * @return Rebocador
     */
    Rebocador findFirstByPortoId(Long idPorto);
}
