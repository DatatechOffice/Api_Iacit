package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacit.api.entity.Estacao;

public interface EstadoRepository extends JpaRepository<Estacao, String> {

}
