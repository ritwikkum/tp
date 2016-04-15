package com.ritwik.tp.designpatterns.structural.decorator;

public class Milk extends Beverage {
	
	private Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return this.beverage.getDescription() +", Milk";
	}
	
	@Override
	public int cost() {
		return this.beverage.cost() + 2;
	}

}
