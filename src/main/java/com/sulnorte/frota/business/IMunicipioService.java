package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMunicipioService extends JpaRepository<Municipio, Long> {
}
