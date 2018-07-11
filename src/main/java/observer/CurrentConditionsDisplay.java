package observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{

    int temperature;
    int humidity;
    int pressure;
    Subject weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Temperature is " + temperature + ", humidity is " + humidity + ", pressure is " + pressure);
    }
}
