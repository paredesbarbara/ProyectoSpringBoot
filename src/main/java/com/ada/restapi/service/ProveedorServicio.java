package com.ada.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.model.Proveedor;
import com.ada.restapi.repository.ProveedorRepositorio;

@Service
@Transactional
public class ProveedorServicio {

	@Autowired
	ProveedorRepositorio proveedorRepositorio;

	public Proveedor save(Proveedor proveedor) {
		return proveedorRepositorio.save(proveedor);
	}

	public Optional<Proveedor> findById(int idProveedor) {
		return proveedorRepositorio.findById(idProveedor);
	}

	public List<Proveedor> findAll() {
		return (List<Proveedor>) proveedorRepositorio.findAll();
	}

	public void deleteById(int idProveedor) {
		proveedorRepositorio.deleteById(idProveedor);

	}

	public Optional<Proveedor> findByNombreEmpresa(String nombreEmpresa) {
		return proveedorRepositorio.findByNombreEmpresa(nombreEmpresa);
	}

}
