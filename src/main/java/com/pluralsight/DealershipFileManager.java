package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;
        String line;

        try{
    BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));

    //reads first line for dealership info
    if ((line = reader.readLine()) != null){
    String[] parts = line.split("\\|");
    String name = parts[0];
    String address = parts[1];
    String phone = parts[2];
    dealership = new Dealership(name,address, phone);
    }
    while ((line = reader.readLine())!= null){
        String[] fields = line.split("\\|");

        int vin = Integer.parseInt(fields[0]);
        int year = Integer.parseInt(fields[1]);
        String make = fields[2];
        String model = fields[3];
        String vehicleType = fields[4];
        String color = fields [5];
        int odometer = Integer.parseInt(fields[6]);
        double price = Double.parseDouble(fields[7]);

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer,price);
        dealership.addVehicle(vehicle);
    }
    reader.close();

} catch (Exception e) {
            e.printStackTrace();
        }
return dealership;
    }
    public void saveDealership(Dealership dealership){

    }
}
