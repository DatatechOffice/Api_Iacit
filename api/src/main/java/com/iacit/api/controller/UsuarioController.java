package com.iacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacit.api.entity.Usuario;
import com.iacit.api.service.ServiceUsuario;

@RestController
@RequestMapping({ "/Usuario" })
public class UsuarioController {
	@Autowired
	private ServiceUsuario serviceUsuario;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> read(@RequestBody DadosUsuario usuario) {
		serviceUsuario.returnUsuario(usuario.getEmail(), usuario.getSenha());

		Usuario usuarioRead = serviceUsuario.returnUsuario(
			usuario.getEmail(), usuario.getSenha()
		);

		return usuarioRead != null ? new ResponseEntity<Void>(HttpStatus.ACCEPTED)
			: new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
