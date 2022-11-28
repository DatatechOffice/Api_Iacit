package com.iacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Estacao;

public interface EstacaoRepository extends JpaRepository<Estacao, String> {
	@Query(value = "SELECT * FROM estacao", nativeQuery = true)
	public List<Estacao> selectEstacao();

	@Query(value = "SELECT * FROM estacao where est_nome_estacao = ?1", nativeQuery = true)
	public Estacao selectCodigoEstacao(String nomeEstacao);
}
