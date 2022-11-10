package com.iacit.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iacit.api.entity.Estado;
import com.iacit.api.entity.Regiao;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
@Query(value = "insert into estado(reg_sigla, reg_id) values(?, (select max(reg_id) from regiao))", nativeQuery = true)

//https://vladmihalcea.com/manytoone-jpa-hibernate/

//https://pt.stackoverflow.com/questions/308601/pegar-id-de-tabela-mysql-em-aplica%C3%A7%C3%A3o

//"INSERT INTO tbnecessidade "+"(desc_necessidade, progresso_necessidade, fk_id_material, fk_id_tipo)"
//+ " VALUES (?, ?, (select max(pk_id_Material) from tbmaterial),(select max(pk_id_Tipo) from tbTipoOperacao))
	
	public List<Regiao> insertBySegSigla(String regSigla);

	@Query(value = "select * from estado where reg_id = ?", nativeQuery = true)
	
	public List<Estado> selectEstado();

}
