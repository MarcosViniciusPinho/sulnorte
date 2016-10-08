package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.IArmadorFacade;
import com.sulnorte.frota.business.facade.IPortoFacade;
import com.sulnorte.frota.business.facade.IRebocadorFacade;
import com.sulnorte.frota.dto.RebocadorDTO;
import com.sulnorte.frota.entity.Armador;
import com.sulnorte.frota.entity.Porto;
import com.sulnorte.frota.entity.Rebocador;
import com.sulnorte.frota.exception.util.ParameterExceptionUtil;
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
        this.onLoadView(mv);
        mv.addObject(new RebocadorDTO());
        return mv;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelAndView onPrepareUpdateOrDetail(String view, Long id){
        ParameterExceptionUtil.validateObjectNull(view);
        ParameterExceptionUtil.validateObjectNull(id);
        ModelAndView mv = new ModelAndView(view);
        this.onLoadView(mv);
        mv.addObject(this.rebocadorFacade.findById(id));
        return mv;
    }

    /**
     * Método criado para retirar duplicação de código nos métodos 'onPrepareCreate' e 'onPrepareUpdateOrDetail'
     * @param mv mv
     */
    private void onLoadView(ModelAndView mv){
        mv.addObject(LISTAR_PORTOS, this.portoFacade.findAll());
        mv.addObject(LISTAR_ARMADORES, this.armadorFacade.findAll());
        mv.addObject(LISTAR_PROPULSOES, this.rebocadorFacade.findAllPropulsao());
        mv.addObject(LISTAR_SITUACOES, this.rebocadorFacade.findAllSituacao());
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
        ParameterExceptionUtil.validateObjectNull(rebocadorDTO);
        return rebocadorDTO.toEntity();
    }

}