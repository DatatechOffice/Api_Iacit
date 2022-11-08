package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}