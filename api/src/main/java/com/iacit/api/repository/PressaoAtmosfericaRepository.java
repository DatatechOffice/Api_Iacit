package com.iacit.api.repository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.iacit.api.entity.PressaoAtmosferica;
import com.iacit.api.entity.Temperatura;

public interface PressaoAtmosfericaRepository extends JpaRepository<PressaoAtmosferica, Integer>{
	@Query(value = "SELECT * FROM pressao_atmosferica WHERE est_codigo = ?1 AND pra_data_hora BETWEEN ?2 AND ?3", nativeQuery = true)
	public List<PressaoAtmosferica> findByest_codigoAndpra_data_hora(String estCodigo, Timestamp dataInicial, Timestamp dataFinal);
}
