package com.iacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
@Query(value = "insert into estado(reg_sigla) values(?)", nativeQuery = true)
	
	public List<Regiao> insertBySegSigla(String regSigla);

	@Query(value = "select * from estado", nativeQuery = true)

	public List<Estado> selectEstado();

}
