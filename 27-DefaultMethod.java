interface Vehicle {

    // Default method
    default void service() {
        System.out.println("General vehicle servicing");
    }

    // Abstract method
    void fuelType();
}

class Car implements Vehicle {

    @Override
    public void fuelType() {
        System.out.println("Car uses Petrol or Diesel");
    }
}

class ElectricCar implements Vehicle {

    // Overriding default method
    @Override
    public void service() {
        System.out.println("Electric car battery check and software update");
    }

    @Override
    public void fuelType() {
        System.out.println("Electric car uses Electricity");
    }
}

public class DefaultMethodDemo {

    public static void main(String[] args) {

        Vehicle car = new Car();
        car.service();
        car.fuelType();

        System.out.println();

        Vehicle eCar = new ElectricCar();
        eCar.service();
        eCar.fuelType();
    }
}