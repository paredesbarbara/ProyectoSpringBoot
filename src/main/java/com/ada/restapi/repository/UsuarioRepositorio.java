package com.ada.restapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ada.restapi.model.Usuario;

	public interface UsuarioRepositorio  extends CrudRepository <Usuario, Integer>{

		Optional<Usuario> findByNombreUsuario(String nombreUsuario);
		
	}

