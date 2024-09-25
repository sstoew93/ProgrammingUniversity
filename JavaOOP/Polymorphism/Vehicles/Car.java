package Polymorphism.Vehicles;

public class Car extends Vehicle {
    private static final Double AC_CONSUMPTION = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(fuelConsumption + AC_CONSUMPTION);
    }
}
