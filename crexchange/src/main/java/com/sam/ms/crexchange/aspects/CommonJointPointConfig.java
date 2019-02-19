package com.sam.ms.crexchange.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJointPointConfig {

	@Pointcut("execution(* com.sam.ms.crexchange.service.*.*(..))")
	public void buLayerExecution(){}
	@Pointcut("execution(* com.sam.ms.crexchange.repository.*.*(..))")
	public void dataLayerExecution(){}
}
