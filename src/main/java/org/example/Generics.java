package org.example;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private int vehicleID;

    public Vehicle(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID='" + vehicleID + '\'' +
                '}';
    }
}
class Car extends Vehicle {
    private String carModel;

    public Car(int vehicleID, String carModel) {
        super(vehicleID);
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public String toString() {
        return "Car {" +
                "carModel='" + carModel + '\'' +
                '}';
    }
}
public class Generics {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>(List.of(new Vehicle(10), new Vehicle(11), new Vehicle(45), new Car(12, "G-Wagon")));
        System.out.println("Upper bound: ");
        displayUpperBound(vehicleList);
        System.out.println();
        System.out.println("Lower bound: ");
        displayLowerBound(vehicleList);
        System.out.println();
    }
    public static void displayUpperBound(List<? extends Vehicle> list) {
        // this list can contain only objects that extends Vehicle or Vehicle objects.
        for (Vehicle element : list) {
            System.out.println(element);
        }
    }
    public static void displayLowerBound(List<? super Car> list) {
        // this list can contain only Parent objects Car type or Car type objects.
        for (Object element : list) {
            System.out.println(element);
        }
    }
}
