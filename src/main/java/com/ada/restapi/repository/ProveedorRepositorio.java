package com.ada.restapi.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.ada.restapi.model.Proveedor;

public interface ProveedorRepositorio extends CrudRepository <Proveedor, Integer> {

	Optional<Proveedor> findByNombreEmpresa(String nombreEmpresa);

	

	
	

}
