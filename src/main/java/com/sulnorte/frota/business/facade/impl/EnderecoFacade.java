package com.sulnorte.frota.business.facade.impl;

import com.sulnorte.frota.business.facade.IEnderecoFacade;
import com.sulnorte.frota.business.service.IEstadoService;
import com.sulnorte.frota.business.service.IMunicipioService;
import com.sulnorte.frota.business.service.IPaisService;
import com.sulnorte.frota.dto.EstadoDTO;
import com.sulnorte.frota.dto.MunicipioDTO;
import com.sulnorte.frota.dto.PaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoFacade implements IEnderecoFacade {

    @Autowired
    public IPaisService paisService;

    @Autowired
    public IEstadoService estadoService;

    @Autowired
    public IMunicipioService municipioService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EstadoDTO> findByEstadoPerPais(Long idPais) {
        PaisDTO pais = PaisDTO.toDto(this.paisService.getOne(idPais));
        return EstadoDTO.convertListEntityToListDto(this.estadoService.findByPais(pais.toEntity()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MunicipioDTO> findByMunicipioPerEstado(Long idEstado) {
        EstadoDTO estado = EstadoDTO.toDto(this.estadoService.getOne(idEstado));
        return MunicipioDTO.convertListEntityToListDto(this.municipioService.findByEstadoOrderByNomeAsc(estado.toEntity()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PaisDTO> findAllPais() {
        return PaisDTO.convertListEntityToListDto(this.paisService.findAll());
    }


}
