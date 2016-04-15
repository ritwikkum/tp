package com.ritwik.tp.designpatterns.creational.factory;

public class Product1 implements IProduct {

	private static final String KEY = "Product1";

	private Product1() {
	}

	static {
		Factory.getInstance().registerProduct(KEY, new Product1());
	}

	public static String getKey() {
		return KEY;
	}

	@Override
	public IProduct createProduct() {
		return new Product1();
	}

	@Override
	public void doSomething() {
		System.out.println(KEY);
	}

	

}
