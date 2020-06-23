package com.ada.restapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompra;
	private String proveedor;
	private Date fechaYHora;
	
	@ManyToOne
	@JoinColumn (name = "idProducto")
	Producto idProducto;
	
	@ManyToOne
	@JoinColumn (name = "idProveedor")
	Proveedor idProveedor;
	
	
	public Compra (int idCompra,String proveedor, Date fechaYHora) {
		this.idCompra = idCompra;
		this.proveedor = proveedor;
		this.fechaYHora = fechaYHora;

	}
	
	
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(Date fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public Producto getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	
}
