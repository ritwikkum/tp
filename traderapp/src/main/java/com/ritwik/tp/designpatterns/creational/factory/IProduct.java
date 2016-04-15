package com.ritwik.tp.designpatterns.creational.factory;

public interface IProduct {
	
	/**
	 * 
	 * @return
	 */
	IProduct createProduct();
	
	/**
	 * 
	 */
	void doSomething();
}
