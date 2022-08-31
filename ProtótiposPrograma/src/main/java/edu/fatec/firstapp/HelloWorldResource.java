package edu.fatec.firstapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldResource {
	
	@GetMapping(path = "/hw")
	public ResponseEntity<String> getHw(){
		return new ResponseEntity<String>("Hello World!",
				HttpStatus.OK);
	}
	
}
