package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Vento;



public interface VentoRepository extends JpaRepository<Vento, Integer> {
@Query(value = "select * from vento where est_codigo = ?1 AND ven_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	
	public List<Vento> findByest_codigoAndven_data_hora(String estCodigo, Timestamp dataInicial, Timestamp dataFinal);

}
