package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IRebocadorFacade;
import com.sulnorte.frota.business.service.*;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.dto.PropulsaoDTO;
import com.sulnorte.frota.dto.RebocadorDTO;
import com.sulnorte.frota.dto.SituacaoRebocadorDTO;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class RebocadorFacade<T> implements IRebocadorFacade<T> {

    @Autowired
    private IRebocadorService rebocadorService;

    @Autowired
    private IPropulsaoService propulsaoService;

    @Autowired
    private ISituacaoRebocadorService situacaoRebocadorService;

    @Autowired
    private IPortoService portoService;

    @Autowired
    private IArmadorService armadorService;


    @Override
    public List<PortoDTO> findAllPortoPerArmador(Long idArmador) {
        Long[] idsPorto = this.armadorService.findAllIdsPortoOnArmador(idArmador);
        return PortoDTO.convertListEntityToListDto(this.portoService.findByIdIn(idsPorto));
    }

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
        this.rebocadorService.save(RebocadorDTO.beforeFromSaveConvertToRebocador(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        ParameterExceptionUtil.validateObjectNull(id);
        this.rebocadorService.delete(id);
    }
}
