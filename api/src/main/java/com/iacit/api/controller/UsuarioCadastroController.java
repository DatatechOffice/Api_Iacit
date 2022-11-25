package com.iacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.iacit.api.service.ServiceUsuario;

@Controller
public class UsuarioCadastroController {
	@Autowired
	private ServiceUsuario serviceUsuario;
    	// CREATE
	@PostMapping(value = "/UsuarioCadastro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody DadosUsuario usuario) {
		
		System.out.println("Jorge");
		return serviceUsuario.save(
					usuario.getNome(), usuario.getEmail(), usuario.getSenha()
					) != null
				? new ResponseEntity<Void>(HttpStatus.CREATED)
				: new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
