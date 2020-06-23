package com.ada.restapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ada.restapi.model.Cliente;

public interface ClienteRepositorio  extends CrudRepository <Cliente, Integer>{

	Optional<Cliente> findByNombre(String nombre);

	
	}
	
	
		
	
	
	
	
	
	

