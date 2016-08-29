package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.IEstadoService;
import com.sulnorte.frota.business.IMunicipioService;
import com.sulnorte.frota.business.IPaisService;
import com.sulnorte.frota.business.IPortoService;
import com.sulnorte.frota.dto.EstadoDTO;
import com.sulnorte.frota.dto.MunicipioDTO;
import com.sulnorte.frota.dto.PaisDTO;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/porto")
public class PortoController {

    private static final String VIEW_LIST = "porto/List";
    private static final String ACTION_LIST = "/list";
    private static final String VIEW_FORM = "porto/Form";
    private static final String ACTION_CREATE = "/create";
    private static final String ACTION_EDIT = "/edit/{id}";
    private static final String ACTION_SAVE = "/save";
    private static final String LISTAR_PAISES="listarPaises";
    private static final String ACTION_LISTAR_ESTADO = "/listarEstadoPorPais";
    private static final String ACTION_LISTAR_MUNICIPIO = "/listarMunicipioPorEstado";
    private static final String LISTAR_PORTOS="listarPortos";
    private static final String MENSAGEM_SUCESSO="Operação realizada com sucesso.";
    private static final String REDIRECT_LIST="redirect:/porto/list";
    private static final String VIEW_DETAIL = "porto/Detail";
    private static final String ACTION_DETAIL = "/detail/{id}";
    private static final String ACTION_DELETE = "/delete/{id}";


    @Autowired
    private IPortoService portoService;

    @Autowired
    public IPaisService paisService;

    @Autowired
    public IEstadoService estadoService;

    @Autowired
    public IMunicipioService municipioService;

    @RequestMapping(value = ACTION_LIST)
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView(VIEW_LIST);
        mv.addObject(LISTAR_PORTOS, PortoDTO.convertListEntityToListDto(this.portoService.findAll()));
        return mv;
    }

    @RequestMapping(value = ACTION_CREATE)
    public ModelAndView prepareCreate(){
        ModelAndView mv = new ModelAndView(VIEW_FORM);
        mv.addObject(LISTAR_PAISES, PaisDTO.convertListEntityToListDto(this.paisService.findAll()));
        mv.addObject(new PortoDTO());
        return mv;
    }

    @RequestMapping(value = ACTION_EDIT)
    public ModelAndView prepareUpdate(@PathVariable Long id){
        return this.prepareUpdateOrDetail(VIEW_FORM, id);
    }

    @RequestMapping(value = ACTION_DETAIL)
    public ModelAndView prepareDetail(@PathVariable Long id){
        return this.prepareUpdateOrDetail(VIEW_DETAIL, id);
    }

    private ModelAndView prepareUpdateOrDetail(String view, Long id){
        ModelAndView mv = new ModelAndView(view);
        mv.addObject(LISTAR_PAISES, PaisDTO.convertListEntityToListDto(this.paisService.findAll()));
        mv.addObject(PortoDTO.toDto(this.portoService.getOne(id)));
        return mv;
    }

    @RequestMapping(value = ACTION_SAVE)
    public String save(PortoDTO portoDTO, RedirectAttributes redirectAttributes, Model model){
        this.portoService.save(portoDTO.toEntity());
        redirectAttributes.addFlashAttribute(ApplicationConstant.SUCESS, MENSAGEM_SUCESSO);
        model.addAttribute(LISTAR_PORTOS, PortoDTO.convertListEntityToListDto(this.portoService.findAll()));
        return REDIRECT_LIST;
    }

    @RequestMapping(value = ACTION_DELETE, method = RequestMethod.POST)
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        portoService.delete(id);
        redirectAttributes.addFlashAttribute(ApplicationConstant.SUCESS, MENSAGEM_SUCESSO);
        return REDIRECT_LIST;
    }


    @RequestMapping(value = ACTION_LISTAR_ESTADO, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<EstadoDTO>> buscaEstadosPorPais(@RequestBody Long idPais) {
        PaisDTO pais = PaisDTO.toDto(this.paisService.getOne(idPais));
        List<EstadoDTO> listarEstados = EstadoDTO.convertListEntityToListDto(this.estadoService.findByPais((pais.toEntity())));
        return new ResponseEntity<List<EstadoDTO>>(listarEstados, HttpStatus.OK);
    }

    @RequestMapping(value = ACTION_LISTAR_MUNICIPIO, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<MunicipioDTO>> buscaMunicipiosPorEstado(@RequestBody Long idEstado) {
        EstadoDTO estado = EstadoDTO.toDto(this.estadoService.getOne(idEstado));
        List<MunicipioDTO> listarMunicipios = MunicipioDTO.convertListEntityToListDto(this.municipioService.findByEstado(estado.toEntity()));
        return new ResponseEntity<List<MunicipioDTO>>(listarMunicipios, HttpStatus.OK);
    }

}