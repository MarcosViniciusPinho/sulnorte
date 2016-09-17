package com.sulnorte.frota.business.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICrudService<T> extends JpaRepository<T, Long> {
}
