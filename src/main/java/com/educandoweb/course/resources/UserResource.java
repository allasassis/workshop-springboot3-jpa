package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

// esse pacote disponibiliza recursos web para a classe usar
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	// RespondeEntity é um tipo especifico do Spring para retornar respostas de requisições web
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		// User u = new User(1L, "Maria", "maria@gmail.com", "9492932", "12345");
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}") 				// isso indica que a requisição vai aceitar um ID dentro da URL
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// quando vamos inserir alguma coisa, usamos o POST e é por isso que usaremos o postmapping aqui
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) { //requestBody serve para que o json seja de deserializado para o arquivo java
		obj = service.insert(obj);
		// o padrão do HTTP é que, quando retornar um código 201, retornar também um cabeçalho com o novo endereço daquilo que você criou
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
