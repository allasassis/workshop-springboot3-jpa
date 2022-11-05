package com.educandoweb.course.config;

import java.util.Arrays;

// essa é uma classe configurada para rodar com o perfil de test

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration			// anotação que diz pro spring que essa classe é própria para configuração
@Profile("test")		// profile diz p spring para ele rodar as configurações somente quando ele estiver no perfil "test"
public class TestConfig implements CommandLineRunner{

	@Autowired 	// o spring resolve a dependência e associa uma instância de UserRepository aqui dentro
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// td oque for colocado aqui vai ser executado quando a aplicação for iniciada
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));		// aqui estamos salvando tudo na classe userRepository, que é a classe q acessa o banco
	}
	
	
}
