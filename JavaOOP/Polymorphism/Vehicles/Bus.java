package Polymorphism.Vehicles;

public class Bus extends Vehicle {
    private static final double AC_ON =  1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        super.setFuelConsumption(super.getFuelConsumption() + AC_ON);
        super.drive(distance);
    }

    public void driveEmpty(double distance) {
        super.drive(distance);
    }
}