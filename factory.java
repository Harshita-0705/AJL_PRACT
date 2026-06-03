interface Vehicle {
    void drive();
}
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a Car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a Bike");
    }
}
class VehicleFactory {

    public Vehicle getVehicle(String type) {

        if(type.equalsIgnoreCase("Car")) {
            return new Car();
        }

        else if(type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }

        return null;
    }
}
public class factory {

    public static void main(String[] args) {

        VehicleFactory factory = new VehicleFactory();

        Vehicle v1 = factory.getVehicle("Car");
        v1.drive();

        Vehicle v2 = factory.getVehicle("Bike");
        v2.drive();
    }
}