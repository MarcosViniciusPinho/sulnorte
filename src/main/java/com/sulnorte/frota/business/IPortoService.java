package com.sulnorte.frota.business;

import com.sulnorte.frota.entity.Porto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPortoService extends JpaRepository<Porto, Long>{
}
