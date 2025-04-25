import java.util.Scanner;
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    //variables 
    private String group;
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean airCon;
    private double engineSize;
    private String fuelType;
    private String gearbox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;
    
    public Vehicle()
    {
    
    }

    public String getGroup()
    {
        return group;
    }
    
    public String getID()
    {
        return vehID;
    }
    
    public String getNo()
    {
        return regNo;
    }
    
    public String getMake()
    {
        return make;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public boolean getAirCon()
    {
        return airCon;
    } 
    
    public double getEngineSize()
    {
        return engineSize;
    }
    
    public String getFuelType()
    {
        return fuelType;
    }
    
    public String getGearbox()
    {
        return gearbox;
    }
    
    public String getTransmission()
    {
        return transmission;
    }
    
    public int getMileage()
    {
        return mileage;
    }
    
    public String getDate()
    {
        return dateFirstRegistered;
    }
    
    public void readData(Scanner lineScanner)
    {
        if (lineScanner.hasNextLine())
        {
            String line = lineScanner.nextLine().trim();
            if (line.isEmpty() || line.startsWith("//"))
                {
                    return;
                }
            
            //second scanner to analyse the lines
            Scanner scanner2 = new Scanner(line);
            
            scanner2.useDelimiter("\\s*,\\s*");
            if (scanner2.hasNext()) this.group = scanner2.next();
            if (scanner2.hasNext()) this.vehID = scanner2.next();
            if (scanner2.hasNext()) this.regNo = scanner2.next();
            if (scanner2.hasNext()) this.make = scanner2.next();
            if (scanner2.hasNext()) this.model = scanner2.next();
            
            if (scanner2.hasNext()) {
                String airConStr = scanner2.next();
                this.airCon = airConStr.equalsIgnoreCase("Yes");
            }
            
            if (scanner2.hasNextDouble()) this.engineSize = scanner2.nextDouble();
            if (scanner2.hasNext()) this.fuelType = scanner2.next();
            if (scanner2.hasNext()) this.gearbox = scanner2.next();
            if (scanner2.hasNext()) this.transmission = scanner2.next();
            if (scanner2.hasNextInt()) this.mileage = scanner2.nextInt();
            if (scanner2.hasNext()) this.dateFirstRegistered = scanner2.next();
            
            //close scanner
            scanner2.close();
        }
    }
    
    public void printDetails()
    {
        System.out.println(model + "    Group: " + group + "    Vehicle ID: " + vehID);
        System.out.println("Air conditioning/Climate Control: " + airCon);
        System.out.println("Engine size:  " + engineSize + "    Fuel:  " + fuelType);
        System.out.println("Gearbox: " + gearbox + "    Transmission:  " + transmission);
        System.out.println("Mileage:  " + mileage + "   Date first registered:  " + dateFirstRegistered); 
    }
}
