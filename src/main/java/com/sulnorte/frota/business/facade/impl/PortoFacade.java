package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.service.IFilialService;
import com.sulnorte.frota.business.service.IPortoService;
import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<PortoDTO> findAllPorto() {
        return PortoDTO.convertListEntityToListDto(this.portoService.findAllByOrderByNomeAsc());
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
    public PortoDTO findByIdPorto(Long idPorto) {
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
