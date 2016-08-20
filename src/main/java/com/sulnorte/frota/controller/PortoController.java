package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.IEstadoService;
import com.sulnorte.frota.business.IMunicipioService;
import com.sulnorte.frota.business.IPaisService;
import com.sulnorte.frota.business.IPortoService;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @Autowired
    private IPortoService portoService;

    @Autowired
    public IPaisService paisService;

    @Autowired
    public IEstadoService estadoService;

    @Autowired
    public IMunicipioService municipioService;

    @RequestMapping(value = ACTION_LIST)
    public String home(){
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
    public ResponseEntity<List<PortoDTO>> listEdicoes(@RequestBody String idPais) {
        HttpStatus status = HttpStatus.OK;
        List<String> lista = new ArrayList<String>(1);
        return null;
//        List<EdicaoDTO> edicaoList = new ArrayList<EdicaoDTO>();
//        try {
//            edicaoList = edicaoFacade.findAllEdicoesByPerfil(perfil);
//            status = HttpStatus.OK;
//        } catch (RuntimeException e) {
//            status = trataErroRest(lista, e);
//        }
//        return new ResponseEntity<List<EdicaoDTO>>(edicaoList, status);
    }

}
