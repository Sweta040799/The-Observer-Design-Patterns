package com.example.ObserverPattern.displays;

import com.example.ObserverPattern.model.DisplayElement;
import com.example.ObserverPattern.model.Observer;
import org.springframework.stereotype.Component;

@Component
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;


    @Override
    public void display() {
        System.out.println("The current forecast: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
