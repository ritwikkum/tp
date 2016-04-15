package com.ritwik.tp.designpatterns.behavioral.observer;

public interface ISubject {

	void registerObserver(IObserver observer);

	void removeObserver(IObserver observer);

	void notifyObservers();

}
