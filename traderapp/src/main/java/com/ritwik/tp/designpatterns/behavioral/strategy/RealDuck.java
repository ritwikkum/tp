package com.ritwik.tp.designpatterns.behavioral.strategy;

public class RealDuck extends AbstractDuck {

	public RealDuck() {
		this.flyBehaviour = new FlyWithWings();
	}

	@Override
	public void describe() {
		System.out.println("Real Duck with bones and muscles");
	}

}
