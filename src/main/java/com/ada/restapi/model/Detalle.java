package com.ada.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class

public class Detalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idDetalle;
	private int cantidad;
	private float precio;

	@ManyToOne
	@JoinColumn(name = "idVenta")
	Venta idVenta;

	@ManyToOne
	@JoinColumn(name = "idProducto")
	Producto idProducto;

	public Detalle(int idDetalle, Venta idVenta, Producto idProducto, int cantidad, float precio) {
		this.idDetalle = idDetalle;
		this.idVenta = idVenta;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;

	}

	public Detalle() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Venta getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Venta idVenta) {
		this.idVenta = idVenta;
	}

	public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setProducto(int idProdu) {
		// TODO Auto-generated method stub

	}

}
