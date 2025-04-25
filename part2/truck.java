import java.util.*;

/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck extends Commercial
{
    //variables
    private ArrayList<String> attributes;

    public Truck()
    {
        super(); //superclass constructor
        attributes = new ArrayList<>();
    }
    
    public ArrayList<String> getAttributes()
    {
        return attributes;
    }
    
    @Override
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        
        while (scanner.hasNext())
        {
            attributes.add(scanner.next());
        }
    }
    
    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Attributes  ");
        
        //output attributes
        for(int i = 0; i < attributes.size(); i++)
        {
            System.out.println(attributes.get(i));
            if (i < attributes.size() - 1)
            {
                System.out.print(", "); //adds a comma between attributes
            }
        }
    }
}
