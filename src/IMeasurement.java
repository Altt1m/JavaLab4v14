public interface IMeasurement
{
    // Одиниці вимірювання як зручні константи
    String METRE = "m";
    String SQUARE_METRE = "m²";
    String CUBIC_METRE = "m³";

    void measure(); // Метод для знаття показників
    void update(); // Метод для повторного вводу даних
}
