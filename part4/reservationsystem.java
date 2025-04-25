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
    private Map<String, VehicleReservation> vehicleReservationMap;

    //for unique reservation numbers
    private int reservationNo = 1;
    
    /**
     * 
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem() {
        vehicleMap = new LinkedHashMap<>();
        customerMap = new LinkedHashMap<>();
        vehicleReservationMap = new LinkedHashMap<>();
    }

    public void storeCustomer(Customer newCustomer)
    {
        customerMap.put(newCustomer.getID(), newCustomer);
    }
    
    public void storeVehicle(Vehicle newVehicle) {
        vehicleMap.put(newVehicle.getID(), newVehicle);
    }

    public void storeVehicleReservation(VehicleReservation vehicleReservation)
    {
        String reservationNumber = generateReservationNo();  // Generate new reservation number
        vehicleReservation.setReservationNo(reservationNumber); // Set the generated number
        vehicleReservationMap.put(reservationNumber, vehicleReservation); // Store the reservation
    }
    
    public void makeVehicleReservation(String customerID, String vehID, String startDate, int noOfDays)
    {
        //generate reservation number
        String reservationNo = generateReservationNo();
        
        //make vehicle reservation object
        VehicleReservation vehicleReservation = new VehicleReservation(reservationNo, vehID, customerID, startDate, noOfDays);
        
        //add to the list
        vehicleReservationMap.put(reservationNo, vehicleReservation);
    }
    
    public String generateReservationNo()
    {
        //assign  a reservation number
        return String.format("%04d", reservationNo++);
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
    
    public void printAllVehicleReservations()
    {
        for (VehicleReservation vehicleReservation : vehicleReservationMap.values())
        {
            vehicleReservation.printDetails();
        }
    }
    
    public void writeVehicleReservationData()
    {
        FileDialog fileDialog = new FileDialog((Frame) null, "Save Vehicle Reservation Data", FileDialog.SAVE);
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
            for (VehicleReservation vehicleReservation : vehicleReservationMap.values())
            {
                writer.println(vehicleReservation.getReservationNo() + ", " + vehicleReservation.getVehID() + ", " + vehicleReservation.getCustomerID() + ", " + vehicleReservation.getStartDate() + ", " + vehicleReservation.getNoOfDays());
            }
        }
        catch (IOException e)
        {
            System.err.println("Error writing to file: " + e.getMessage());
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
    
    public void readVehicleReservationData()
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
                VehicleReservation vehicleReservation = new VehicleReservation();
                
                //pass scanner to readData() method
                Scanner lineScanner = new Scanner(lineOfText);
                vehicleReservation.readData(lineScanner);
                
               
                
                lineScanner.close();
                
                //generate reservation number
                String reservationNo = generateReservationNo();
                
                //store object
                 vehicleReservationMap.put(reservationNo, vehicleReservation);
            }
            
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: File not found.");
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
    
    public VehicleReservation getVehicleReservation(String vehicleReservationID)
    {
        for (VehicleReservation vehicleReservation : vehicleReservationMap.values())
        {
            if (vehicleReservation.getVehID().equals(vehicleReservationID))
            {
                return vehicleReservation;
            }
        }
        return null; //if nothing is found
    }
}
