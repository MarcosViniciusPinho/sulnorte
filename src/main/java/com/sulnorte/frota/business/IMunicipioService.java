package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMunicipioService extends JpaRepository<Municipio, Long> {

    public List<Municipio> findByEstadoOrderByNomeAsc(Estado estado);

}
