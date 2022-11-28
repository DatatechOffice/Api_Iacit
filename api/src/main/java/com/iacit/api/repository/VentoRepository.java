package com.iacit.api.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Vento;

public interface VentoRepository extends JpaRepository<Vento, Integer> {
	@Query(value = "SELECT * FROM vento WHERE est_codigo = ?1 AND ven_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	public List<Vento> findByest_codigoAndven_data_hora(String estCodigo, Timestamp dataInicial, Timestamp dataFinal);

	@Query(value = "copy vento (ven_data_hora, ven_rajada_max, ven_velocidade_horaria, ven_direcao_horaria, est_codigo) "
			+ "from 'C:\\dataFrame\\vento.csv' with delimiter ',' csv header encoding 'iso-8859-1'", nativeQuery = true)
	public void copyVento();
}
