package Polymorphism.Vehicles;

public class Truck extends Vehicle {
    private static final double AC_CONSUMPTION = 1.6;
    private static final double GAS_CORRECTION = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption +  AC_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double gas) {
        if (gas <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if ((gas * GAS_CORRECTION) + getFuelQuantity() > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        }  else {
            this.setFuelQuantity(getFuelQuantity() + (gas * GAS_CORRECTION));
        }
    }
}
