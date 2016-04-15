package com.ritwik.tp.designpatterns.structural.decorator;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Beverage bev = new Expresso();
		bev.printCost();
		bev = new Milk(bev);
		bev.printCost();
		bev = new Chocolate(bev);
		bev.printCost();
	}

}
