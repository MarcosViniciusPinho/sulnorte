package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisService extends JpaRepository<Pais, Long> {
}
