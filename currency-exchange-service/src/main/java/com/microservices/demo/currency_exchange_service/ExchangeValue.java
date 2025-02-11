package com.microservices.demo.currency_exchange_service;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Exchange_Value")
public class ExchangeValue {
	@Id  
	@Column(name="id")  
	private Long id;  
	@Column(name="currency_from")  
	private String from;  
	@Column(name="currency_to")  
	private String to;  
	@Column(name="conversion_multiple")  
	private BigDecimal conversionMultiple;  
	@Column(name="port")  
	private int port;    
	
	//getter and setter for port
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ExchangeValue() {
	}

	//generating constructor using fields  
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	//getters  
	public Long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
}