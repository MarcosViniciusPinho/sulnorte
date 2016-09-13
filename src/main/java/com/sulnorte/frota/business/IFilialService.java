package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilialService extends JpaRepository<Filial, Long> {
}
