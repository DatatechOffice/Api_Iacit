package com.iacit.api.repository;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.iacit.api.entity.Temperatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TemperaturaRepository extends JpaRepository<Temperatura, Long> {
	@Query(value = "Select * FROM Temperatura WHERE '?' AND '?'", nativeQuery = true)
	public ArrayList<Temperatura> listar(
			@Param("est_codigo") String est_codigo,
			@Param("tem_data_hora") Timestamp tem_data_hora
			);
}
