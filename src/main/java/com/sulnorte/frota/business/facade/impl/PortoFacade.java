package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.service.IFilialService;
import com.sulnorte.frota.business.service.IPortoService;
import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;
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
            Long idPorto = this.portoService.findByIdPortoOnArmador(portoDTO.getId());
            if(idPorto == null){
                portoDTO.setUsado(Boolean.FALSE);//Porto nao esta sendo usado.
            } else if(portoDTO.getId().equals(idPorto)){
                portoDTO.setUsado(Boolean.TRUE);//Porto esta sendo usado.
            }
        }
        return lista;
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
        return PortoDTO.toDto(this.portoService.getOne(idPorto));
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
        this.portoService.delete(id);
    }
}
