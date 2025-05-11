package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    //Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByPriceRange(double min, double max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        //Loops through vehicle list
        for (Vehicle vehicle : vehicles) {

            //checking if price is between min and max
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {

                //adding to matching list
                matches.add(vehicle);
            }

        }

        return matches;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> matches = new ArrayList<>();
    }

}