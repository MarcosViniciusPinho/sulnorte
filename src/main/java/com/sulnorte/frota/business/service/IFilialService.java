package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Filial;

import java.util.List;

public interface IFilialService extends ICrudService<Filial> {

    /**
     * Método que faz a busca de todas as filiais e as ordena em ordem alfabética.
     * @return List<Filial>
     */
    public List<Filial> findAllByOrderByNomeAsc();
}
