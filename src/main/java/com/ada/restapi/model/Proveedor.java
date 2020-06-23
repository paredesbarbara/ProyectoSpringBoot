package com.ada.restapi.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	private String nombreProveedor;
	private String apellidoProveedor;
	private String nombreEmpresa;
	private String cuilEmpresa;
	private String emailEmpresa;
	private String telefonoEmpresa;
	private String direccionEmpresa;
	private String ciudad;
	private String provincia;
	private String pais;
	private String observacion;

	public Proveedor() {

	}

	public Proveedor(int idProveedor, String nombreProveedor, String apellidoProveedor, String nombreEmpresa,
			String cuilEmpresa, String emailEmpresa, String telefonoEmpresa, String direccionEmpresa, String ciudad,
			String provincia, String pais, String observacion) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.apellidoProveedor = apellidoProveedor;
		this.nombreEmpresa = nombreEmpresa;
		this.cuilEmpresa = cuilEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		this.observacion = observacion;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProvedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getApellidoProveedor() {
		return apellidoProveedor;
	}

	public void setApellidoProveedor(String apellidoProveedor) {
		this.apellidoProveedor = apellidoProveedor;
	}

	public String getCuilEmpresa() {
		return cuilEmpresa;
	}

	public void setCuilEmpresa(String cuilEmpresa) {
		this.cuilEmpresa = cuilEmpresa;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
