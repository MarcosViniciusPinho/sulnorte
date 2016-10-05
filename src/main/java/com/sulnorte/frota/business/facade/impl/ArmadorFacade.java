package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.service.IArmadorService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.dto.ArmadorDTO;
import com.sulnorte.frota.entity.Rebocador;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmadorFacade<T> implements IArmadorFacade<T> {

    @Autowired
    private IArmadorService armadorService;

    @Autowired
    private IRebocadorService rebocadorService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ArmadorDTO> findAll() {
        List<ArmadorDTO> lista = ArmadorDTO.convertListEntityToListDto(this.armadorService.findAllByOrderByNomeAsc());
        if(CollectionUtils.isEmpty(lista)){
            return new ArrayList<ArmadorDTO>();
        }
        for(ArmadorDTO armadorDTO : lista){
            Rebocador rebocador = this.rebocadorService.findFirstByArmadorId(armadorDTO.getId());
            if(rebocador == null){
                armadorDTO.setUsado(Boolean.FALSE);//Armador nao esta sendo usado em Rebocador.
            } else if(rebocador.getArmador() != null && armadorDTO.getId().equals(rebocador.getArmador().getId())){
                armadorDTO.setUsado(Boolean.TRUE);//Armador esta sendo usado em Rebocador.
            }
        }
        return lista;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArmadorDTO findById(Long idPorto) {
        return ArmadorDTO.toDto(this.armadorService.getOne(idPorto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T entity) {
        this.armadorService.save(ArmadorDTO.beforeFromSaveConvertToPorto(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        this.armadorService.delete(id);
    }
}
