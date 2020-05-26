package com.qintess.ingressosonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qintess.ingressosonline.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
