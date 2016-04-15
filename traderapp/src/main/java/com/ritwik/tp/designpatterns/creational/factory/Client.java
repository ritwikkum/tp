package com.ritwik.tp.designpatterns.creational.factory;

public class Client {


	public static void main(String[] args) {
		final Factory fact = Factory.getInstance();
		final IProduct prod = fact.getProduct(Product1.getKey());
		System.out.println(prod.getClass());
		prod.doSomething();
	}

}
