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
import com.ada.restapi.form.ProduForm;

import com.ada.restapi.model.Producto;
import com.ada.restapi.model.Proveedor;
import com.ada.restapi.service.ProductoServicio;
import com.ada.restapi.service.ProveedorServicio;

@Controller
@RequestMapping(path = "/producto/")
public class ProductoController {

	@Autowired
	ProductoServicio productoServicio;
	@Autowired
	ProveedorServicio proveedorServicio;

	// Listado de producto- FUNCIONA
	@GetMapping(path = "/listado")
	public ResponseEntity<List<Producto>> getProducto() {
		List<Producto> listadoProducto = (List<Producto>) productoServicio.findAll();
		return ResponseEntity.ok(listadoProducto);
	}

	// dar de alta un producto- FUNCIONA
	@PostMapping(path = "/alta")
	public ResponseEntity<Producto> guardarProducto(@RequestBody ProduForm produForm) {
		Optional<Proveedor> proveedorOp = proveedorServicio.findById(produForm.getIdProveedor());

		Producto producto = new Producto();
		if (proveedorOp.isPresent()) {

			Proveedor proveedor = new Proveedor();
			proveedor = proveedorOp.get();

			produForm.setIdProveedor(produForm.getIdProveedor());

			producto.setIdProveedor(proveedor);
			producto.setCodigo(produForm.getCodigo());
			producto.setNombre(produForm.getNombre());
			producto.setCategoria(produForm.getCategoria());
			producto.setPrecio(produForm.getPrecio());
			producto.setMedida(produForm.getMedida());
			producto.setStock(produForm.getStock());

			productoServicio.save(producto);
			return new ResponseEntity<>(producto, HttpStatus.CREATED);

		} else {

		}
		return ResponseEntity.noContent().build();

	}

	// Busqueda de productos x id - FUNCIONA
	@RequestMapping(value = "/id/{idProducto}")
	public ResponseEntity<Producto> busquedaProductoByid(@PathVariable("idProducto") int idProducto) {
		Optional<Producto> optionalProducto = productoServicio.findById(idProducto);
		if (optionalProducto.isPresent()) {
			return ResponseEntity.ok(optionalProducto.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	// Busqueda de productos x codigo - FUNCIONA
	@RequestMapping(value = "/codigo/{codigo}")
	public ResponseEntity<Producto> busquedaXCodigo(@PathVariable("codigo") String codigo) {
		Optional<Producto> productoOp = productoServicio.findByCodigo(codigo);
		if (productoOp.isPresent()) {
			return ResponseEntity.ok(productoOp.get());
		} else {
			return ResponseEntity.noContent().build();

		}
	}

	// Busqueda de productos x nombre - FUNCIONA
	@RequestMapping(value = "/nombre/{nombre}")
	public ResponseEntity<Producto> busquedaXNombre(@PathVariable("nombre") String nombre) {
		Optional<Producto> productoOp = productoServicio.findByNombre(nombre);
		if (productoOp.isPresent()) {
			return ResponseEntity.ok(productoOp.get());
		} else {
			return ResponseEntity.noContent().build();

		}

	}

//	// Modificar un producto por id -REVISAR
//	@PutMapping(path = "/producto/modificar/{idProducto}")
//	public ResponseEntity<Producto> modificarProducto(@RequestBody ProduForm produForm) {
//		Optional<Producto> productoOp = productoServicio.findById(produForm.getIdProducto());
//		if (productoOp.isPresent()) {
//		Producto producto = productoOp.get();
//			 
//	//	Proveedor proveedor = new Proveedor();
//		producto.setIdProveedor(proveedor);
//		producto.setCodigo(produForm.getCodigo());
//		producto.setNombre(produForm.getNombre());
//		producto.setCategoria(produForm.getCategoria());
//		producto.setPrecio(produForm.getPrecio());
//		producto.setMedida(produForm.getMedida());
//		producto.setStock(produForm.getStock());
//
//		productoServicio.save(producto);
//		
//		//producto = productoServicio.updateProducto(produForm, producto);
//		productoServicio.save(producto);
//		return new ResponseEntity<>(producto, HttpStatus.CREATED);
//	}
//				return ResponseEntity.notFound().build();
//	}		
	// Optional<Proveedor> proveedor =
	// proveedorServicio.findById(produForm.getIdProveedor());

	// Eliminar un producto por id - FUNCIONA
	@DeleteMapping(value = "/eliminar/{idProducto}")
	public ResponseEntity<Producto> eliminarProducto(@PathVariable("idProducto") int idProducto) {
		productoServicio.deleteById(idProducto);
		return new ResponseEntity<>(null, HttpStatus.OK);

	}

}
