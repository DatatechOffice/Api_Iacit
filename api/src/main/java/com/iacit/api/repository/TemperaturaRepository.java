package com.iacit.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apiIacit.DatatechApiIacit.entity.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {
	@Query(value = "SELECT * FROM temperatura WHERE est_codigo = 'estCodigo' AND tem_data_hora BETWEEN 'dataInicial' AND 'dataFinal'", nativeQuery = true)
	public List<Temperatura> listar(@Param("estCodigo")String estCodigo, @Param("dataInicial")Date dataInicial, @Param("dataFinal")Date dataFinal);
}
