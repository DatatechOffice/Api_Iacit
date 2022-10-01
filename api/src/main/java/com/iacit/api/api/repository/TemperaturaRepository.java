package com.iacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import com.iacit.api.entity.Temperatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {
	@Query(value = "SELECT * FROM temperatura WHERE est_codigo = '?' AND tem_data_hora BETWEEN '?' AND '?'", nativeQuery = true)
	public List<Temperatura> listar(
			@Param("est_codigo") String est_codigo,
			@Param("tem_data_hora") Timestamp tem_data_hora,
			@Param("tem_data_hora")Timestamp tem_data_hora1
			);
}
