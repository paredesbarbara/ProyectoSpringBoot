package com.ada.restapi.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.ada.restapi.model.Detalle;

public interface DetalleRepositorio extends CrudRepository <Detalle, Integer>{

	void save(Set<Detalle> detalleVenta);
	
}


