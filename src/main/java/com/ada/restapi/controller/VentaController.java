package com.ada.restapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ada.restapi.form.DetalleForm;
import com.ada.restapi.form.VentaForm;
import com.ada.restapi.model.Detalle;
import com.ada.restapi.model.Producto;
import com.ada.restapi.model.Venta;
import com.ada.restapi.service.DetalleServicio;
import com.ada.restapi.service.ProductoServicio;
import com.ada.restapi.service.VentaServicio;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(path = "/venta/")
public class VentaController {

	@Autowired
	ProductoServicio productoServicio;
	@Autowired
	DetalleServicio detalleServicio;
	@Autowired
	VentaServicio ventaServicio;

	@GetMapping(path = "/listado")
	public ResponseEntity<List<Venta>> listaVenta() {
		Iterable<Venta> venta = ventaServicio.findAll();
		List<Venta> listadoVenta = Lists.newArrayList(venta);
		return new ResponseEntity<>(listadoVenta, HttpStatus.OK);
	}

	@PostMapping(path = "/alta") // No funciona detalle .

	public ResponseEntity<Venta> guardarVenta(@RequestBody DetalleForm detalleForm) {

		Venta venta = new Venta();
		Detalle detalle = new Detalle();
		Producto idProducto;
		int cantidadProdu = 0;
		Set<Detalle> detalleVenta = new HashSet<Detalle>();
		for (Detalle de : detalleVenta) {

			idProducto = de.getIdProducto();
			cantidadProdu = de.getCantidad();

			Optional<Producto> productoOp = productoServicio.findById(detalleForm.getIdProducto());
			if (Optional.empty().equals(productoOp)) {
				System.out.println("No hay producto disponible");
			}
			if (productoServicio.hayStock(detalleForm)) {
				idProducto = productoOp.get();

				venta = ventaServicio.cargarVenta(detalleForm);
				detalle.setIdVenta(venta);
				detalle.setIdProducto(idProducto);
				detalle.setCantidad(cantidadProdu);
				detalle.setPrecio(detalleForm.getPrecio());
				detalleServicio.ActualizarStock(detalleForm);

				
				detalleVenta.add(detalle);

				ventaServicio.importeTotal(venta);

				ventaServicio.save(venta); // se guarda en la base

				return ResponseEntity.ok(venta);

			} else {
				System.out.println("No se encontro stock");
			}

			
		}
		return ResponseEntity.noContent().build();
	}
}