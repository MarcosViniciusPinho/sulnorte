package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IEnderecoFacade;
import com.sulnorte.frota.dto.EstadoDTO;
import com.sulnorte.frota.dto.MunicipioDTO;
import com.sulnorte.frota.exception.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Classe responsável pelo gerenciamento entre a view e camada business.
 * Esta classe somente é usada em dois momentos, uma é em Porto e a outra é em Armador.
 * @param <V> dto
 * @param <T> entidade
 */
public abstract class EnderecoController<V, T> extends CrudController<V, T>{

    @Autowired
    protected IEnderecoFacade enderecoFacade;

    private static final String ACTION_LISTAR_ESTADO = "/listarEstadoPorPais";
    private static final String ACTION_LISTAR_MUNICIPIO = "/listarMunicipioPorEstado";

    /**
     * Método que faz a listagem de estados pelo codigo do pais.
     * Usado para popular os 'select' da tela de Cadastrar/Alterar.
     * @param idPais idPais
     * @return ResponseEntity<List<EstadoDTO>>
     */
    @RequestMapping(value = ACTION_LISTAR_ESTADO, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<EstadoDTO>> buscaEstadosPorPais(@RequestBody Long idPais) {
        try {
            List<EstadoDTO> listarEstados = enderecoFacade.findByEstadoPerPais(idPais);
            return new ResponseEntity<>(listarEstados, HttpStatus.OK);
        } catch (RuntimeException ex){
            throw new ExecutionException("Erro na busca de estados", ex);
        }
    }

    /**
     * Método que faz a listagem de municipios pelo codigo do estado.
     * Usado para popular os 'select' da tela de Cadastrar/Alterar.
     * @param idEstado idEstado
     * @return ResponseEntity<List<MunicipioDTO>>
     */
    @RequestMapping(value = ACTION_LISTAR_MUNICIPIO, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<MunicipioDTO>> buscaMunicipiosPorEstado(@RequestBody Long idEstado) {
        try {
            List<MunicipioDTO> listarMunicipios = enderecoFacade.findByMunicipioPerEstado(idEstado);
            return new ResponseEntity<>(listarMunicipios, HttpStatus.OK);
        } catch (RuntimeException ex){
            throw new ExecutionException("Erro na busca de municipios", ex);
        }
    }


}
