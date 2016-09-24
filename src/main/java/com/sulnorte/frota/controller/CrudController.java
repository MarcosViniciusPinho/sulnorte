package com.sulnorte.frota.controller;

import com.sulnorte.frota.business.facade.ICrudFacade;
import com.sulnorte.frota.util.ApplicationConstant;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class CrudController<V, T> {

    private static final String ACTION_LIST = "/list";
    private static final String ACTION_CREATE = "/create";
    private static final String ACTION_EDIT = "/edit/{id}";
    private static final String ACTION_SAVE = "/save";
    private static final String MENSAGEM_SUCESSO = "Operação realizada com sucesso.";
    private static final String ACTION_DETAIL = "/detail/{id}";
    private static final String ACTION_DELETE = "/delete/{id}";

    /**
     * Método que deverá ser sempre implementado por suas subclasses.
     * @return ICrudFacade<T>
     */
    protected abstract ICrudFacade<T> getFacade();

    /**
     * Método que salva/altera uma entidade.
     * @param entity entity
     * @param redirectAttributes redirectAttributes
     * @return String
     */
    @RequestMapping(value = ACTION_SAVE, method = RequestMethod.POST)
    public String save(V entity, RedirectAttributes redirectAttributes){
        try{
            this.getFacade().save(this.convertDtoToEntity(entity));
            redirectAttributes.addFlashAttribute(ApplicationConstant.SUCESS, MENSAGEM_SUCESSO);
            return this.getRedirectViewList();
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Método que exclui uma entidade.
     * @param id id
     * @param redirectAttributes redirectAttributes
     * @return String
     */
    @RequestMapping(value = ACTION_DELETE, method = RequestMethod.POST)
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try {
            this.getFacade().delete(id);
            redirectAttributes.addFlashAttribute(ApplicationConstant.SUCESS, MENSAGEM_SUCESSO);
            return this.getRedirectViewList();
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Método que faz a listagem dos registros na tela.
     * @return ModelAndView
     */
    @RequestMapping(value = ACTION_LIST)
    public ModelAndView list(){
        try {
            return this.onList();
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Método responsável de montar as informacoes no grid da tela e que deve ser implementado nas subclasses.
     * @return ModelAndView
     */
    protected abstract ModelAndView onList();

    /**
     * Método que redireciona o usuário para a tela de cadastrar.
     * @return ModelAndView
     */
    @RequestMapping(value = ACTION_CREATE)
    public ModelAndView prepareCreate(){
        return this.onPrepareCreate();
    }

    /**
     * Método responsável de montar as informacoes que irao aparecer na tela de cadastrar e que deve ser implementado nas subclasses.
     * @return ModelAndView
     */
    protected abstract ModelAndView onPrepareCreate();

    /**
     * Método que redireciona o usuário para a tela de alterar.
     * @param id id
     * @return ModelAndView
     */
    @RequestMapping(value = ACTION_EDIT)
    public ModelAndView prepareUpdate(@PathVariable Long id){
        return this.onPrepareUpdateOrDetail(this.getViewForm(), id);
    }

    /**
     * Método que redireciona o usuário para a tela de detalhar.
     * @param id id
     * @return ModelAndView
     */
    @RequestMapping(value = ACTION_DETAIL)
    public ModelAndView prepareDetail(@PathVariable Long id){
        return this.onPrepareUpdateOrDetail(this.getviewDetail(), id);
    }

    /**
     * Método responsável de montar as informacoes que irao aparecer na tela de alterar/detalhar e que deve ser implementado nas subclasses.
     * @param view view
     * @param id id
     * @return ModelAndView
     */
    protected abstract ModelAndView onPrepareUpdateOrDetail(String view, Long id);

    /**
     * Método que retorna o caminho da pagina de alterar.
     * @return String
     */
    protected abstract String getViewForm();

    /**
     * Método que retorna o caminho da pagina de detalhar.
     * @return
     */
    protected abstract String getviewDetail();

    /**
     * Método que redireciona para a tela de listagem dos registros.
     * @return String
     */
    protected abstract String getRedirectViewList();

    /**
     * Convert uma classe dto para uma classe pojo e que deve ser implementado nas subclasses.
     * @param dto dto
     * @return T
     */
    protected abstract T convertDtoToEntity(V dto);



}
