import java.util.*;

/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car extends Vehicle
{
    // variables
    private String bodyType;
    private int noOfDoors;
    private int noOfSeats;
    
    public Car()
    {
        //call super class constructor
        super();
    }

    public String getBodyType()
    {
        return bodyType;
    }
    
    public int getDoors()
    {
        return noOfDoors;
    }
    
    public int getSeats()
    {
        return noOfSeats;
    }
    
    @Override
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        
        if (scanner.hasNext())
        {
            this.bodyType = scanner.next();
        }
        
        if(scanner.hasNextInt())
        {
            this.noOfDoors = scanner.nextInt();
        }
        
        if(scanner.hasNextInt())
        {
            this.noOfSeats = scanner.nextInt();
        }
    }
    
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Body type:  " + bodyType);
        System.out.println("No. of doors:  " + noOfDoors);
        System.out.println("No. of seats:   " + noOfSeats);
    }
}
