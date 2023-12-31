import java.security.cert.CertPathBuilderSpi;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.text.MessageFormat;
public class Measurer extends AbstractMeasurer implements IMeasurement
{
    public Measurer(String name, String lowerLimit,
                            String upperLimit, double inaccuracy, String status)
    {
        this.name = name;
        this.unit = chooseUnit();
        System.out.println("Unit " + this.unit + " has been chosen.");
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.inaccuracy = inaccuracy;
        this.status = status;
        System.out.println(MessageFormat.format("Measurer \"{0}\" successfully created.", this.name));
    }

    public Measurer()
    {
        setValues();
    }

    @Override // Віртуальний метод
    public void measure()
    {
        double units = new Random().nextDouble(Double.parseDouble(lowerLimit), Double.parseDouble(upperLimit));
        System.out.println(MessageFormat.format("Measurer \"{0}\" has {1} {2} shown on it.", this.name, units, this.unit));
    }

    @Override
    protected void setValues()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nType measurer's fields, please.");
        System.out.print("Name: "); this.name = scanner.nextLine();
        System.out.print("Measuring unit: "); this.unit = scanner.nextLine();
        System.out.print("Lower limit: "); this.lowerLimit = scanner.nextLine();
        System.out.print("Upper limit: "); this.upperLimit = scanner.nextLine();
        System.out.print("Inaccuracy: "); this.inaccuracy = Double.parseDouble(scanner.nextLine());
        System.out.print("Status: "); this.status = scanner.nextLine();
        System.out.println(MessageFormat.format("Measurer \"{0}\" successfully created.", this.name));
    }

    @Override
    public void getListing()
    {
        System.out.println("Name: " + name);
        System.out.println("Measuring unit: " + unit);
        System.out.println("Lower limit: " + lowerLimit + unit);
        System.out.println("Upper limit: " + upperLimit + unit);
        System.out.println("Inaccuracy: " + inaccuracy + "%");
        System.out.println("Status: " + status);
    }

    @Override
    public void update()
    {
        System.out.println(MessageFormat.format("Measurer \"{0}\" successfully reset.", this.name));
        this.value = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nType measurer's fields again, please.");
        System.out.print("Name: "); this.name = scanner.nextLine();
        this.unit = chooseUnit();
        System.out.print("Measuring unit: " + this.unit);
        System.out.print("Lower limit: "); this.lowerLimit = scanner.nextLine();
        System.out.print("Upper limit: "); this.upperLimit = scanner.nextLine();
        System.out.print("Inaccuracy: "); this.inaccuracy = Double.parseDouble(scanner.nextLine());
        System.out.print("Status: "); this.status = scanner.nextLine();
        System.out.println(MessageFormat.format("Measurer \"{0}\" successfully updated.", this.name));
    }

    @Override
    protected String chooseUnit()
    {
        String respond;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your unit m(1) m²(2) m³(3): ");
        respond = scanner.nextLine();
        if (respond.equals("1"))
        {
            return METRE;
        }
        else if (respond.equals("2"))
        {
            return SQUARE_METRE;
        }
        else
        {
            return CUBIC_METRE;
        }
    }

    // Getters and Setters
    public void setName(String name)
    {
        System.out.println(MessageFormat.format("Name of \"{0}\" was changed to \"{1}\".", this.name, name));
        this.name = name;

    }

    public String getName()
    {
        return name;
    }

    public void setUnit(String unit)
    {
        System.out.println(MessageFormat.format("Unit of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.name, this.unit, unit));
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setLowerLimit(String lowerLimit)
    {
        System.out.println(MessageFormat.format("Lower limit of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.name, this.lowerLimit, lowerLimit));
        this.lowerLimit = lowerLimit;
    }

    public String getLowerLimit()
    {
        return lowerLimit;
    }

    public void setUpperLimit(String upperLimit)
    {
        System.out.println(MessageFormat.format("Upper limt of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.name, this.upperLimit, upperLimit));
        this.upperLimit = upperLimit;
    }

    public String getUpperLimit()
    {
        return upperLimit;
    }

    public void setInaccuracy(double inaccuracy)
    {
        System.out.println(MessageFormat.format("Inaccuracy of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.name, this.inaccuracy, inaccuracy));
        this.inaccuracy = inaccuracy;
    }

    public double getInaccuracy()
    {
        return inaccuracy;
    }

    // методи, що керують станом приладу.
    public void setStatus(String status)
    {
        System.out.println(MessageFormat.format("Status of \"{0}\" was changed from \"{1}\" to \"{2}\".",
                this.name, this.status, status));
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public String getValue()
    {
        return String.format("%.1f " + this.unit, value);
    }
}