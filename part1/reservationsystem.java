import java.util.ArrayList;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class ReservationSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReservationSystem
{
    //variables 
    private ArrayList<Vehicle> vehicleList;
    
    /**
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem()
    {
        vehicleList = new ArrayList<Vehicle>();
    }
    
    public void storeVehicle(Vehicle newvehicle)
    {
        vehicleList.add(newvehicle);
    }

    public void printAllVehicles()
    {
        for (int i = 0; i < vehicleList.size(); i++)
        {
            //print out all vehicles
            vehicleList.get(i).printDetails();
        }
    }
    
    public void readVehicleData()
    {
        FileDialog fileBox = new FileDialog((Frame) null, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        
        //get file
        String fileName = fileBox.getFile();
        String directory = fileBox.getDirectory();
        
        //output file name
        System.out.println(fileName);
        
        //read and print file content
        File file = new File(directory, fileName);
        
        try (Scanner scanner = new Scanner(file))
        {
        
            while (scanner.hasNextLine())
            {
                //ignores blanks and comments
                String lineOfText = scanner.nextLine().trim();
                if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                {
                    continue;
                }
                
                //create vehicle object
                Vehicle vehicle = new Vehicle();
                
                //pass scanner to readData() method
                Scanner lineScanner = new Scanner(lineOfText);
                vehicle.readData(lineScanner);
                lineScanner.close();
                
                //store vehicle
                Vehicle storedVehicle = new Vehicle(vehicle.getGroup(), vehicle.getID(), vehicle.getNo(), vehicle.getMake());
                vehicleList.add(storedVehicle);
            }
            
            scanner.close();
            
        } 
        catch (FileNotFoundException e)
        {
            System.err.println("Error: File not found.");
        }
    }
}
