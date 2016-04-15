package com.ritwik.tp.designpatterns.behavioral.observer;

public class CurrentWeather implements IObserver, IDisplayElement {

	private float temp;
	private ISubject subject;

	public CurrentWeather(ISubject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current Temp: " + this.temp);
	}

	@Override
	public void update(float temp) {
		this.temp = temp;
		display();
	}
	
	public void stopUpdate() {
		subject.removeObserver(this);
	}

}
