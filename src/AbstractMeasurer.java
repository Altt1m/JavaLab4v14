public abstract class AbstractMeasurer
{
    protected String name;
    protected String unit;
    protected String lowerLimit, upperLimit;
    protected double inaccuracy;
    protected String status;

    public abstract void measure();

    protected abstract void setValues();

    protected abstract void getListing();
}
