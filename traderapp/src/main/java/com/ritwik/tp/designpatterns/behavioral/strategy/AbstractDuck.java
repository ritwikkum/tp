package com.ritwik.tp.designpatterns.behavioral.strategy;

public abstract class AbstractDuck {

	protected IFlyBehaviour flyBehaviour;

	/**
	 * To be implemented by specific ducks
	 * 
	 * @return
	 */
	public abstract void describe();

	public void swim() {
		System.out.println("All Ducks Swim");
	}

	/**
	 * Fly based on behaviour
	 */
	public void performFly() {
		flyBehaviour.fly();
	}

}
