package com.pluralsight;

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


    }
}
