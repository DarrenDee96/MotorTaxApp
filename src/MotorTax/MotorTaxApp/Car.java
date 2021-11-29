package MotorTax.MotorTaxApp;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {

            private String bodyType;

            public Car() {

            }

            public Car(String make, String model, int year, String colour, String numberPlate, String fuelType, double engineSize, String taxDueDate, String taxBracket,String ownerName, String bodyType , String onRoad) {
                super(make,model,year,colour,numberPlate,fuelType,engineSize,taxDueDate,ownerName,bodyType,onRoad);
                setBodyType(bodyType);

            }

            public void setBodyType(String bodyType){
                this.bodyType = bodyType;
            }
            public String getBodyType(){
                return  bodyType;
            }




    public String toString () {
        return     "\nMake: " + make + "\nModel: " + model + "\nYear: " + year + "\nColour: " + colour+ "" +
                "\nNumber Plate: " + numberPlate + "\nFuel Type: " + fuelType+ "\nEngine Size: " + engineSize
                + "\nTax Due Date: " + taxDueDate + "\n Owner Name: " + getOwnerName() + "\n Currently on The road: " + getOnRoad();


    }




}
