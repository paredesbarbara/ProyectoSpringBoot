package com.ada.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.restapi.model.Compra;
import com.ada.restapi.service.CompraServicio;


@RestController
@RequestMapping(path = "/compra")
public class CompraController {

	@Autowired
	CompraServicio compraServicio;
	

	// Listado de compras - FUNCIONA
	@GetMapping(path = "/listado")
	public ResponseEntity<List<Compra>> getCompra() {
		List<Compra> listaCompra = (List<Compra>) compraServicio.findAll();
		return ResponseEntity.ok(listaCompra);
	}




}
