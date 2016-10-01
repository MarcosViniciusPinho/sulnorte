package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.dto.PortoDTO;
import com.sulnorte.frota.entity.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro/porto")
public class PortoController extends EnderecoController<PortoDTO, Porto>{

    private static final String LISTAR_PAISES = "listarPaises";
    private static final String LISTAR_PORTOS = "listarPortos";
    private static final String LISTAR_FILIAIS = "listarFiliais";
    private static final String PATH_PORTO = "porto";

    @Autowired
    private IPortoFacade<Porto> portoFacade;

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onList(){
        ModelAndView mv = new ModelAndView(getViewList());
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareCreate(){
        ModelAndView mv = new ModelAndView(getViewForm());
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
    protected String getPathController() {
        return PATH_PORTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Porto convertDtoToEntity(PortoDTO portoDTO) {
        return portoDTO.toEntity();
    }

}