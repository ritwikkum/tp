package com.ritwik.tp.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.Collection;

public class WeatherData implements ISubject {

	private final Collection<IObserver> DATA = new ArrayList<IObserver>();
	private float temp;
	
	public WeatherData(float temp) {
		this.temp = temp;
	}

	public void registerObserver(IObserver observer) {
		DATA.add(observer);
	}

	public void removeObserver(IObserver observer) {
		DATA.remove(observer);
	}

	public void notifyObservers() {
		for (IObserver observer : DATA) {
			observer.update(this.temp);
		}
	}

	public void tempChanged(float newTemp) {
		this.temp = newTemp;
		notifyObservers();
	}

}
