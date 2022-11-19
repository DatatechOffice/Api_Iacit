package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository <Usuario,Integer> {
	
	@Query(
			value = "SELECT * FROM usuario WHERE usu_Id = ? ",
			nativeQuery = true
		)
	
		public Usuario findByest_codigoAndTOrv_data_hora();
}




	

