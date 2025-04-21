
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
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
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        customerID = "unknown"; 
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    //no parameter constructor
    public Customer()
    {
    
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
}
