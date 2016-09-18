package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Municipio;

import java.util.List;

public interface IMunicipioService extends ICrudService<Municipio> {

    /**
     * Método que faz a busca de todos os municipios e os ordena em ordem alfabética.
     * @return List<Municipio>
     */
    List<Municipio> findByEstadoOrderByNomeAsc(Estado estado);

}
