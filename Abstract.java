// Product Interfaces
interface Bike {
    void showBike();
}

interface Car {
    void showCar();
}

// Sports Products
class SportsBike implements Bike {
    public void showBike() {
        System.out.println("Sports Bike Created");
    }
}

class SportsCar implements Car {
    public void showCar() {
        System.out.println("Sports Car Created");
    }
}

// Abstract Factory
interface VehicleFactory {
    Bike createBike();
    Car createCar();
}

// Concrete Factory
class SportsFactory implements VehicleFactory {

    public Bike createBike() {
        return new SportsBike();
    }

    public Car createCar() {
        return new SportsCar();
    }
}

// Main Class
public class Abstract {

    public static void main(String[] args) {

        VehicleFactory factory = new SportsFactory();

        Bike bike = factory.createBike();
        Car car = factory.createCar();

        bike.showBike();
        car.showCar();
    }
}