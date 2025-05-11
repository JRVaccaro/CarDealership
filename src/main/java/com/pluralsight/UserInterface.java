package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    //helper method
    private void init(){
    //Get dealership data
    DealershipFileManager fileManager = new DealershipFileManager();

    this.dealership = fileManager.getDealership();

    }
    public void display(){
        init();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running){
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

            switch (choice){
                case 1:
                    break;

                case 2:
                    break;

                case 3:
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
}
