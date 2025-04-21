import java.io.*;

public class Test
{

    public Test() 
    {
        ReservationSystem resSystem = new ReservationSystem();     
    }

    public void stepOneTest(ReservationSystem resSystem)
    {
        //Step1
        resSystem.storeVehicle(new Vehicle("A1", "AA1", "iou*()&", "fORD"));
        resSystem.storeVehicle(new Vehicle("A2", "AA2", "iou*()&", "fORD"));
        resSystem.storeVehicle(new Vehicle("A3", "AA3", "iou*()&", "fORD"));
        
        //print vehicles
        resSystem.printAllVehicles();
    }
}
