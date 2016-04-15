package com.ritwik.tp.designpatterns.behavioral.strategy;

public class FlyWithWings implements IFlyBehaviour {
	
	@Override
	public void fly() {
		System.out.println("Flying with wings");
	}

}
