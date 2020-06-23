package com.ada.restapi.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.form.DetalleForm;
import com.ada.restapi.form.ProduForm;
import com.ada.restapi.model.Producto;
import com.ada.restapi.repository.ProductoRepositorio;
import com.ada.restapi.repository.ProveedorRepositorio;

@Service
@Transactional
public class ProductoServicio {
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	ProveedorRepositorio proveedorRepositorio;

	Logger log = Logger.getLogger(ProductoRepositorio.class.getName());

	public void save(ProduForm produForm) {

	}

	public boolean hayStock(DetalleForm detalleForm ) {
		// TODO Auto-generated method stub
Optional<Producto> productoOp = productoRepositorio.findById(detalleForm.getIdProducto());
			Producto producto = productoOp.get();
			int stock = producto.getStock();
		if (stock == 0) {
			System.out.println("No hay stock de este producto.");
			return false;
			
		} else {

			return true;
		}
	}
	
	
	
	

	public Optional<Producto> findById(int idProducto) {
		// TODO Auto-generated method stub
		return productoRepositorio.findById(idProducto);
	}

	
//	public Producto updateProducto(ProduForm produForm, Producto productoUpdate) {
//		Optional<Proveedor> proveedorOp = proveedorRepositorio.findById(produForm.getIdProveedor());
//		
//		if (proveedorOp.isPresent()) {
//
//			Proveedor proveedor = proveedorOp.get();
//
//			productoUpdate.setIdProveedor(proveedor);
//			productoUpdate.setCodigo(produForm.getCodigo());
//			productoUpdate.setNombre(produForm.getNombre());
//			productoUpdate.setCategoria(produForm.getCategoria());
//			productoUpdate.setPrecio(produForm.getPrecio());
//			productoUpdate.setMedida(produForm.getMedida());
//			productoUpdate.setStock(produForm.getStock());
//
//			productoRepositorio.save(producto);
//			}
//		return producto;
//	}

	public void save(Producto producto) {
		// TODO Auto-generated method stub
		productoRepositorio.save(producto);
	}

	public void deleteById(int idProducto) {
		// TODO Auto-generated method stub
		productoRepositorio.deleteById(idProducto);
	}

	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoRepositorio.findAll();
	}

	public Optional<Producto> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return productoRepositorio.findByNombre(nombre);
	}

	public Optional<Producto> findByCodigo(String codigo) {
		return productoRepositorio.findByCodigo(codigo);
	}

}
