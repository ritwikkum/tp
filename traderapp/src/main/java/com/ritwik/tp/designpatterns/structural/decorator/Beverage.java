package com.ritwik.tp.designpatterns.structural.decorator;

public abstract class Beverage {

	public abstract String getDescription();

	public abstract int cost();

	public void printCost() {
		System.out.println(getDescription() + " : " + cost());
	}
}
