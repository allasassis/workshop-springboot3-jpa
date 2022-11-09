package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.OrderItem;

@Repository // @Repository não é necessário porque a classe já está herdanddo do JpaRepository
public interface OrdemItemRepository extends JpaRepository<OrderItem, Long>{ // repositories geralmente são interfaces
	
	

}
