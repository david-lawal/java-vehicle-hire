import java.util.ArrayList;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * Reservation System for handling vehicle data.
 */
public class ReservationSystem {
    // Variables
    private ArrayList<Vehicle> vehicleList;

    /**
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem() {
        vehicleList = new ArrayList<>();
    }

    public void storeVehicle(Vehicle newVehicle) {
        vehicleList.add(newVehicle);
    }

    public void printAllVehicles() {
        for (Vehicle vehicle : vehicleList) {
            vehicle.printDetails();
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
                vehicleList.add(vehicle);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
