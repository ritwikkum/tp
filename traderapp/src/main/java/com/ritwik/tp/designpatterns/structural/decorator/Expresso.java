package com.ritwik.tp.designpatterns.structural.decorator;

public class Expresso extends Beverage {

	@Override
	public String getDescription() {
		return "Expresso";
	}

	@Override
	public int cost() {
		return 4;
	}

}
