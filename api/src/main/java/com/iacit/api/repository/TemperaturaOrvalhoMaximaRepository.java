package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.TemperaturaOrvalhoMaxima;

public interface TemperaturaOrvalhoMaximaRepository extends JpaRepository<TemperaturaOrvalhoMaxima, Integer> {
@Query(value = "SELECT * FROM radiacao_global WHERE est_codigo = ?1 AND rag_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	
	public List<TemperaturaOrvalhoMaxima> findByest_codigoAndTOrv_data_hora(String estCodigo, Timestamp dataInicial, Timestamp dataFinal);

}