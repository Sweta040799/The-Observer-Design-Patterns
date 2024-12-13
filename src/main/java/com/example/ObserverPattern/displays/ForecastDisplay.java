package com.example.ObserverPattern.displays;

import com.example.ObserverPattern.model.DisplayElement;
import com.example.ObserverPattern.model.Observer;
import org.springframework.stereotype.Component;

@Component
public class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure;
    private float currentPressure = 29.92f;

    @Override
    public void display() {
        if(currentPressure > lastPressure) {
            System.out.println("Forecast: Improving weather on the way!");
        } else if(currentPressure < lastPressure) {
            System.out.println("Forecast: Watch out for cooler, rainy weather.");
        } else {
            System.out.println("Forecast: More of the same.");
        }
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
}
