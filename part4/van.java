import java.util.*;
/**
 * Write a description of class Van here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Van extends Commercial
{
    // variables
    private int loadVolume;
    private boolean slidingSideDoor;

    public Van()
    {
        super(); //superclass constructor
    }

    public int getVolume()
    {
        return loadVolume;
    }
    
    public boolean getSlidingDoor()
    {
        return slidingSideDoor;
    }
    
    @Override
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        
        if(scanner.hasNextInt())
        {
            this.loadVolume = scanner.nextInt();
        }
        
        if(scanner.hasNext())
        {
            String doorStr = scanner.next();
            this.slidingSideDoor = doorStr.equalsIgnoreCase("Yes");
        }
       
    }
    
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Load volume:    " + loadVolume);
        System.out.println("Sliding Side Door:  " + slidingSideDoor);
    }
}
