package com.sam.ms.crconvert.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sam.ms.crconvert.beans.ExchangeValue;
import com.sam.ms.crconvert.proxy.CurrencyExchangeProxy;

@RestController
public class ConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeValue retrieveConversion(@PathVariable String from,
			@PathVariable String to,
			@PathVariable String quantity) {
		ExchangeValue response = proxy.retriveCurrencyExchangeValue(from, to);
		Double total = Double.parseDouble(quantity) * response.getExchangeRate().doubleValue();
		response.setTotal(BigDecimal.valueOf(total));
		
		return response;
	}
}
