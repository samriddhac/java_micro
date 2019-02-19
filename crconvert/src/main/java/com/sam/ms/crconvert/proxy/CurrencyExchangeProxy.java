package com.sam.ms.crconvert.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sam.ms.crconvert.beans.ExchangeValue;

//@FeignClient(name="crexchange")
@FeignClient(name="api-gateway")
@RibbonClient(name="crexchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/crexchange/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveCurrencyExchangeValue(
			@PathVariable("from") String from,
			@PathVariable("to") String to);
}
