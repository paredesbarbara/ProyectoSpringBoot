package com.ada.restapi.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.form.DetalleForm;
import com.ada.restapi.model.Detalle;
import com.ada.restapi.model.Producto;
import com.ada.restapi.repository.DetalleRepositorio;
import com.ada.restapi.repository.ProductoRepositorio;

@Service
@Transactional
public class DetalleServicio {
	@Autowired
	DetalleRepositorio detalleRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;

	public void save(Set<Detalle> detalleVenta) {
		// TODO Auto-generated method stub
		detalleRepositorio.save(detalleVenta);
	}

	public void ActualizarStock(DetalleForm detalleForm) {//REVISAR
		// TODO Auto-generated method stub

		int stock = detalleForm.getStock();
		int cantidad = detalleForm.getCantidad();
		int idProducto = detalleForm.getIdProducto();

		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		producto.setStock(stock - cantidad);
		productoRepositorio.save(producto);

	}
}
