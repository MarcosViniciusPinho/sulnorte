package com.sulnorte.frota.business.service;

import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.util.QueryConstant;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IArmadorService extends ICrudService<Armador>{

    /**
     * Método que faz a busca de todos os armadores e os ordena em ordem alfabética.
     * @return List<Armador>
     */
    List<Armador> findAllByOrderByNomeAsc();

    /**
     * Houve necessidade de criar um SQL pois o mapemaneto do hibernate inviabilizou a busca de portos associadaos a tabela associativa armador_porto.
     * Método que busca um armador pelo seu determinado id associado a um porto.
     * @param idArmador idArmador
     * @return Long[]
     */
    @Query(value = QueryConstant.FIND_ALL_IDS_PORTO_ON_ARMADOR_PORTO, nativeQuery = true)
    Long[] findAllIdsPortoOnArmador(Long idArmador);

}
