import java.util.*;
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer extends ReservationSystem
{
    // variables
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String surname, String firstName, String otherInitials, String title, String prefix, int length)
    {
        this.customerID = "unknown"; 
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    //no parameter constructor
    public Customer()
    {
        this.customerID = "unknown";
    }
    
    public String getID()
    {
        return customerID;
    }
    
    public String getSurname()
    {
        return surname;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getOtherInitials()
    {
        return otherInitials;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String generateCustomerID(String prefix, int length)
    {
        Random random = new Random();
        int min = (int) Math.pow(10, length - 1); //minimum number for the id
        int max = (int) Math.pow(10, length) - 1; //maximum number for the id
        
        //random number
        int randomNum = random.nextInt(max - min + 1) + min;
        
        //create id
        return prefix + randomNum;
    }
    
    public void readData(Scanner lineScanner)
{
    if (lineScanner.hasNext())
    {
        String line = lineScanner.nextLine().trim();
        if (line.isEmpty() || line.startsWith("//"))
        {
            return;
        }
        
        // Second scanner to analyze the line
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*,\\s*");

        if (scanner.hasNext()) {
            this.customerID = scanner.next();
        }
        
        // If the customer ID is "unknown", generate a new one
        if (this.customerID.equalsIgnoreCase("unknown")) {
            this.customerID = generateCustomerID("C", 5); // Prefix "C" and 5-digit ID
        }

        if (scanner.hasNext()) this.surname = scanner.next();
        if (scanner.hasNext()) this.firstName = scanner.next();
        if (scanner.hasNext()) this.otherInitials = scanner.next();
        if (scanner.hasNext()) this.title = scanner.next();

        scanner.close();
    }
}

    
    public void printDetails()
    {
        System.out.println("Customer id:    " + customerID);
        System.out.println("Customer:   " + title + " " + firstName + " " + otherInitials + " " + surname); 
    }
}
