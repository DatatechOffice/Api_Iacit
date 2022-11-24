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

	public Usuario returnUsuario(String nome, String senha) {
		// usuarioRepository.findByest_Nome_Senha_Usuario();
		Usuario user = usuarioRepository.findByest_Nome_Senha_Usuario(nome,senha);
		if (user.getUsuarioLogin().isEmpty() && user.getUsuarioSenha().isEmpty()) {

		} else {
			user.getUsuarioAcesso();
		}
		return user;

	}
	
	/*
	 * public ResponseEntity findById(@PathVariable long id){ return
	 * repository.findById(id) .map(record -> ResponseEntity.ok().body(record))
	 * .orElse(ResponseEntity.notFound().build());
	 * 
	 * }
	 */
	
	

	public boolean save(Usuario usuario) {

		Usuario saveUsuario = usuarioRepository.save(usuario);
		return saveUsuario != null && saveUsuario.getUsuarioId() != null;
	}
	
	
	
	public List findAll() {
		return (List) usuarioRepository.findAll(); 
		}
	
	
	
	
	
	

}
