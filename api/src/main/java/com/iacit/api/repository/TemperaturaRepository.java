package com.iacit.api.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {
	//@Query(value = "SELECT * FROM temperatura WHERE est_codigo = ?1 AND tem_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	@Query(value = "SELECT * FROM temperatura WHERE est_codigo = ?1 AND tem_data_hora '?2'", nativeQuery = true)
	
	public List<Temperatura> listar(String estCodigo, Timestamp dataInicial);
	//public List<Temperatura> listar(@Param("estCodigo")String estCodigo, @Param("dataInicial")String dataInicial, @Param("dataFinal")String dataFinal);
	
}
