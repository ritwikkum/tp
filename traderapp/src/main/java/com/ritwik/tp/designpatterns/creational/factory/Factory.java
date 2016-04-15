package com.ritwik.tp.designpatterns.creational.factory;

import java.util.HashMap;
import java.util.Map;

public class Factory {

	private static Factory instance;

	private final Map<String, IProduct> REGISTRY;

	private Factory() {
		REGISTRY = new HashMap<String, IProduct>();
	}

	/**
	 * 
	 * @return
	 */
	public static Factory getInstance() {
		if (instance == null) {
			synchronized (Factory.class) {
				if (instance == null) {
					instance = new Factory();
				}
			}
		}
		return instance;
	}

	/**
	 * 
	 * @param key
	 * @param product
	 */
	public void registerProduct(final String key, final IProduct product) {
		REGISTRY.put(key, product);
	}

	public IProduct getProduct(final String key) {
		return REGISTRY.get(key).createProduct();
	}

}
