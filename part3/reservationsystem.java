import java.util.*;
import java.awt.*;
import java.io.*;

/**
 * Reservation System for handling vehicle data.
 */
public class ReservationSystem {
    // Variables
    private Map<String, Vehicle> vehicleMap;
    private Map<String, Customer> customerMap;

    /**
     * 
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem() {
        vehicleMap = new LinkedHashMap<>();
        customerMap = new LinkedHashMap<>();
    }

    public void storeCustomer(Customer newCustomer)
    {
        customerMap.put(newCustomer.getID(), newCustomer);
    }
    
    public void storeVehicle(Vehicle newVehicle) {
        vehicleMap.put(newVehicle.getID(), newVehicle);
    }

    public void printAllCustomers()
    {
        for (Customer customer : customerMap.values())
        {
            customer.printDetails();
        }
    }
    
    public void printAllVehicles() {
        for (Vehicle vehicle : vehicleMap.values()) {
            vehicle.printDetails();
        }
    }
    
    public void writeCustomerData()
    {
        FileDialog fileDialog = new FileDialog((Frame) null, "Save Customer Data", FileDialog.SAVE);
        fileDialog.setVisible(true);
        
        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();
        
        if (fileName == null || directory == null) {
            System.out.println("No file selected.");
            return;
        }
        
        File file = new File(directory, fileName);
        
        try(PrintWriter writer = new PrintWriter(file))
        {
            for (Customer customer : customerMap.values())
            {
                writer.println(customer.getID() + ", " + customer.getSurname() + ", " + customer.getFirstName() + ", " + customer.getOtherInitials() + ", " + customer.getTitle());
            }
        }
        catch (IOException e)
        {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public void readCustomerData()
    {
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        
        //Get file
        String fileName = fileBox.getFile();
        String directory = fileBox.getDirectory();
        
        //Check if a file was selected
        if (fileName == null || directory == null)
        {
            System.out.println("No file selected.");
            return;
        }
        
        File file = new File(directory, fileName);
        
        //----------------------debug--------------------------
        System.out.println("Reading file: " + fileName);
        
        //print content
        try(Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine())
            {
                //ignore blanks and comments
                String lineOfText = scanner.nextLine().trim();
                if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                {
                    continue;
                }
                
                //create customer object
                Customer customer = new Customer();
                
                //pass scanner to readData() method
                Scanner lineScanner = new Scanner(lineOfText);
                customer.readData(lineScanner);
                
               
                
                lineScanner.close();
                
                //store object
                 customerMap.put(customer.getID(), customer);
            }
            
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: File not found.");
        }
    }

    public void readVehicleData() {
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);

        // Get file
        String fileName = fileBox.getFile();
        String directory = fileBox.getDirectory();

        // Check if a file was selected
        if (fileName == null || directory == null) {
            System.out.println("No file selected.");
            return;
        }

        File file = new File(directory, fileName);

        System.out.println("Reading file: " + fileName);

        // To store the type of vehicle
        String typeOfData = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                // Read line and trim whitespace
                String lineOfText = scanner.nextLine().trim();

                // Ignore blank lines and comments
                if (lineOfText.isEmpty() || lineOfText.startsWith("//")) {
                    continue;
                }

                // Detect the type of vehicle
                if (lineOfText.startsWith("[Car data]")) 
                {
                    typeOfData = "Car";
                    continue;
                } 
                else if (lineOfText.startsWith("[van data]")) 
                { 
                    typeOfData = "Van";
                    continue;
                } 
                else if (lineOfText.startsWith("[Truck data]")) 
                {
                    typeOfData = "Truck";
                    continue;
                }

                // Read vehicle data
                Scanner lineScanner = new Scanner(lineOfText);
                Vehicle vehicle = null;

                // Create the appropriate vehicle subclass object
                switch (typeOfData) {
                    case "Car":
                        vehicle = new Car();
                        break;
                    case "Van":
                        vehicle = new Van();
                        break;
                    case "Truck":
                        vehicle = new Truck();
                        break;
                    default:
                        System.out.println("Unknown vehicle type.");
                        continue; // Skip unknown data
                }

                vehicle.readData(lineScanner);
                vehicleMap.put(vehicle.getID(), vehicle);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        
    }
    
    public Customer getCustomer(String customerID)
    {
        for (Customer customer : customerMap.values())
        {
            if (customer.getID().equals(customerID))
            {
                return customer;
            }         
        }
        return null; //if the id is not found
    }
    
    public Vehicle getVehicle(String vehicleID)
    {
        for (Vehicle vehicle : vehicleMap.values())
        {
            if (vehicle.getID().equals(vehicleID))
            {
                return vehicle;
            }
        }
        return null; //if the id is not found
    }
}
