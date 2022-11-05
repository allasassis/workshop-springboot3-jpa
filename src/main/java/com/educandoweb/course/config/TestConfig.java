package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

// essa é uma classe configurada para rodar com o perfil de test

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration			// anotação que diz pro spring que essa classe é própria para configuração
@Profile("test")		// profile diz p spring para ele rodar as configurações somente quando ele estiver no perfil "test"
public class TestConfig implements CommandLineRunner{

	@Autowired 	// o spring resolve a dependência e associa uma instância de UserRepository aqui dentro
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	@Override
	public void run(String... args) throws Exception {
		// td oque for colocado aqui vai ser executado quando a aplicação for iniciada
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), u1, OrderStatus.PAID); // associação do usuário com o pedido
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT); 
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));		// aqui estamos salvando tudo na classe userRepository, que é a classe q acessa o banco
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
