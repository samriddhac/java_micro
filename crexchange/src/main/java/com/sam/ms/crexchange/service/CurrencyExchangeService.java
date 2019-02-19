package com.sam.ms.crexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.ms.crexchange.beans.ExchangeValue;
import com.sam.ms.crexchange.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	public ExchangeValue retrieveExchangeValue(String from, String to) {
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}
}
