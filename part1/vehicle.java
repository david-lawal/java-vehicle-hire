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

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String newGroup, String newID, String newNo, String newMake)
    {
        group = newGroup;
        vehID = newID;
        regNo = newNo;
        make = newMake;
    }
    
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
            
            //close scanner
            scanner2.close();
        }
    }
    
    public void printDetails()
    {
        System.out.println("Group: " + group + "    Vehicle ID: " + vehID + "   Reg No: " + regNo +  "  Make: " + make);
    }
}
