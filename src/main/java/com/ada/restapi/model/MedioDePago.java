package com.ada.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class MedioDePago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idMedioDePago;
	private float efectivo;
	private float tarjetaDebito;
	public int getIdMedioDePago() {
		return idMedioDePago;
	}
	public void setIdMedioDePago(int idMedioDePago) {
		this.idMedioDePago = idMedioDePago;
	}
	public float getEfectivo() {
		return efectivo;
	}
	public void setEfectivo(float efectivo) {
		this.efectivo = efectivo;
	}
	public float getTarjetaDebito() {
		return tarjetaDebito;
	}
	public void setTarjetaDebito(float tarjetaDebito) {
		this.tarjetaDebito = tarjetaDebito;
	}
	public float getTarjetaCredito() {
		return tarjetaCredito;
	}
	public void setTarjetaCredito(float tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	public float getCuentaCorriente() {
		return cuentaCorriente;
	}
	public void setCuentaCorriente(float cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	private float tarjetaCredito;
	private float cuentaCorriente;
	
//	@ManyToOne
//	@JoinColumn (name = "idVenta")
//	Provedor idVenta;
//	
	
	
}
