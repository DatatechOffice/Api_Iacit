package com.iacit.api.controller;

import org.hibernate.mapping.List;
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

	// CREATE
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody Usuario usuario) {
		return serviceUsuario.save(usuario) ? new ResponseEntity<Void>(HttpStatus.CREATED)
				: new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	// READ
	// Traz todos os usuarios
	@PostMapping(value = "/Usuario")
	public List findAll() {
		return (List) serviceUsuario.findAll();
	}

	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> read(@RequestBody Usuario usuario) {
		serviceUsuario.returnUsuario(usuario.getUsuarioLogin(), usuario.getUsuarioSenha());
		
		Usuario usuarioRead = serviceUsuario.returnUsuario(usuario.getUsuarioLogin(), usuario.getUsuarioSenha());
		
		
		return usuarioRead  != null ? new ResponseEntity<Void>(HttpStatus.ACCEPTED)
				:new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		
		/*
		 * return serviceUsuario.save(usuario) ? new
		 * ResponseEntity<Void>(HttpStatus.CREATED) : new
		 * ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		 */
	}
	
	
	// Usuario Especifico
	/*
	 * @RequestMapping(path = {"/{id}"}) public ResponseEntity
	 * findById(@PathVariable long id) { return
	 * serviceUsuario.findById(id).map(record -> ResponseEntity.ok().body(record))
	 * .orElse(ResponseEntity.notFound().build());
	 * 
	 * }
	 */

	
	
	
	
	
	// UPDATE

	/*
	 * @PutMapping(value="/{id}") public ResponseEntity update(@PathVariable("id")
	 * long id,
	 * 
	 * @RequestBody Contact contact) { return repository.findById(id) .map(record ->
	 * { record.setName(contact.getName()); record.setEmail(contact.getEmail());
	 * record.setPhone(contact.getPhone()); Contact updated =
	 * repository.save(record); return ResponseEntity.ok().body(updated);
	 * }).orElse(ResponseEntity.notFound().build()); }
	 */

	// DELETE

	/*
	 * @DeleteMapping(path ={"/{id}"}) public ResponseEntity <?>
	 * delete(@PathVariable long id) { return repository.findById(id) .map(record ->
	 * { repository.deleteById(id); return ResponseEntity.ok().build();
	 * }).orElse(ResponseEntity.notFound().build()); }
	 */

}
