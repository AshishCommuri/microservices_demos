package com.microservices.demo.limits_services.bean;

public class LimitConfiguration {
	
	private int maximum;
	private int minimum;
	
	//no-argument constructor
	public LimitConfiguration() {
	}

	//getters
	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	//constructor using fields 
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	
	

}
