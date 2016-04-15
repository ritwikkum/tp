package com.ritwik.tp.designpatterns.creational.singleton;

public class Client {


	public static void main(String[] args) {
		final Singleton obj1 = Singleton.getInstance();
		final Singleton obj2 = Singleton.getInstance();
		System.out.println(obj1 == obj2);
		obj1.doSomething();
	}

}
