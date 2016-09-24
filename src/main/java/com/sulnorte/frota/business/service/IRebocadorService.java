package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Rebocador;

import java.util.List;

public interface IRebocadorService extends ICrudService<Rebocador>{

    /**
     * Método que faz a busca de todos os rebocadores e os ordena em ordem alfabética.
     * @return List<Rebocador>
     */
    List<Rebocador> findAllByOrderByNomeAsc();
}
