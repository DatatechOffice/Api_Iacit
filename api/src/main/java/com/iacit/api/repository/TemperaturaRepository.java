package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {
	@Query(
		value = "SELECT * FROM temperatura WHERE est_codigo = ?1 AND tem_data_hora BETWEEN ?2 AND ?3", 
		nativeQuery = true
	)
	public List<Temperatura> findByest_codigoAndtem_data_hora(
		String estCodigo, Timestamp dataInicial, Timestamp dataFinal
	);
	
	@Query(
			value = "copy temperatura (tem_data_hora, tem_max, tem_min, tem_ar_bulbo_seco, est_codigo)"
					+ " from 'C:\\dataFrame\\temperatura.csv' with delimiter ',' csv header encoding 'iso-8859-1'"
					,
			nativeQuery = true
		)
	public void copyTemperatura();
}
