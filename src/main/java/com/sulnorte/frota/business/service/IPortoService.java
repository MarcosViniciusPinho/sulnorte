package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Porto;

import java.util.List;

public interface IPortoService extends ICrudService<Porto>{

    /**
     * Método que faz a busca de todos os portos e os ordena em ordem alfabética.
     * @return List<Porto>
     */
    List<Porto> findAllByOrderByNomeAsc();
}
