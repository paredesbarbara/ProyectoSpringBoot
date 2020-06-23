package com.ada.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.restapi.model.Compra;
import com.ada.restapi.repository.CompraRepositorio;
@Service
@Transactional
public class CompraServicio {

	@Autowired
	CompraRepositorio compraRepositorio;
	public List<Compra> findAll() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraRepositorio.findAll();
	}

}
