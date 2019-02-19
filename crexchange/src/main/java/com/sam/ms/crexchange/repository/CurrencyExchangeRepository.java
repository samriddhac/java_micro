package com.sam.ms.crexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.ms.crexchange.beans.ExchangeValue;

public interface CurrencyExchangeRepository 
	extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findByFromAndTo(String from, String to);
}
