import java.util.*;
/**
 * Write a description of class Commercial here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Commercial extends Vehicle
{
    //variables
    private int payload;

    /**
     * Constructor for objects of class Commercial
     */
    public Commercial()
    {
        super();
    }
 
    public int getPayload()
    {
        return payload;
    }
    
    @Override
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
            
        if (scanner.hasNextInt())
        {
            this.payload = scanner.nextInt();
            //debugging
            System.out.println("DEBUG: Read payload -> " + payload);
        }
        
    }
    
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Payload:    " + payload + "kg");
    }
}
