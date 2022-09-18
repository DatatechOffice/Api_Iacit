package com.iacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iacit.api.modal.viewTemperatura;


public interface temperaturaRepository extends JpaRepository<viewTemperatura, String> {
	@Query("SELECT vt FROM view_temperatura vt WHERE vt.est_nome_estacao = :est_nome_estacao AND "
			+ "vt.est_codigo = :est_codigo AND vt.tem_data_hora = :tem_data_hora")
	public List<viewTemperatura> listar(
			@Param("est_nome_estacao") String est_nome_estacao,
			@Param("est_codigo") String est_codigo,
			@Param("tem_data_hora") Timestamp tem_data_hora
			);
}
