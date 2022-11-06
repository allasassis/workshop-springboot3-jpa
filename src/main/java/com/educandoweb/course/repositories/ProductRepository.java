package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Product;

@Repository // @Repository não é necessário porque a classe já está herdanddo do JpaRepository
public interface ProductRepository extends JpaRepository<Product, Long>{ // repositories geralmente são interfaces
	
	

}
