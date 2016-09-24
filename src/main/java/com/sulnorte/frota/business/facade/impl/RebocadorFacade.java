package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IRebocadorFacade;
import com.sulnorte.frota.business.service.*;
import com.sulnorte.frota.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebocadorFacade<T> implements IRebocadorFacade<T> {

    @Autowired
    private IRebocadorService rebocadorService;

    @Autowired
    private IPortoService portoService;

    @Autowired
    private IArmadorService armadorService;

    @Autowired
    private IPropulsaoService propulsaoService;

    @Autowired
    private ISituacaoRebocadorService situacaoRebocadorService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RebocadorDTO> findAll() {
        return RebocadorDTO.convertListEntityToListDto(this.rebocadorService.findAllByOrderByNomeAsc());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PortoDTO> findAllPorto() {
        return PortoDTO.convertListEntityToListDto(this.portoService.findAllByOrderByNomeAsc());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ArmadorDTO> findAllAmador() {
        return ArmadorDTO.convertListEntityToListDto(this.armadorService.findAllByOrderByNomeAsc());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PropulsaoDTO> findAllPropulsao() {
        return PropulsaoDTO.convertListEntityToListDto(this.propulsaoService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<SituacaoRebocadorDTO> findAllSituacao() {
        return SituacaoRebocadorDTO.convertListEntityToListDto(this.situacaoRebocadorService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RebocadorDTO findById(Long idRebocador) {
        return RebocadorDTO.toDto(this.rebocadorService.getOne(idRebocador));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T entity) {
        this.rebocadorService.save(RebocadorDTO.beforeFromSaveConvertToPorto(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        this.rebocadorService.delete(id);
    }
}
