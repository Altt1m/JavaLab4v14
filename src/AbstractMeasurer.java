public abstract class AbstractMeasurer
{
    protected String name;
    protected String unit;
    protected String lowerLimit, upperLimit;
    protected double inaccuracy;
    protected String status;
    protected double value; // Вимірювана величина у юнітах

    protected abstract void setValues();

    protected abstract void getListing();

    protected abstract String chooseUnit();
}
