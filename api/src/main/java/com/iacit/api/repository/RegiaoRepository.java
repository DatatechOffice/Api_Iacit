package com.iacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Regiao;

public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {
	@Query(value = "Insert into regiao(reg_sigla) values ('?')", nativeQuery = true)
	public List<Regiao> Jorge(String regSigla);
}
