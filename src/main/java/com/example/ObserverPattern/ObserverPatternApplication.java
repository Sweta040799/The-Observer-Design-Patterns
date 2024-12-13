package com.example.ObserverPattern;

import com.example.ObserverPattern.displays.CurrentConditionDisplay;
import com.example.ObserverPattern.displays.ForecastDisplay;
import com.example.ObserverPattern.displays.WeatherData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverPatternApplication implements CommandLineRunner {

	private final WeatherData weatherData;
	private final CurrentConditionDisplay currentConditionDisplay;
	private final ForecastDisplay forecastDisplay;

	public ObserverPatternApplication(WeatherData weatherData, CurrentConditionDisplay currentConditionDisplay, ForecastDisplay forecastDisplay) {
		this.weatherData = weatherData;
		this.currentConditionDisplay = currentConditionDisplay;
		this.forecastDisplay = forecastDisplay;
	}

	public static void main(String[] args) {
		SpringApplication.run(ObserverPatternApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		weatherData.registerObserver(currentConditionDisplay);
		weatherData.registerObserver(forecastDisplay);

		new Thread(() -> {
			try {
				weatherData.setMeasurements(80f, 65f, 30.4f);
				Thread.sleep(2000);
				weatherData.setMeasurements(65f, 23f, 12.33f);
				Thread.sleep(2000);
				weatherData.removeObserver(currentConditionDisplay);
				Thread.sleep(2000);
				weatherData.setMeasurements(55f, 13f, 14.33f);
				Thread.sleep(2000);
				weatherData.registerObserver(forecastDisplay);
				Thread.sleep(2000);
				weatherData.setMeasurements(75f, 33f, 22.33f);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.err.println("Thread interrupted: " + e.getMessage());
			}
		}).start();



	}
}
