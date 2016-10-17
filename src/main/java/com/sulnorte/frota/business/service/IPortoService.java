package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Porto;
import com.sulnorte.frota.util.QueryConstant;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPortoService extends ICrudService<Porto>{

    /**
     * Método que faz a busca de todos os portos e os ordena em ordem alfabética.
     * @return List<Porto>
     */
    List<Porto> findAllByOrderByNomeAsc();

    /**
     * Houve necessidade de criar um SQL pois o mapemaneto do hibernate inviabilizou a busca de portos associadaos a tabela associativa armador_porto.
     * Método que busca um porto pelo seu determinado id associado a um armador.
     * @param idPorto idPorto
     * @return Long
     */
    @Query(value = QueryConstant.FIND_BY_ID_PORTO_ON_ARMADOR_PORTO, nativeQuery = true)
    Long findByIdPortoOnArmador(Long idPorto);

    /**
     * Método que busca uma lista de portos com seus determinados ids informados.
     * @param idsPorto idsPorto
     * @return List<Porto>
     */
    List<Porto> findByIdIn(Long[] idsPorto);
}
