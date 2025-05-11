package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    //helper method
    private void init(){
    //Get dealership data
    DealershipFileManager fileManager = new DealershipFileManager();

    this.dealership = fileManager.getDealership();

    }
    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Dealership Menu");
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
            System.out.print("Please select from the following.");


            int choice = scanner.nextInt();

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
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
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
        //Helper method
        private void displayVehicles (ArrayList <Vehicle> vehicles) {
            if (vehicles.isEmpty()){
                System.out.println("No vehicles found.");
        }else{
            for (Vehicle vehicle : vehicles) {
                System.out.println("VIN: " + vehicle.getVin());
                System.out.println("Year: " + vehicle.getYear());
                System.out.println("Make: " + vehicle.getMake());
                System.out.println("Model: " + vehicle.getModel());
                System.out.println("Type: " + vehicle.getVehicleType());
                System.out.println("Color:" + vehicle.getColor());
                System.out.println("Odometer: " + vehicle.getOdometer());
                System.out.println("Price: $" + vehicle.getPrice());
            }
        }
    }
    private void processGetByPriceRequest(Scanner scanner){
            System.out.println("Enter the minimum price: ");
            double minimumPrice = scanner.nextDouble();
            System.out.println("Enter the maximum price: ");
            double maximumPrice = scanner.nextDouble();

            ArrayList<Vehicle> vehicles = dealership.getVehiclesByPriceRange(minimumPrice, maximumPrice);

            displayVehicles(vehicles);
        }
        private void processGetByMakeModelRequest(Scanner scanner){
            System.out.println("Enter the make: ");
            String make = scanner.nextLine().trim();
            System.out.println("Enter the model: ");
            String model = scanner.nextLine().trim();

            ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

            displayVehicles(vehicles);
        }
        private void processGetByYearRequest(Scanner scanner){
            System.out.println("Enter the minimum year: ");
            int minimumYear = scanner.nextInt();
            System.out.println("Enter the maximum year: ");
            int maximumYear = scanner.nextInt();

            ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minimumYear, maximumYear);

            displayVehicles(vehicles);
        }

}
