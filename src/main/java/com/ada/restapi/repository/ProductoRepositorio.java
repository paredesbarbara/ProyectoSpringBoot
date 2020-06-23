package com.ada.restapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.ada.restapi.model.Producto;
public interface ProductoRepositorio extends CrudRepository <Producto, Integer>{

	Optional<Producto> findByNombre(String nombre);

	Optional<Producto> findByCodigo(String codigo);

	
}




