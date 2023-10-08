public abstract class AbstractMeasurer
{
    protected String name;
    protected String unit;
    protected String lowerLimit, upperLimit;
    protected double inaccuracy;
    protected String status;
    protected boolean isWorking;

    protected abstract void setValues();

    protected abstract void getListing();
}
