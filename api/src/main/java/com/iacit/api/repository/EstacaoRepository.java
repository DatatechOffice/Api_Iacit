package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.iacit.api.entity.Estacao;
import com.iacit.api.entity.Regiao;

@Repository
public interface EstacaoRepository extends JpaRepository<Estacao, String> {
@Query(value = "insert into estado(reg_sigla) values(?)", nativeQuery = true)
	
	public List<Regiao> insertBySegSigla(String regSigla);
}
