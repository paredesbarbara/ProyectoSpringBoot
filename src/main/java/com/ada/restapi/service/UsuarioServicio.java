package com.ada.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.model.Usuario;
import com.ada.restapi.repository.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicio {
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	public Usuario save(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepositorio.findAll();
	}

	public Optional<Usuario> findById(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findById(idUsuario);
	}

	public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findByNombreUsuario(nombreUsuario);
	}

	public void deleteById(int idUsuario) {
		usuarioRepositorio.deleteById(idUsuario);
		
	}




}
