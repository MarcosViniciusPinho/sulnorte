package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/porto")
public class PortoController extends EnderecoController<PortoDTO, Porto>{

    private static final String VIEW_LIST = "porto/List";
    private static final String VIEW_FORM = "porto/Form";
    private static final String LISTAR_PAISES = "listarPaises";
    private static final String LISTAR_PORTOS = "listarPortos";
    private static final String REDIRECT_LIST = "redirect:/porto/list";
    private static final String VIEW_DETAIL = "porto/Detail";
    private static final String LISTAR_FILIAIS = "listarFiliais";

    @Autowired
    private IPortoFacade<Porto> portoFacade;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onList(){
        ModelAndView mv = new ModelAndView(VIEW_LIST);
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareCreate(){
        ModelAndView mv = new ModelAndView(VIEW_FORM);
        mv.addObject(LISTAR_PAISES, enderecoFacade.findAllPais());
        mv.addObject(LISTAR_FILIAIS, this.portoFacade.findAllFilial());
        mv.addObject(new PortoDTO());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareUpdateOrDetail(String view, Long id){
        ModelAndView mv = new ModelAndView(view);
        mv.addObject(LISTAR_PAISES, enderecoFacade.findAllPais());
        mv.addObject(LISTAR_FILIAIS, this.portoFacade.findAllFilial());
        mv.addObject(this.portoFacade.findById(id));
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IPortoFacade<Porto> getFacade() {
        return portoFacade;
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
    protected Porto convertDtoToEntity(PortoDTO portoDTO) {
        return portoDTO.toEntity();
    }


}