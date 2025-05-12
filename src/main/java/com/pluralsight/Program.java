package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();

        //Creates the user interface, passing in loaded dealership
        UserInterface userInterface = new UserInterface(dealership);

        //Starts user interface loop
        userInterface.display();
    }
}
