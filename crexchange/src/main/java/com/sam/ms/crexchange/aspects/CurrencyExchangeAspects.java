package com.sam.ms.crexchange.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class CurrencyExchangeAspects {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("com.sam.ms.crexchange.aspects.CommonJointPointConfig.buLayerExecution()")
	public void beforeBuExecution(JoinPoint jointPoint) {
		logger.info("Intercepted Method Calls {} ", jointPoint);
	}
	
	@Before("com.sam.ms.crexchange.aspects.CommonJointPointConfig.dataLayerExecution()")
	public void beforeDataExecution(JoinPoint jointPoint) {
		logger.info("Intercepted Method Calls {} ", jointPoint);
	}
	
	@AfterReturning(value="com.sam.ms.crexchange.aspects.CommonJointPointConfig.buLayerExecution()", returning="result")
	public void afterBuExecution(JoinPoint jointPoint, Object result) {
		logger.info("Intercepted Method Calls {} value {} ", jointPoint, result);
	}
	
	@AfterReturning(value="com.sam.ms.crexchange.aspects.CommonJointPointConfig.dataLayerExecution()", returning="result")
	public void afterDataExecution(JoinPoint jointPoint, Object result) {
		logger.info("Intercepted Method Calls {} value {} ", jointPoint, result);
	}
	
}
