package com.iacit.api.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacit.api.entity.Usuario;
import com.iacit.api.repository.UsuarioRepository;

@Service
public class ServiceUsuario {

	@Autowired(required = true)
	private UsuarioRepository usuarioRepository;

	
	//Retun de usuario
	public Usuario returnUsuario(String nome, String senha, Boolean acesso) {
		Usuario user = usuarioRepository.findByest_Nome_Senha_Usuario(nome, senha,acesso);

		if (user.getUsuarioLogin().isEmpty() && user.getUsuarioSenha().isEmpty()) {

		} else {
			user.getUsuarioAcesso();
		}
		return user;

	}

	//Salvar o usuario ou seja cadastrar
	public boolean save(String nome, String senha, boolean acesso) {

		Usuario usuario = new Usuario(nome, senha, acesso);
		Usuario saveUsuario = usuarioRepository.save(usuario);
		return saveUsuario != null && saveUsuario.getUsuarioId() != null;
	}

	public List findAll() {
		return (List) usuarioRepository.findAll();
	}

}
