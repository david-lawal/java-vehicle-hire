import java.util.*;
import java.io.*;

/**
 * Write a description of class VehicleReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VehicleReservation
{
    //variables
    private String reservationNo;
    private String vehID;
    private String customerID;
    private String startDate;
    private int noOfDays;
    
    /**
     * Constructor for objects of class VehicleReservation
     */
    public VehicleReservation(String reservationNo, String vehID, String customerID, String startDate, int noOfDays )
    {
        if (!DateUtil.isValidDateString(startDate))
        {
            throw new IllegalArgumentException("Invalid date format. Use dd-MM-yyyy.");
        }
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerID = customerID;
        this.startDate = startDate;
        this.noOfDays = noOfDays;
    }
    
    public VehicleReservation()
    {
        
    }

    public String getReservationNo()
    {
        return reservationNo;
    }
    
    public String getVehID()
    {
        return vehID;
    }
    
    public String getCustomerID()
    {
        return customerID;
    }
    
    public String getStartDate()
    {
        return startDate;
    }
    
    public int getNoOfDays()
    {
        return noOfDays;
    }
    
    public void setReservationNo(String reservationNo)
    {
        this.reservationNo = reservationNo;
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
            this.reservationNo = scanner.next();
        }

        if (scanner.hasNext()) this.vehID = scanner.next();
        if (scanner.hasNext()) this.customerID = scanner.next();
        if (scanner.hasNext()) this.startDate = scanner.next();
        if (scanner.hasNextInt()) this.noOfDays = scanner.nextInt();

        scanner.close();
    }
    }
    
    public void writeData(PrintWriter writer) {
    writer.println(reservationNo + ", " + vehID + ", " + customerID + ", " + startDate + ", " + noOfDays);
}

    
    public void printDetails()
    {
        System.out.println("Reservation number: " + reservationNo);
        System.out.println("Vehicle id  " + vehID);
        System.out.println("Customer id " + customerID);
        System.out.println("Start date  " + startDate);
        System.out.println("No. of days " + noOfDays);
    }
}
