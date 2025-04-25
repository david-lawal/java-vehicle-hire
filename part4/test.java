import java.io.*;

public class Test
{

    public Test() 
    {
        ReservationSystem resSystem = new ReservationSystem();     
    }

    public void TestOne(ReservationSystem resSystem)
    {
        resSystem.readVehicleData();
        resSystem.printAllVehicles();
    }
}
