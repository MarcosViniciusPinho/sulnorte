package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.service.IFilialService;
import com.sulnorte.frota.business.service.IPortoService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Rebocador;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortoFacade<T> implements IPortoFacade<T> {

    @Autowired
    private IPortoService portoService;

    @Autowired
    private IFilialService filialService;

    @Autowired
    private IRebocadorService rebocadorService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PortoDTO> findAll() {
        List<PortoDTO> lista = PortoDTO.convertListEntityToListDto(this.portoService.findAllByOrderByNomeAsc());
        if(CollectionUtils.isEmpty(lista)){
            return new ArrayList<PortoDTO>();
        }
        for(PortoDTO portoDTO : lista){
            this.verificarDisponibilidadeParaExclusao(portoDTO);
        }
        return lista;
    }

    /**
     * Método que verifica o porto que nao esta sendo usado em Armador ou Rebocador.
     * @param idPorto idPorto
     * @return boolean
     */
    private boolean isPortoNaoUsado(Long idPorto){
        Long idPortoOther = this.portoService.findByIdPortoOnArmador(idPorto);
        Rebocador rebocador = this.rebocadorService.findFirstByPortoId(idPorto);
        return idPortoOther == null && rebocador == null;
    }

    /**
     * Método que verifica o porto que esta sendo usado em Armador ou Rebocador.
     * @param idPorto idPorto
     * @return boolean
     */
    private boolean isPortoUsado(Long idPorto){
        Long idPortoOther = this.portoService.findByIdPortoOnArmador(idPorto);
        Rebocador rebocador = this.rebocadorService.findFirstByPortoId(idPorto);
        return idPorto.equals(idPortoOther)
                || (rebocador.getPorto() != null && idPorto.equals(rebocador.getPorto().getId()));
    }

    private PortoDTO verificarDisponibilidadeParaExclusao(PortoDTO portoDTO){
        ParameterExceptionUtil.validateObjectNull(portoDTO.getId());
        if(this.isPortoNaoUsado(portoDTO.getId())){
            portoDTO.setUsado(Boolean.FALSE);
        } else if(this.isPortoUsado(portoDTO.getId())){
            portoDTO.setUsado(Boolean.TRUE);
        }
        return portoDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<FilialDTO> findAllFilial() {
        return FilialDTO.convertListEntityToListDto(this.filialService.findAllByOrderByNomeAsc());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PortoDTO findById(Long idPorto) {
        return this.verificarDisponibilidadeParaExclusao(PortoDTO.toDto(this.portoService.getOne(idPorto)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T entity) {
        this.portoService.save(PortoDTO.beforeFromSaveConvertToPorto(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        ParameterExceptionUtil.validateObjectNull(id);
        this.portoService.delete(id);
    }
}
