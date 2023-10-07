// AC-221 Melnyk Viacheslav
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Measurer measurer = new Measurer("Gas1", "m3", "0.000", "99999.000",
                0.5, "Working");
        measurer.measure();
        System.out.println();

        Thermometer thermo1 = new Thermometer("Thermo1", "", "34.3", "43.1",
                                            0.1, "Off", 18, 1.7, 0.8);
        thermo1.getListing();

        Thermometer thermo2 = new Thermometer();

        thermo1.measure(); thermo2.measure();

        Thermometer.calibrate();
        thermo1.getListing();
        thermo2.getListing();

        Thermometer.switchThermalUnit();
        thermo1.getListing();
        thermo2.getListing();

        thermo1.measure(); thermo2.measure();

        Thermometer.switchThermalUnit();
        thermo1.getListing();
        thermo2.getListing();
    }



}