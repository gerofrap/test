package com.examenfit.entities;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table(name = "Movimiento")
@JacksonXmlRootElement(localName = "Movimiento")
public class Movimiento {
	
	@Id	
	@JacksonXmlProperty(localName = "NroContrato")
	private Integer nroContrato;
	
	@JacksonXmlProperty(localName = "SaldoCtaCte")
	private Double saldoCtaCte;
	
	@JacksonXmlProperty(localName = "Tipo")
	private String tipo;
	
	@JacksonXmlProperty(localName = "CodigoMovimiento")
	private String codigoMovimiento;
	
	@JacksonXmlProperty(localName = "Concepto")
	private String concepto;
	
	@JacksonXmlProperty(localName = "Importe")
	private Double importe;

	
	@Override
	public String toString() {
		return "[nroContrato = " + nroContrato +
				" | saldo = " + saldoCtaCte + 
				" | tipo = " + tipo + 
				" | codMov = " + codigoMovimiento + 
				" | concepto = " + concepto + 
				" | importe = " + importe + "]";
	}
	
	
	public Integer getNroContrato() {
		return nroContrato;
	}
	public void setNroContrato(Integer nroContrato) {
		this.nroContrato = nroContrato;
	}
	public Double getSaldoCtaCte() {
		return saldoCtaCte;
	}
	public void setSaldoCtaCte(Double saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoMovimiento() {
		return codigoMovimiento;
	}
	public void setCodigoMovimiento(String codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	

	
	
	
	
	
	
	

	
}
