package observer;

import java.util.ArrayList;

public class WeatherData implements Subject{

    ArrayList<Observer> observers;
    int temperature;
    int humidity;
    int pressure;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(int temperature, int humidity, int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
