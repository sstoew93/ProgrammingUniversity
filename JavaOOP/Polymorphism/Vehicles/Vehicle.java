package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");
        if (distance * this.fuelConsumption > getFuelQuantity()) {
            System.out.printf("%s needs refueling%n", getClass().getSimpleName());
        } else {
            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), df.format(distance));
            setFuelQuantity(getFuelQuantity() - ( distance * this.fuelConsumption ));
        }
    }

    public void refuel(double gas) {
        if (gas <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if ((gas + getFuelQuantity()) > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        }  else {
            setFuelQuantity(getFuelQuantity() + gas);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f%n", getClass().getSimpleName(), getFuelQuantity());
    }
}