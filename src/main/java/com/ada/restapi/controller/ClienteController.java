package com.ada.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ada.restapi.model.Cliente;
import com.ada.restapi.service.ClienteServicio;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	ClienteServicio clienteServicio;

//Listado de clientes - FUNCIONA
	@GetMapping(path = "/listado")
	public ResponseEntity<List<Cliente>> getCliente() {
		List<Cliente> listadoCliente = (List<Cliente>) clienteServicio.findAll();
		return ResponseEntity.ok(listadoCliente);
	}

//  Buscar cliente x id - FUNCIONA
	@RequestMapping(value = "/id/{idCliente}")
	public ResponseEntity<Cliente> getClienteByid(@PathVariable("idCliente") int idCliente) {
		Optional<Cliente> optionalCliente = clienteServicio.findById(idCliente);
		if (optionalCliente.isPresent()) {
			return ResponseEntity.ok(optionalCliente.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	// Buscar cliente x nombre - FUNCIONA
	@RequestMapping(value = "/nombre/{nombre}")
	public ResponseEntity<Cliente> getClienteBynombre(@PathVariable("nombre") String nombre) {
		Optional<Cliente> clienteOp = clienteServicio.findByNombre(nombre);
		if (clienteOp.isPresent()) {
			return ResponseEntity.ok(clienteOp.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// dar de alta usuario - FUNCIONA
	@PostMapping(path = "/alta")
	ResponseEntity<Cliente> altaCliente(@RequestBody Cliente cliente) {
		Cliente optionalClienteNuevo = clienteServicio.save(cliente);
		return ResponseEntity.ok(optionalClienteNuevo);
	}

//	//Eliminar o actualizar el usuario - REVISAR
	@PutMapping(value = "/modificar/{idCliente}")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
		Optional<Cliente> optionalCliente = clienteServicio.findById(cliente.getIdCliente());

		if (optionalCliente.isPresent()) {
			Cliente updateCliente = optionalCliente.get();
			updateCliente.setNombre(cliente.getNombre());
			clienteServicio.save(updateCliente);
			return ResponseEntity.ok(updateCliente);

		} else {
			return ResponseEntity.notFound().build();

		}

	}

	// Metodo para eliminar usuario por el id - FUNCIONA
	@DeleteMapping(value = "/eliminar/{idCliente}")
	public String deleteClienteByid(@PathVariable("idCliente") int idCliente) {
		clienteServicio.deleteById(idCliente);
		return "El cliente ha sido eliminado";

	}
}
