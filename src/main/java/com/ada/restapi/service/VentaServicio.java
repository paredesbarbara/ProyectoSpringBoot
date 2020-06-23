package com.ada.restapi.service;

import java.util.Date;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.form.DetalleForm;
import com.ada.restapi.model.Cliente;
import com.ada.restapi.model.Detalle;
import com.ada.restapi.model.Usuario;
import com.ada.restapi.model.Venta;
import com.ada.restapi.repository.ClienteRepositorio;
import com.ada.restapi.repository.ProductoRepositorio;
import com.ada.restapi.repository.UsuarioRepositorio;
import com.ada.restapi.repository.VentaRepositorio;

@Service
@Transactional
public class VentaServicio {

	@Autowired
	VentaRepositorio ventaRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	ClienteRepositorio clienteRepositorio;

	public Iterable<Venta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Float importeTotal(Venta venta) {
		float importeTotal = 0;
		Detalle detalle = new Detalle();
		importeTotal = detalle.getPrecio() * detalle.getCantidad();
		return importeTotal;
	}

	public void save(Venta venta) {
		ventaRepositorio.save(venta);
	}

	public Venta cargarVenta(DetalleForm detalleForm) {
		Venta venta = new Venta();
		Optional<Usuario> usuarioOp = usuarioRepositorio.findById(detalleForm.getIdUsuario());
		if (Optional.empty().equals(usuarioOp)) {
			System.out.println("no hay usuario");
		}
		Usuario idUsuario = usuarioOp.get();

		Optional<Cliente> clienteOp = clienteRepositorio.findById(detalleForm.getIdCliente());
		if (Optional.empty().equals(clienteOp)) {
			System.out.println("no hay cliente");
		}

		Cliente idCliente = clienteOp.get();

		venta.setIdUsuario(idUsuario);
		venta.setIdCliente(idCliente);
		Date date = new Date();
		venta.setFecha(date);
		return venta;

	}
}
//	public Detalle cargarDetalle(DetalleForm detalleForm ) {
//		Detalle detalle = new Detalle();
//		Set<Detalle> detalleVenta = new HashSet<Detalle>();
//		for(Detalle detallev: detalleVenta)
//		
//			detalle.setCantidad(detalleForm.getCantidad());
//			detalle.setPrecio(detalleForm.getPrecio());
//			detalleVenta.add(detalle);
//
//		
//		return detalle;
//
//	}
//}