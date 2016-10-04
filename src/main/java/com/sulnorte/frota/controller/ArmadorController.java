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

    private static final String LISTAR_PAISES = "listarPaises";
    private static final String LISTAR_ARMADORES = "listarArmadores";
    private static final String LISTAR_PORTOS = "listarPortos";
    private static final String PATH_ARMADOR = "armador";

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
        mv.addObject(LISTAR_ARMADORES, this.armadorFacade.findAll());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareCreate(){
        ModelAndView mv = new ModelAndView(getViewForm());
        this.onLoadView(mv);
        mv.addObject(new ArmadorDTO());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareUpdateOrDetail(String view, Long id){
        ModelAndView mv = new ModelAndView(view);
        this.onLoadView(mv);
        mv.addObject(this.armadorFacade.findById(id));
        return mv;
    }

    /**
     * Método criado para retirar duplicação de código nos métodos 'onPrepareCreate' e 'onPrepareUpdateOrDetail'
     * @param mv mv
     */
    private void onLoadView(ModelAndView mv){
        mv.addObject(LISTAR_PAISES, enderecoFacade.findAllPais());
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
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
    protected String getPathController() {
        return PATH_ARMADOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Armador convertDtoToEntity(ArmadorDTO armadorDTO) {
        return armadorDTO.toEntity();
    }

}