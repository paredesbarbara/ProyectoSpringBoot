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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ada.restapi.model.Proveedor;
import com.ada.restapi.service.ProveedorServicio;

@Controller
@RequestMapping(path = "/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorServicio proveedorServicio;

	// dar de alta un producto- FUNCIONA
	@PostMapping(path = "/alta")
	ResponseEntity<Proveedor> altaProveedor(@RequestBody Proveedor proveedor) {
		Proveedor proveedorNuevo = proveedorServicio.save(proveedor);
		return ResponseEntity.ok(proveedorNuevo);
	}

	// Listado de proveedores - FUNCIONA
	@GetMapping(path = "/listado")
	public ResponseEntity<List<Proveedor>> getProveedor() {
		List<Proveedor> listaProveedor = (List<Proveedor>) proveedorServicio.findAll();
		return ResponseEntity.ok(listaProveedor);
	}

	// Buscar proveedor x id - FUNCIONA
	@RequestMapping(path = "/id/{idProveedor}")
	public ResponseEntity<Proveedor> getProveedorByid(@PathVariable("idProveedor") int idProveedor) {
		Optional<Proveedor> proveedorOp = proveedorServicio.findById(idProveedor);
		if (proveedorOp.isPresent()) {
			return ResponseEntity.ok(proveedorOp.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	// Buscar proveedor x nombre de empresa - FUNCIONA
	@RequestMapping(path = "/nombre/{nombreEmpresa}")
	public ResponseEntity<Proveedor> getProveedorByNombreEmpresa(@PathVariable("nombreEmpresa") String nombreEmpresa) {
		Optional<Proveedor> proveedorOp = proveedorServicio.findByNombreEmpresa(nombreEmpresa);
		if (proveedorOp.isPresent()) {
			return ResponseEntity.ok(proveedorOp.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	// Eliminar proveedor por el id - FUNCIONA
	@DeleteMapping(path = "/eliminar/{IdProveedor}")
	public String deleteProveedorByid(@PathVariable("IdProveedor") int idProveedor) {
		proveedorServicio.deleteById(idProveedor);
		return "El proveedor ha sido eliminado";

	}
}

//	// Actualizar datos del proveedor - NO FUNCIONA
//	@PutMapping(path = "/modificar/{idProveedor}")
//	public ResponseEntity<Proveedor> actualizarProveedor(@RequestBody Proveedor proveedor, int idProveedor) {
//		
//		Optional<Proveedor> proveedorOp = proveedorServicio.findById(idProveedor);
//		idProveedor = proveedor.getIdProveedor();
//		if (proveedorOp.isPresent()) {
//
//			proveedor = proveedorOp.get();
//			proveedor.setNombreProveedor(proveedor.getNombreProvedor());
//			proveedor.setApellidoProveedor(proveedor.getApellidoProveedor());
//			proveedor.setNombreEmpresa(proveedor.getNombreEmpresa());
//			proveedor.setCuilEmpresa(proveedor.getCuilEmpresa());
//			proveedor.setEmailEmpresa(proveedor.getEmailEmpresa());
//			proveedor.setTelefonoEmpresa(proveedor.getTelefonoEmpresa());
//			proveedor.setDireccionEmpresa(proveedor.getDireccionEmpresa());
//			proveedor.setCiudad(proveedor.getCiudad());
//			proveedor.setProvincia(proveedor.getProvincia());
//			proveedor.setPais(proveedor.getPais());
//			proveedor.setObservacion(proveedor.getObservacion());
//
//		 proveedorServicio.save(proveedor);
//
//			return new ResponseEntity<>(proveedor, HttpStatus.OK);
//
//		} else {
//			return ResponseEntity.notFound().build();
//
//		}
//	}
//}
