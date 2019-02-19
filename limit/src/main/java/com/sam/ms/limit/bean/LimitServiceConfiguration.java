package com.sam.ms.limit.bean;


public class LimitServiceConfiguration {

	private int min;
	private int max;
	
	public LimitServiceConfiguration() {
		
	}

	public LimitServiceConfiguration(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "LimitServiceConfiguration [min=" + min + ", max=" + max + "]";
	}
	
	
}
