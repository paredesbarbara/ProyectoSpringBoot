package com.ada.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.model.Cliente;
import com.ada.restapi.repository.ClienteRepositorio;

@Service
@Transactional
public class ClienteServicio {

	@Autowired
	ClienteRepositorio clienteRepositorio;

	public List<Cliente> findAll() {
		List<Cliente> listadoCliente = (List<Cliente>) clienteRepositorio.findAll();
		return listadoCliente;
	}

	public Optional<Cliente> findById(int idCliente) {
		return clienteRepositorio.findById(idCliente);
	}

	public Optional<Cliente> findByNombre(String nombre) {
		return clienteRepositorio.findByNombre(nombre);
	}

	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepositorio.save(cliente);
	}

	public void deleteById(int idCliente) {
		// TODO Auto-generated method stub
		clienteRepositorio.deleteById(idCliente);
	}

}
