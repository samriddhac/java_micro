package com.sam.ms.limit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.ms.limit.bean.Configuration;
import com.sam.ms.limit.bean.LimitServiceConfiguration;

@RestController
public class LimitServiceController {
	
	@Autowired
	private Configuration config;

	@GetMapping("/limit-service")
	public LimitServiceConfiguration retriveConfig() {
		return new LimitServiceConfiguration(config.getMin(), config.getMax());
	}
}
