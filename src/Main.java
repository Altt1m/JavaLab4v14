// AC-221 Melnyk Viacheslav
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Measurer measurer = new Measurer("Gas1", "0.000", "99999.000",
                0.5, "Working");
        measurer.measure();
        System.out.println();

        Thermometer thermo1 = new Thermometer("Thermo1", "34.3", "43.1",
                                            0.1, "Off", 18, 1.7, 0.8);

        thermo1.getListing();
        thermo1.update();
        thermo1.getListing();
        System.out.println();

        thermo1.measure();
        System.out.println(thermo1.getValue());

        thermo1.switchUnit();
        thermo1.getListing();
        System.out.println(thermo1.getValue());

    }

}