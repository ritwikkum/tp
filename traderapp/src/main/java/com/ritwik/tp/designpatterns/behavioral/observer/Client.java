package com.ritwik.tp.designpatterns.behavioral.observer;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final WeatherData weather = new WeatherData(1);
		weather.tempChanged(2);

		final CurrentWeather curWeather = new CurrentWeather(weather);
		weather.tempChanged(3);
		weather.tempChanged(4);

		curWeather.stopUpdate();
		weather.tempChanged(5);
	}

}
