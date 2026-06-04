interface Vehicle
{
    void drive();
}
class Bus implements Vehicle
{
    public void drive()
    {
        System.out.println("Bus is driving");
    }
}
class Car implements Vehicle
{
    public void drive()
    {
        System.out.println("Car is driving");
    }
}
interface VehicleFactory
{
    void createBus();
    void createCar();
}
class LandVehicle implements VehicleFactory 
{
    public Vehicle createBus()
    {
         return new Bus();
    }
    public Vehicle createCar()
    {
       return new Car();   
    }
}
public class Abstract
{
    public static void main(String[] args) 
    {
        LandVehicle landVehicle = new LandVehicle();
        Vehicle bus = landVehicle.createBus();
        bus.drive();
        Vehicle car = landVehicle.createCar();
        car.drive();
    }
}