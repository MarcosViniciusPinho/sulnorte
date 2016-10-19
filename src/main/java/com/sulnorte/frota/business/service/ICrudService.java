package com.sulnorte.frota.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Classe responsável pela comunicação com o JpaRepository
 * @param <T> entidade
 */
@NoRepositoryBean
public interface ICrudService<T> extends JpaRepository<T, Long> {
}
