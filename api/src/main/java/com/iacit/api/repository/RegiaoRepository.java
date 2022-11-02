package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Regiao;
import com.iacit.api.entity.Temperatura;

public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {
@Query(value = "insert into regiao(reg_sigla) values('?')", nativeQuery = true)
	
	public List<Regiao> insertBySegSigla(String regSigla);

}
