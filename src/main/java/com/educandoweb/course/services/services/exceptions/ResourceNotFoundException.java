package com.educandoweb.course.services.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	//aqui estamos recebendo o ID que tentamos encontrar, mas não encontramos
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
