public interface ITemperature extends IMeasurement
{
    String CELSIUS = "°C";
    String FAHRENHEIT = "°F";

    void switchUnit();
    void sound();
}
