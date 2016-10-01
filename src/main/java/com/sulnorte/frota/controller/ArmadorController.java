package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.dto.ArmadorDTO;
import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.entity.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro/armador")
public class ArmadorController extends EnderecoController<ArmadorDTO, Armador>{

    private static final String VIEW_LIST = "cadastro/armador/List";
    private static final String VIEW_FORM = "cadastro/armador/Form";
    private static final String LISTAR_PAISES = "listarPaises";
    private static final String LISTAR_ARMADORES = "listarArmadores";
    private static final String LISTAR_PORTOS = "listarPortos";
    private static final String REDIRECT_LIST = "redirect:/cadastro/armador/list";
    private static final String VIEW_DETAIL = "cadastro/armador/Detail";

    @Autowired
    private IArmadorFacade<Armador> armadorFacade;

    @Autowired
    private IPortoFacade<Porto> portoFacade;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onList(){
        ModelAndView mv = new ModelAndView(VIEW_LIST);
        mv.addObject(LISTAR_ARMADORES, this.armadorFacade.findAll());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareCreate(){
        ModelAndView mv = new ModelAndView(VIEW_FORM);
        mv.addObject(LISTAR_PAISES, enderecoFacade.findAllPais());
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        mv.addObject(new ArmadorDTO());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareUpdateOrDetail(String view, Long id){
        ModelAndView mv = new ModelAndView(view);
        mv.addObject(LISTAR_PAISES, enderecoFacade.findAllPais());
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        mv.addObject(this.armadorFacade.findById(id));
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IArmadorFacade<Armador> getFacade() {
        return armadorFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getViewForm() {
        return VIEW_FORM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getviewDetail() {
        return VIEW_DETAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getRedirectViewList() {
        return REDIRECT_LIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Armador convertDtoToEntity(ArmadorDTO armadorDTO) {
        return armadorDTO.toEntity();
    }


}