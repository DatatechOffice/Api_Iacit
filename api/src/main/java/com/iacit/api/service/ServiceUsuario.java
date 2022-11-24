package com.iacit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.iacit.api.entity.Usuario;
import com.iacit.api.repository.UsuarioRepository;

@Service
public class ServiceUsuario {

	@Autowired(required = true)
	private UsuarioRepository usuarioRepository;

	public Usuario returnUsuario(String nome, String senha) {
		// usuarioRepository.findByest_Nome_Senha_Usuario();
		Usuario user = usuarioRepository.findByest_Nome_Senha_Usuario();
		if( user.getUsuarioLogin().isEmpty() && user.getUsuarioSenha().isEmpty())
		{
			
		}
		else
		{
			user.getUsuarioAcesso();
		}
		return user;

		
	}

	
	
	public boolean save (Usuario usuario) {
		
		Usuario saveUsuario = usuarioRepository.save(usuario);
		 return saveUsuario != null && saveUsuario.getUsuarioId() !=null;
		}
	
	
	
	
		
	
	
	
}
