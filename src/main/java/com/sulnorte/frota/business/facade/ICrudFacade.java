package com.sulnorte.frota.business.facade;

public interface ICrudFacade<T> {

    /**
     * Método que salva a entidade no banco.
     * @param entity entity
     */
    void save(T entity);

    /**
     * Método que exclui uma entidade do banco.
     * @param id id
     */
    void delete(Long id);

}
