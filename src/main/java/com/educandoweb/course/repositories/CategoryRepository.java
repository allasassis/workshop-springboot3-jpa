package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Category;

@Repository // @Repository não é necessário porque a classe já está herdanddo do JpaRepository
public interface CategoryRepository extends JpaRepository<Category, Long>{ // repositories geralmente são interfaces
	
	

}
