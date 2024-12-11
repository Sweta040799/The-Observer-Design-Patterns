package com.example.ObserverPattern;

import com.example.ObserverPattern.displays.CurrentConditionDisplay;
import com.example.ObserverPattern.displays.WeatherData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverPatternApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ObserverPatternApplication.class, args);
		WeatherData weatherData = new WeatherData();

		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

		weatherData.setMeasurements(80f, 65f, 30.4f);
		weatherData.setMeasurements(65f, 23f, 12.33f);

		weatherData.removeObserver(currentConditionDisplay);

		weatherData.setMeasurements(55f, 13f, 14.33f);

		weatherData.registerObserver(currentConditionDisplay);

		weatherData.setMeasurements(75f, 33f, 22.33f);
	}

}
