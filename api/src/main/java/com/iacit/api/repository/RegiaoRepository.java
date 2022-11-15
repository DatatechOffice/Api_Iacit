package com.iacit.api.repository;

import java.util.List;

import com.iacit.api.entity.Regiao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {
	@Query(value = "INSERT INTO regiao(reg_sigla) VALUES ('?')", nativeQuery = true)
	public List<Regiao> Jorge(String regSigla);

	@Query(value = "SELECT reg_id FROM regiao WHERE reg_sigla = ?1", nativeQuery = true)
	public Regiao selectBySegSigla(String regSigla);

	@Query(value = "SELECT * FROM regiao", nativeQuery = true)
	public List<Regiao> selectRegiao();
}
