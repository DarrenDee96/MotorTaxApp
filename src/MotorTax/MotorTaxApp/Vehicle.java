package MotorTax.MotorTaxApp;

import java.io.Serializable;

/*
    Author: Darren Dineen 28/11/2021
    Motor Tax Application
    2021 Mini Project
 */

public class Vehicle implements Serializable {


    public String make;
    public String model;
    public int year;
    public String colour;
    public String numberPlate;
    public String fuelType;
    public double engineSize;
    public String taxDueDate;
    public String taxBracket;
    public String ownerName;
    public String onRoad;


    // No-argument Constructor
    public Vehicle() {
        this("Undefined", "Undefined", 0, "Undefined", "Undefined", "Undefined", 0, "Undefined", "Undefined" , "Undefined", "Y");

    }

    /*  10 argument constructor
           - Make of the Vehicle
           - Model of the Vehicle
           - Year of the Vehicle
           - Colour of the Vehicle
           - Number Plate of the Vehicle
           - Fuel Type of the Vehicle
           - Engine Size of the Vehicle
           - Tax Due Date of the Vehicle
           - Whether the Car is in the road or not
           - Owners name of the Vehicle
     */
    public Vehicle(String make, String model, int year, String colour, String numberPlate, String fuelType, double engineSize, String taxDueDate , String ownerName, String bodyType, String onRoad ) {
        setMake(make);
        setModel(model);
        setYear(year);
        setColour(colour);
        setNumberPlate(numberPlate);
        setFuelType(fuelType);
        setEngineSize(engineSize);
        setTaxDueDate(taxDueDate);
        setOnRoad(onRoad);
        setOwnerName(ownerName);



    }


    //Getter Method for returning whether the vehicle of on the road or not

    public String getOnRoad(){
        return onRoad;
    }

    //Setter Method for setting whether the vehicle is on the road
    public void setOnRoad(String onRoad){
        this.onRoad = onRoad;
    }

    //Getter Method for getting Vehicle Make
    public String getMake() {
        return make;
    }

    //Getter Method for getting Vehicle Model
    public String getModel() {
        return model;
    }

    //Getter Method for getting Vehicle Year
    public int getYear() {
        return year;
    }

    //Getter Method for getting Vehicle Colour
    public String getColour() {
        return colour;
    }

    //Getter Method for getting Vehicle Number Plate
    public String getNumberPlate() {
        return numberPlate;
    }

    //Getter Method for getting Vehicle Fuel Type
    public String getFuelType() {
        return fuelType;
    }

    //Getter Method for getting Vehicle Engine Size
    public double getEngineSize() {
        return engineSize;
    }

    //Getter Method for getting Vehicle Tax Due Date
    public String getTaxDueDate() {
        return taxDueDate;
    }

    //Getter Method for getting Vehicle Owner Name
    public String getOwnerName(){
        return ownerName;
    }

    //Setter Method for setting Vehicle Make
    public void setMake(String make) {
        this.make = make;
    }

    //Setter Method for setting Vehicle Model
    public void setModel(String model) {
        this.model = model;
    }

    //Setter Method for setting Vehicle Year
    public void setYear(int year) {
        this.year = year;
    }

    //Setter Method for setting Vehicle Colour
    public void setColour(String colour) {
        this.colour = colour;
    }

    //Setter Method for setting Vehicle Number Plate
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    //Setter Method for setting Vehicle Fuel Type
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    //Setter Method for setting Vehicle Engine size
    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    //Setter Method for setting Vehicle Tax Due Date
    public void setTaxDueDate(String taxDueDate) {
        this.taxDueDate = taxDueDate;
    }

    //Setter Method for setting Vehicle Owner Name
    public void setOwnerName(String ownerName) {
        this.ownerName=ownerName;
    }


    //To String Method for displaying the object information in text
    public String toString() {
        return
                "\nMake: " + make + "\nModel: " + model + "\nYear: " + year + "\nColour: " + colour+ "" +
                        "\nNumber Plate: " + numberPlate + "\nFuel Type: " + fuelType+ "\nEngine Size: " + engineSize
                + "\nTax Due Date: " + taxDueDate + "\n Owner Name: " + getOwnerName() + "\n Currently on The road: " + getOnRoad();
    }

    }


