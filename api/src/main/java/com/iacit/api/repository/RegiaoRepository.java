package com.iacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {

	@Query(value = "Insert into regiao(reg_sigla) values ('?')", nativeQuery = true)
	public List<Regiao> Jorge(String regSigla);

	@Query(value = "select reg_id from regiao where reg_sigla = ?1", nativeQuery = true)
	public Regiao selectBySegSigla(String regSigla);

	@Query(value = "select * from regiao", nativeQuery = true)
	public List<Regiao> selectRegiao();

}
