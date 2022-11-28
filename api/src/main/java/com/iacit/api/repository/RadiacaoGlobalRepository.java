package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.RadiacaoGlobal;

public interface RadiacaoGlobalRepository extends JpaRepository<RadiacaoGlobal, Integer> {
	@Query(
		value = "SELECT * FROM radiacao_global WHERE est_codigo = ?1 AND rag_data_hora BETWEEN ?2 AND ?3",
		nativeQuery = true
	)
	public List<RadiacaoGlobal> findByest_codigoAndrag_data_hora(
		String estCodigo, Timestamp dataInicial, Timestamp dataFinal
	);
	
	@Query(
			value = "copy radiacao_global (rag_data_hora, rag_radiacao_global, est_codigo) from "
					+ "'C:\\dataFrame\\radiacao_global.csv' with delimiter ',' csv header encoding 'iso-8859-1'"
					,
			nativeQuery = true
		)
	public void copyRadiacaoGlobal();

}
