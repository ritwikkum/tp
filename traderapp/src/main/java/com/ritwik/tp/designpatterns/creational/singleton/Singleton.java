package com.ritwik.tp.designpatterns.creational.singleton;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
	}

	/**
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}


	public void doSomething() {
		System.out.println("Method of a Singleton Class");
	}

}
