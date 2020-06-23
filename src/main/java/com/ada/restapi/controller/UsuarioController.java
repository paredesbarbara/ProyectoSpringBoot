package com.ada.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ada.restapi.model.Usuario;
import com.ada.restapi.service.UsuarioServicio;

@Controller
@RequestMapping(path = "/usuario/")
public class UsuarioController {

	@Autowired
	UsuarioServicio usuarioServicio;

	// Alta de usuario
	@PostMapping(path = "/alta")
	public ResponseEntity<Usuario> altaUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNuevo = usuarioServicio.save(usuario);
		return ResponseEntity.ok(usuarioNuevo);
	}

	// Listado de usuarios- FUNCIONA
	@GetMapping(path = "/listado")
	public ResponseEntity<List<Usuario>> getUsuario() {
		List<Usuario> listaUsuario = (List<Usuario>) usuarioServicio.findAll();
		return ResponseEntity.ok(listaUsuario);
	}

	// Busqueda de usuario x id - FUNCIONA
	@RequestMapping(value = "/id/{idUsuario}")
	public ResponseEntity<Usuario> busquedaUsuarioByid(@PathVariable("idUsuario") int idUsuario) {
		Optional<Usuario> usuarioOp = usuarioServicio.findById(idUsuario);
		if (usuarioOp.isPresent()) {
			return ResponseEntity.ok(usuarioOp.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	// Busqueda de usuario x nombre - FUNCIONA
	@RequestMapping(value = "/nombre/{nombreUsuario}")
	public ResponseEntity<Usuario> busquedaXNombre(@PathVariable("nombreUsuario") String nombreUsuario) {
		Optional<Usuario> usuarioOp = usuarioServicio.findByNombreUsuario(nombreUsuario);
		if (usuarioOp.isPresent()) {
			return ResponseEntity.ok(usuarioOp.get());
		} else {
			return ResponseEntity.noContent().build();

		}

	}

	// Eliminar un usuario x id - FUNCIONA
	@DeleteMapping(value = "/eliminar/{idUsuario}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("idUsuario") int idUsuario) {
		usuarioServicio.deleteById(idUsuario);
		return new ResponseEntity<>(null, HttpStatus.OK);

	}

}
