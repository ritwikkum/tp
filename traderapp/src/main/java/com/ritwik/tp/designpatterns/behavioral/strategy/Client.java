package com.ritwik.tp.designpatterns.behavioral.strategy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final RealDuck duck = new RealDuck();
		duck.describe();
		duck.performFly();
	}

}
