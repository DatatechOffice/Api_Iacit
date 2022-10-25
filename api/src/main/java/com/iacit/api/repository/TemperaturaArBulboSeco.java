package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturaArBulboSeco extends JpaRepository<TemperaturaArBulboSeco, Integer> {
	@Query(value = "select * from temperatura where est_codigo = ?1 AND tem_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	
	public List<TemperaturaArBulboSeco> findByest_codigoAndtem_data_hora(String estCodigo, Timestamp dataInicial, Timestamp dataFinal);
}
