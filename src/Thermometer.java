import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Thermometer extends Measurer
{
    private double length;
    private double width;
    private double height;
    private static String thermalUnit = "°C";
    private static ArrayList<Thermometer> objects = new ArrayList<>();

    public Thermometer() { }

    public Thermometer(String name, String unit, String lowerLimit, String upperLimit,
                       double inaccuracy, String status, double length, double width, double height)
    {
        super(name, unit, lowerLimit, upperLimit, inaccuracy, status);
        this.length = length;
        this.width = width;
        this.height = height;
        System.out.println(MessageFormat.format("Thermometer \"{0}\" successfully created.", this.name));

        objects.add(this);
    }

    @Override
    protected void setValues()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFill the thermometer's fields, please.");
        System.out.print("Name: "); this.name = scanner.nextLine();
        System.out.println("Thermal unit: " + thermalUnit);
        System.out.print("Lower limit: "); this.lowerLimit = scanner.nextLine();
        System.out.print("Upper limit: "); this.upperLimit = scanner.nextLine();
        System.out.print("Inaccuracy: "); this.inaccuracy = Double.parseDouble(scanner.nextLine());
        System.out.print("Length: "); this.length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: "); this.width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: "); this.height = Double.parseDouble(scanner.nextLine());
        System.out.print("Status: "); this.status = scanner.nextLine();
        System.out.println(MessageFormat.format("Thermometer \"{0}\" successfully created.", this.name));
        objects.add(this);
    }

    @Override
    public void getListing()
    {
        System.out.println("\nName: " + name);
        System.out.println("Thermal unit: " + thermalUnit);
        System.out.println("Lower limit: " + String.format("%.1f", Double.parseDouble(lowerLimit)) + thermalUnit);
        System.out.println("Upper limit: " + String.format("%.1f", Double.parseDouble(upperLimit)) + thermalUnit);
        System.out.println("Inaccuracy: " + inaccuracy + "%");
        System.out.println("Status: " + status);
        System.out.println("Length: " + length + " cm");
        System.out.println("Width: " + width + " cm");
        System.out.println("Height: " + height + " cm");
    }

    public static void calibrate() throws InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nStart calibration? y/n "); String answer = scan.nextLine();
        if (answer.equals("y"))
        {
            for (int i = 0; i < 3; i++) {
                try
                {
                    System.out.print("Calibrating."); Thread.sleep(400);
                    System.out.print("."); Thread.sleep(400);
                    System.out.print("."); Thread.sleep(400);
                    System.out.println();
                }
                catch (InterruptedException e)
                {
                    // Обробка винятку, якщо потік був перерваний (interrupt())
                    e.printStackTrace();
                }

            }
            for (int i = 0; i < objects.size(); i++)
            {
                double tempLower = Double.parseDouble(objects.get(i).lowerLimit);
                double tempUpper = Double.parseDouble(objects.get(i).upperLimit);
                objects.get(i).lowerLimit = Double.toString(Math.floor(tempLower));
                objects.get(i).upperLimit = Double.toString(Math.floor(tempUpper));
            }
            System.out.println("Success!");
        }

    }

    @Override
    public void measure()
    {
        double units = new Random().nextDouble(Double.parseDouble(lowerLimit), Double.parseDouble(upperLimit));
        System.out.println(MessageFormat.format("\nThermometer \"{0}\" has {1} {2} shown on it.", this.name,
                                                                        String.format("%.1f", units), thermalUnit));
    }

    public static void switchThermalUnit()
    {
        if (thermalUnit.equals("°C"))
        {
            thermalUnit = "°F";
            for (int i = 0; i < objects.size(); i++)
            {
                double tempLower = Double.parseDouble(objects.get(i).lowerLimit);
                double tempUpper = Double.parseDouble(objects.get(i).upperLimit);
                objects.get(i).lowerLimit = Double.toString(tempLower * 1.8 + 32);
                objects.get(i).upperLimit = Double.toString(tempUpper * 1.8 + 32);
            }
        }
        else
        {
            thermalUnit = "°C";
            for (int i = 0; i < objects.size(); i++)
            {
                double tempLower = Double.parseDouble(objects.get(i).lowerLimit);
                double tempUpper = Double.parseDouble(objects.get(i).upperLimit);
                objects.get(i).lowerLimit = Double.toString((tempLower - 32) / 1.8);
                objects.get(i).upperLimit = Double.toString((tempUpper - 32) / 1.8);
            }
        }
        System.out.println("\nThermal unit was switched to " + thermalUnit + ".");
    }

    // Getters and Setters
    public void setLength(double length)
    {
        System.out.println(MessageFormat.format("Length of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.name, this.length, length));
        this.length = length;
    }

    public double getLength()
    {
        return this.length;
    }

    public void setWidth(double width)
    {
        System.out.println(MessageFormat.format("Width of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.width, this.width, width));
        this.width = width;
    }

    public double getWidth()
    {
        return this.width;
    }

    public void setHeight(double height)
    {
        System.out.println(MessageFormat.format("Height of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.height, this.height, height));
        this.height = height;
    }

    public double getHeight()
    {
        return this.height;
    }

}
