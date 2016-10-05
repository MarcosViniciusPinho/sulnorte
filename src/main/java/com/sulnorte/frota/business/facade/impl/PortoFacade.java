package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.service.IFilialService;
import com.sulnorte.frota.business.service.IPortoService;
import com.sulnorte.frota.business.service.IRebocadorService;
import com.sulnorte.frota.dto.FilialDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Rebocador;
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
            Long idPorto = this.portoService.findByIdPortoOnArmador(portoDTO.getId());
            Rebocador rebocador = this.rebocadorService.findFirstByPortoId(portoDTO.getId());
            if(idPorto == null && rebocador == null){
                portoDTO.setUsado(Boolean.FALSE);//Porto nao esta sendo usado nem em Armador e nem em Rebocador.
            } else if(portoDTO.getId().equals(idPorto)
                    || (rebocador.getPorto() != null && portoDTO.getId().equals(rebocador.getPorto().getId()))){
                portoDTO.setUsado(Boolean.TRUE);//Porto esta sendo usado ou em Armador ou em Rebocador.
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
