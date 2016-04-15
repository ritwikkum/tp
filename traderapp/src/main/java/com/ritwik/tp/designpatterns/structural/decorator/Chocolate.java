package com.ritwik.tp.designpatterns.structural.decorator;

public class Chocolate extends Beverage {
	
	private Beverage beverage;

	public Chocolate(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return this.beverage.getDescription() +", Chocolate";
	}
	
	@Override
	public int cost() {
		return this.beverage.cost() + 1;
	}

}
