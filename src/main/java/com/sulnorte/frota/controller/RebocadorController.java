package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.facade.IRebocadorFacade;
import com.sulnorte.frota.dto.RebocadorDTO;
import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.entity.Porto;
import com.sulnorte.frota.entity.Rebocador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro/rebocador")
public class RebocadorController extends CrudController<RebocadorDTO, Rebocador>{

    private static final String LISTAR_REBOCADORES = "listarRebocadores";
    private static final String LISTAR_ARMADORES = "listarArmadores";
    private static final String LISTAR_PORTOS = "listarPortos";
    private static final String LISTAR_PROPULSOES = "listarPropulsoes";
    private static final String LISTAR_SITUACOES = "listarSituacoes";
    private static final String PATH_REBOCADOR = "rebocador";

    @Autowired
    private IRebocadorFacade<Rebocador> rebocadorFacade;

    @Autowired
    private IArmadorFacade<Armador> armadorFacade;

    @Autowired
    private IPortoFacade<Porto> portoFacade;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onList(){
        ModelAndView mv = new ModelAndView(getViewList());
        mv.addObject(LISTAR_REBOCADORES, this.rebocadorFacade.findAll());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareCreate(){
        ModelAndView mv = new ModelAndView(getViewForm());
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        mv.addObject(LISTAR_ARMADORES, this.armadorFacade.findAll());
        mv.addObject(LISTAR_PROPULSOES, this.rebocadorFacade.findAllPropulsao());
        mv.addObject(LISTAR_SITUACOES, this.rebocadorFacade.findAllSituacao());
        mv.addObject(new RebocadorDTO());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareUpdateOrDetail(String view, Long id){
        ModelAndView mv = new ModelAndView(view);
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        mv.addObject(LISTAR_ARMADORES, this.armadorFacade.findAll());
        mv.addObject(LISTAR_PROPULSOES, this.rebocadorFacade.findAllPropulsao());
        mv.addObject(LISTAR_SITUACOES, this.rebocadorFacade.findAllSituacao());
        mv.addObject(this.rebocadorFacade.findById(id));
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IRebocadorFacade<Rebocador> getFacade() {
        return rebocadorFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPathController() {
        return PATH_REBOCADOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Rebocador convertDtoToEntity(RebocadorDTO rebocadorDTO) {
        return rebocadorDTO.toEntity();
    }

}