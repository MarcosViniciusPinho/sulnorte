package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Armador;

import java.util.List;

public interface IArmadorService extends ICrudService<Armador>{

    /**
     * Método que faz a busca de todos os armadores e os ordena em ordem alfabética.
     * @return List<Armador>
     */
    List<Armador> findAllByOrderByNomeAsc();
}
