package com.sam.ms.crexchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sam.ms.crexchange.beans.ExchangeValue;
import com.sam.ms.crexchange.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveCurrencyExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		ExchangeValue response = 
				currencyExchangeService.retrieveExchangeValue(from, to);
		response.setPort(Long.parseLong(env.getProperty("local.server.port")));
		return response;
	}
}
