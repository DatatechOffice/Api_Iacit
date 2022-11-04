package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.iacit.api.entity.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {
@Query(value = "select reg_id from regiao where reg_sigla = ?", nativeQuery = true)
	
	public Regiao selectBySegSigla(String regSigla);

}
