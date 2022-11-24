package com.iacit.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	@PostMapping
	public void create(@RequestBody Usuario usuario) {
		serviceUsuario.save(usuario);
	}

	// READ

	// Traz todos os usuarios
	/*
	 * @RequestMapping(value = "/Usuario", method = RequestMethod.GET) public List
	 * findAll() { return (List) repository.findAll(); }
	 */

	// Usuario Especifico
	// @RequestMapping(path = {"/{id}"})
	/*
	 * public ResponseEntity findById(@PathVariable long id){ return
	 * repository.findById(id) .map(record -> ResponseEntity.ok().body(record))
	 * .orElse(ResponseEntity.notFound().build());
	 */
	// }

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
