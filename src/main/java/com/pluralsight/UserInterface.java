package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    //Constructor that sets up the UserInterface with given Dealership object
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }


    public void display() {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("-------------Dealership Menu-------------");
            System.out.println("1: Find vehicles within a price range.");
            System.out.println("2: Find vehicles by make / model.");
            System.out.println("3: Find vehicles by year range.");
            System.out.println("4: Find vehicles by color.");
            System.out.println("5: Find vehicles by mileage range.");
            System.out.println("6: Find vehicles by type.");
            System.out.println("7: List all vehicles.");
            System.out.println("8: Add a vehicle.");
            System.out.println("9: Remove a vehicle");
            System.out.println("99: Exit");
            System.out.print("Please select from the following: ");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest(scanner);
                    break;

                case 2:
                    processGetByMakeModelRequest(scanner);
                    break;

                case 3:
                    processGetByYearRequest(scanner);
                    break;

                case 4:
                    processGetByColorRequest(scanner);
                    break;

                case 5:
                    processGetByMileageRequest(scanner);
                    break;

                case 6:
                    processGetByVehicleTypeRequest(scanner);
                    break;

                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 8:
                    processAddVehicleRequest(scanner);
                    break;

                case 9:
                    processRemoveVehicleRequest(scanner);
                    break;

                case 99:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        }
        //Helper method to display list of vehicles
        private void displayVehicles (ArrayList <Vehicle> vehicles) {
            if (vehicles.isEmpty()){
                System.out.println("No vehicles found.");
        }else{
                //loop through each vehicle and display details
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|"
                        + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
        }
    }
    //Finds vehicles within price range
    private void processGetByPriceRequest(Scanner scanner){
            System.out.println("Enter the minimum price: ");
            double minimumPrice = scanner.nextDouble();
            System.out.println("Enter the maximum price: ");
            double maximumPrice = scanner.nextDouble();
            scanner.nextLine();

            //Gets and displays vehicles in price range
            ArrayList<Vehicle> vehicles = dealership.getVehiclesByPriceRange(minimumPrice, maximumPrice);

            displayVehicles(vehicles);
        }
        //Finds vehicles by make and model
        private void processGetByMakeModelRequest(Scanner scanner){
            System.out.println("Enter the make: ");
            String make = scanner.nextLine().trim();
            System.out.println("Enter the model: ");
            String model = scanner.nextLine().trim();



            //Gets and displays vehicles with the given make and model
            ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

            displayVehicles(vehicles);
        }
        //Finds vehicles by year range
        private void processGetByYearRequest(Scanner scanner){
            System.out.println("Enter the minimum year: ");
            int minimumYear = scanner.nextInt();
            System.out.println("Enter the maximum year: ");
            int maximumYear = scanner.nextInt();
            scanner.nextLine();

            //Gets and displays vehicles by year range
            ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minimumYear, maximumYear);

            displayVehicles(vehicles);
        }
        //Finds vehicles by color
        private void processGetByColorRequest(Scanner scanner){
            System.out.println("Enter the color: ");
            String color = scanner.nextLine().trim();

            //Gets and displays with entered color
            ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);

            displayVehicles(vehicles);
        }
        //Finds vehicles by mileage range
        private void processGetByMileageRequest(Scanner scanner){
            System.out.println("Enter the minimum mileage: ");
            int minimumMileage = scanner.nextInt();
            System.out.println("Enter the maximum mileage: ");
            int maximumMileage = scanner.nextInt();
            scanner.nextLine();

            //Gets and displays vehicles within entered mileage range
            ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(minimumMileage, maximumMileage);

            displayVehicles(vehicles);
        }
        //Finds vehicles by type
        private void processGetByVehicleTypeRequest(Scanner scanner){
            System.out.println("Enter the vehicle type: ");
            String vehicleType = scanner.nextLine().trim();

            //Gets and displays vehicles of entered type
            ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);

            displayVehicles(vehicles);
        }
        //Lists all vehicles
        private void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
        }
        //Adds a new vehicle to dealership
        private void processAddVehicleRequest(Scanner scanner){
            System.out.println("Enter the VIN: ");
            int vin = scanner.nextInt();

            System.out.println("Enter the year: ");
            int year = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Enter the make: ");
            String make = scanner.nextLine().trim();

            System.out.println("Enter the model: ");
            String model = scanner.nextLine().trim();

            System.out.println("Enter the vehicle type: ");
            String vehicleType = scanner.nextLine().trim();

            System.out.println("Enter the color: ");
            String color = scanner.nextLine().trim();

            System.out.println("Enter the odometer reading: ");
            int odometer = scanner.nextInt();

            System.out.println("Enter the price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            //Creating a new vehicle to add to dealership
            Vehicle newVehicle = new Vehicle(vin,year,make, model, vehicleType,color,odometer, price);

            dealership.addVehicle(newVehicle);

            System.out.println("Vehicle added.");

            //Saving to the file
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

        }
        //Removes a vehicles by VIN
        private void processRemoveVehicleRequest(Scanner scanner){
            System.out.println("Enter the VIN of the vehicle to remove: ");
            int vin = scanner.nextInt();
            scanner.nextLine();

        //Checking if vehicle exists
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

        boolean found = false;

        for (Vehicle vehicle : vehicles){
            if (vehicle.getVin() == vin){
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed.");
                found = true;

                //saving to file
                DealershipFileManager fileManager = new DealershipFileManager();
                fileManager.saveDealership(dealership);

                break;

            }

        }
        if (!found){
            System.out.println("No vehicle found with that VIN");
        }
        }
}
