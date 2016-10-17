package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.service.IArmadorService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.dto.ArmadorDTO;
import com.sulnorte.frota.entity.Rebocador;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
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
    public Long[] findAllIdsPortoOnArmador(Long idArmador) {
        return this.armadorService.findAllIdsPortoOnArmador(idArmador);
    }

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
            this.verificarDisponibilidadeParaExclusao(armadorDTO);
        }
        return lista;
    }

    /**
     * Método que verifica o armador que nao esta sendo usado em Rebocador.
     * @param idArmador idArmador
     * @return boolean
     */
    private boolean isArmadorNaoUsado(Long idArmador){
        Rebocador rebocador = this.rebocadorService.findFirstByArmadorId(idArmador);
        return rebocador == null;
    }

    /**
     * Método que verifica o armador que esta sendo usado em Rebocador.
     * @param idArmador idArmador
     * @return boolean
     */
    private boolean isArmadorUsado(Long idArmador){
        Rebocador rebocador = this.rebocadorService.findFirstByArmadorId(idArmador);
        return rebocador.getArmador() != null && idArmador.equals(rebocador.getArmador().getId());
    }

    private ArmadorDTO verificarDisponibilidadeParaExclusao(ArmadorDTO armadorDTO){
        ParameterExceptionUtil.validateObjectNull(armadorDTO.getId());
        if(this.isArmadorNaoUsado(armadorDTO.getId())){
            armadorDTO.setUsado(Boolean.FALSE);
        } else if(this.isArmadorUsado(armadorDTO.getId())){
            armadorDTO.setUsado(Boolean.TRUE);
        }
        return armadorDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArmadorDTO findById(Long idArmador) {
        return this.verificarDisponibilidadeParaExclusao(ArmadorDTO.toDto(this.armadorService.getOne(idArmador)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T entity) {
        this.armadorService.save(ArmadorDTO.beforeFromSaveConvertToArmador(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        ParameterExceptionUtil.validateObjectNull(id);
        this.armadorService.delete(id);
    }
}
