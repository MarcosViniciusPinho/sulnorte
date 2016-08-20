package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marcospinho on 19/08/16.
 */
public interface IEstadoService extends JpaRepository<Pais, Long> {
}
