package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Pais;

import java.util.List;

/**
 * Classe responsável pelo repositório de Estado.
 */
public interface IEstadoService extends ICrudService<Estado> {

    /**
     * Método que faz a busca os estados pelo pais informado.
     * @param pais codigo do pais.
     * @return List<Estado>
     */
    List<Estado> findByPais(Pais pais);

}
