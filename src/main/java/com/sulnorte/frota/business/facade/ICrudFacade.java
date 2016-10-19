package com.sulnorte.frota.business.facade;

/**
 * Classe genérica para fazer as ações comuns que são de salvar,alterar e deletar.
 * @param <T> entidade.
 */
public interface ICrudFacade<T> {

    /**
     * Método que salva/altera a entidade no banco.
     * @param entity entity
     */
    void save(T entity);

    /**
     * Método que exclui uma entidade do banco.
     * @param id id
     */
    void delete(Long id);

}
