package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Estado;
import com.sulnorte.frota.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEstadoService extends JpaRepository<Estado, Long> {

    public List<Estado> findByPais(Pais pais);

}
