package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

// esse pacote disponibiliza recursos web para a classe user
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// RespondeEntity é um tipo especifico do Spring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9492932", "12345");
		return ResponseEntity.ok().body(u);
	}
}
