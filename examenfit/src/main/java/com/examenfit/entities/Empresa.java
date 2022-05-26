package com.examenfit.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name = "Empresa")
@JacksonXmlRootElement(localName = "Empresa")
public class Empresa {

	@Id
	@JacksonXmlProperty(localName = "NroContrato")
	private Integer nroContrato;
	
	@JacksonXmlProperty(localName = "CUIT")
	private String cuit;
	
	@JacksonXmlProperty(localName = "Denominacion")
	private String denominacion;
	
	@JacksonXmlProperty(localName = "Domicilio")
	private String domicilio;
	
	@JacksonXmlProperty(localName = "CodigoPostal")
	private Integer codigoPostal;
	
	@JacksonXmlProperty(localName = "FechaDesdeNov")
	private LocalDateTime fechaDesdeNov;
	
	@JacksonXmlProperty(localName = "FechaHastaNov")
	private LocalDateTime fechaHastaNov;
	
	@JacksonXmlProperty(localName = "Organizador")
	private String organizador;
	
	@JacksonXmlProperty(localName = "Productor")
	private String productor;
	
	@JacksonXmlProperty(localName = "CIIU")
	private String ciiu;
	
	@JacksonXmlProperty(localName = "Movimientos")
	private List<Movimiento> movimientos = new ArrayList<>();

	
	
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Integer getNroContrato() {
		return nroContrato;
	}

	public void setNroContrato(Integer nroContrato) {
		this.nroContrato = nroContrato;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public LocalDateTime getFechaDesdeNov() {
		return fechaDesdeNov;
	}

	public void setFechaDesdeNov(LocalDateTime fechaDesdeNov) {
		this.fechaDesdeNov = fechaDesdeNov;
	}

	public LocalDateTime getFechaHastaNov() {
		return fechaHastaNov;
	}

	public void setFechaHastaNov(LocalDateTime fechaHastaNov) {
		this.fechaHastaNov = fechaHastaNov;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getCiiu() {
		return ciiu;
	}

	public void setCiiu(String ciiu) {
		this.ciiu = ciiu;
	}
	
		
	
}
