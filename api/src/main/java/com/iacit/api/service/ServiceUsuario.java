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
	public Usuario returnUsuario(String email, String senha) {
		Usuario user = usuarioRepository.findByest_Nome_Senha_Usuario(email, senha);
		
		return user;
	}

	//Salvar o usuario ou seja cadastrar
	public Usuario save(String nome, String email, String senha) {
		Usuario usuario = new Usuario(nome, email, senha);
		Usuario saveUsuario = usuarioRepository.save(usuario);
		return saveUsuario;
	}

	public List findAll() {
		return (List) usuarioRepository.findAll();
	}
}
