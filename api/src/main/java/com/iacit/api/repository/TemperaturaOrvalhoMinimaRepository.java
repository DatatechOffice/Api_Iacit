package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.TemperaturaOrvalhoMinima;

public interface TemperaturaOrvalhoMinimaRepository extends JpaRepository<TemperaturaOrvalhoMinima, Integer> {
@Query(value = "SELECT * FROM radiacao_global WHERE est_codigo = ?1 AND rag_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	
	public List<TemperaturaOrvalhoMinima> findByest_codigoAndTOrv_data_hora(String estCodigo, Timestamp dataInicial, Timestamp dataFinal);

}
