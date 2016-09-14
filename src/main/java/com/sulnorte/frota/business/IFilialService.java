package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFilialService extends JpaRepository<Filial, Long> {

    public List<Filial> findAllByOrderByNomeAsc();
}
