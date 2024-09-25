package Polymorphism.Vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Vehicle> vehiclesList = new ArrayList<>();

        String[] carData = scan.nextLine().split("\\s+");
        String[] truckData = scan.nextLine().split("\\s+");
        String[] busData = scan.nextLine().split("\\s+");
        int commandsCount = Integer.parseInt(scan.nextLine());

        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]),Double.parseDouble(truckData[3]));
        Bus bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]),Double.parseDouble(busData[3]));
        vehiclesList.add(car);
        vehiclesList.add(truck);
        vehiclesList.add(bus);

        int command = 1;
        while (command <= commandsCount) {
            String[] tokens = scan.nextLine().split("\\s+");
            String commandType = tokens[0];
            String vehicle = tokens[1];

            if (commandType.contains("Drive")) {
                double distance = Double.parseDouble(tokens[2]);
                switch (vehicle) {
                    case "Polymorphism.Vehicles.Car":
                        car.drive(distance);
                        break;
                    case "Polymorphism.Vehicles.Truck":
                        truck.drive(distance);
                        break;
                    case "Polymorphism.Vehicles.Bus":
                        if ("Drive".equals(commandType)) {
                            bus.drive(distance);
                        } else {
                            bus.driveEmpty(distance);
                        }
                        break;
                }
            } else if ("Refuel".equals(commandType)) {
                double gas = Double.parseDouble(tokens[2]);
                switch (vehicle) {
                    case "Polymorphism.Vehicles.Car":
                        car.refuel(gas);
                        break;
                    case "Polymorphism.Vehicles.Truck":
                        truck.refuel(gas);
                        break;
                    case "Polymorphism.Vehicles.Bus":
                        bus.refuel(gas);
                        break;
                }
            }
            command++;
        }

        for (Vehicle vehicle : vehiclesList) {
            System.out.print(vehicle.toString());
        }

    }
}