package com.iacit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iacit.api.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value = "SELECT * FROM usuario WHERE usu_Login = ?1 and usu_Senha = ?2 and usu_Acesso=?3", nativeQuery = true)

	public Usuario findByest_Nome_Senha_Usuario(String nome, String senha,Boolean acesso);
}
