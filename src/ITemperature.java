public interface ITemperature extends IMeasurement
{
    // Одиниці вимірювання температури як зручні константи
    String CELSIUS = "°C";
    String FAHRENHEIT = "°F";

    void switchUnit(); // Метод для локальної зміни CELSIUS на FAHRENHEIT та навпаки. (границі теж)
    void sound(); // Метод для повідомлення про завершення вимірювання
}
