package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.service.IArmadorService;
import com.sulnorte.frota.dto.ArmadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmadorFacade<T> implements IArmadorFacade<T> {

    @Autowired
    private IArmadorService armadorService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ArmadorDTO> findAll() {
        return ArmadorDTO.convertListEntityToListDto(this.armadorService.findAllByOrderByNomeAsc());
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
