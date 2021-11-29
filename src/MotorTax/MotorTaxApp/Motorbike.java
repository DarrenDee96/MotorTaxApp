package MotorTax.MotorTaxApp;


import java.io.Serializable;

public class Motorbike extends Vehicle implements Serializable {

    private String typeOfBike;

    public Motorbike() {

    }

    public Motorbike(String make, String model, int year, String colour, String numberPlate, String fueltype, String fuelType, double engineSize, String taxDueDate, String taxBracket, String ownerName, String typeOfBike, String onRoad) {
        super(make, model, year, colour, numberPlate, fuelType, engineSize, taxDueDate, ownerName, typeOfBike, onRoad);
        setTypeOfBike(typeOfBike);


    }

    public void setTypeOfBike(String typeOfBike) {
        this.typeOfBike = typeOfBike;

    }

}
