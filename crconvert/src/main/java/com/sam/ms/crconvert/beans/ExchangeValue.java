package com.sam.ms.crconvert.beans;

import java.math.BigDecimal;


public class ExchangeValue {

	private Long id;
	private String from;
	private String to;
	private BigDecimal exchangeRate;
	private Long port;
	private BigDecimal total;
		
	public ExchangeValue() {
		super();
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal exchangeRate, Long port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.port = port;
	}

	public ExchangeValue(Long id, String from, String to, BigDecimal exchangeRate, Long port, BigDecimal total) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exchangeRate = exchangeRate;
		this.port = port;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", exchangeRate=" + exchangeRate
				+ ", port=" + port + ", total=" + total + "]";
	}
	
}
