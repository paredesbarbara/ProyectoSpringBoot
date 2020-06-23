package com.ada.restapi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	private Date fechaYHora;
	private float importeTotal;

	@ManyToOne
	@JoinColumn(name = "idMedioDePago")
	MedioDePago idMedioDePago;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	Usuario idUsuario;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	Cliente idCliente;

	public Set<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(Set<Detalle> detalle) {
		this.detalle = detalle;
	}

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "idVenta")
	private Set<Detalle> detalle = new HashSet<Detalle>();

	public Venta(int idVenta, Date fechaYHora, float importeTotal) {
		this.idVenta = idVenta;
		this.fechaYHora = fechaYHora;
		this.importeTotal = importeTotal;
	}

	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fechaYHora;
	}

	public void setFecha(Date fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public float getImporte() {
		return importeTotal;
	}

	public void setImporte(float importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

}
