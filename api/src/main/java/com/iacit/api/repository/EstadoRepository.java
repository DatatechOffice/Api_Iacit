package com.iacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	@Query(value = "select * from estado where etd_unidade_federativa = ?1", nativeQuery = true)
	public Estado selectBySigla(String etd);

	@Query(value = "select * from estado", nativeQuery = true)
	public List<Estado> selectEstado();

}
