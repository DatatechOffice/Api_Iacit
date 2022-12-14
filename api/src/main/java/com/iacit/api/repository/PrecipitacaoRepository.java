package com.iacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Precipitacao;

public interface PrecipitacaoRepository extends JpaRepository<Precipitacao, Integer> {
	@Query(value = "SELECT * FROM precipitacao WHERE est_codigo = ?1 AND pre_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	public List<Precipitacao> findByest_codigoAndrag_data_hora(String estCodigo, Timestamp dataInicial,
			Timestamp dataFinal);

	@Query(value = "copy precipitacao (pre_data_hora, pre_valor, est_codigo) from 'C:\\dataFrame\\precipitacao.csv' with delimiter ',' csv header encoding 'ISO-8859-1'", nativeQuery = true)
	public void copyPrecipitacao();

}
