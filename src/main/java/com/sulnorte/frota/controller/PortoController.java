package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.IEstadoService;
import com.sulnorte.frota.business.IMunicipioService;
import com.sulnorte.frota.business.IPaisService;
import com.sulnorte.frota.business.IPortoService;
import com.sulnorte.frota.dto.EstadoDTO;
import com.sulnorte.frota.dto.MunicipioDTO;
import com.sulnorte.frota.dto.PaisDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/porto")
public class PortoController {

    private static final String VIEW_LIST = "porto/List";
    private static final String ACTION_LIST = "/list";
    private static final String VIEW_FORM = "porto/Form";
    private static final String ACTION_CREATE = "/create";
    private static final String ACTION_SAVE = "/save";
    private static final String LISTAR_PAISES="listarPaises";
    private static final String ACTION_LISTAR_ESTADO = "/listarEstadoPorPais";
    private static final String ACTION_LISTAR_MUNICIPIO = "/listarMunicipioPorEstado";

    @Autowired
    private IPortoService portoService;

    @Autowired
    public IPaisService paisService;

    @Autowired
    public IEstadoService estadoService;

    @Autowired
    public IMunicipioService municipioService;

    @RequestMapping(value = ACTION_LIST)
    public String list(){
        return VIEW_LIST;
    }

    @RequestMapping(value = ACTION_CREATE)
    public ModelAndView prepareCreate(){
        ModelAndView mv = new ModelAndView(VIEW_FORM);
        mv.addObject(new PortoDTO());
        return mv;
    }

    @RequestMapping(value = ACTION_SAVE)
    public ModelAndView save(PortoDTO portoDTO){
        ModelAndView mv = new ModelAndView(VIEW_LIST);
        this.portoService.save(portoDTO.toEntity());
        return mv;
    }

    @ModelAttribute(LISTAR_PAISES)
    public List<Pais> getListarPaises(){
        return this.paisService.findAll();
    }

    @RequestMapping(value = ACTION_LISTAR_ESTADO, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<EstadoDTO>> buscaEstadosPorPais(@RequestBody String idPais) {
        PaisDTO pais = PaisDTO.toDto(this.paisService.getOne(Long.parseLong(idPais)));
        List<EstadoDTO> listarEstados = EstadoDTO.convertListEntityToListDto(this.estadoService.findByPais((pais.toEntity())));
        return new ResponseEntity<List<EstadoDTO>>(listarEstados, HttpStatus.OK);
    }

    @RequestMapping(value = ACTION_LISTAR_MUNICIPIO, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<MunicipioDTO>> buscaMunicipiosPorEstado(@RequestBody String idEstado) {
        EstadoDTO estado = EstadoDTO.toDto(this.estadoService.getOne(Long.parseLong(idEstado)));
        List<MunicipioDTO> listarMunicipios = MunicipioDTO.convertListEntityToListDto(this.municipioService.findByEstado(estado.toEntity()));
        return new ResponseEntity<List<MunicipioDTO>>(listarMunicipios, HttpStatus.OK);
    }

}
