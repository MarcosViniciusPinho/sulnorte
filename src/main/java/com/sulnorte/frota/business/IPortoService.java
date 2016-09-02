package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Porto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPortoService extends JpaRepository<Porto, Long>{

    public List<Porto> findAllByOrderByIdAsc();
}
