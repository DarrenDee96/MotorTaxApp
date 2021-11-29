package MotorTax.MotorTaxApp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MotorTaxApp extends JFrame implements ActionListener  {

    JMenu motorTaxMenu;
    JMenu vehicleMenu;
    JMenu exitMenu;
    JLabel imgMain;
    JButton registerCar;
    JButton registerMotorbike;
    JButton taxBracket;
    JButton vDetails;
    JButton offRoad;
    JButton ownership;
    JButton button1;
    JPanel mainPanel;


    ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Vehicle vehicle;


    public MotorTaxApp(){
        super("Motor Tax Application");

        vehicles.add( vehicle = new Vehicle("Audi" , "A4", 2005, "Blue", "05-KY-6078", "Diesel" , 1.9, "30-12-2021", "Darren Dineen","Sedan", "Y"));
        vehicles.add( vehicle = new Vehicle("Honda" , "Civic", 2015, "Red", "151-KY-9548", "Diesel" , 1.6, "30-09-2022", "Liam Mooney", "Hatchback","Y"));
        vehicles.add( vehicle = new Vehicle("Toyota" , "Avensis", 2012, "Black", "121-C-6448", "Diesel" , 2.0, "30-05-2022", "Rick lynch", "Sedan","Y"));
        vehicles.add( vehicle = new Vehicle("Toyota" , "Corolla", 2009, "White", "09-TS-46215", "Petrol" , 1.4, "30-01-2022", "Patrick Buckley", "Hatchback","Y"));
        vehicles.add( vehicle = new Vehicle("Renault" , "Zoe", 2021, "Blue", "121-WH-663", "Electric" , 0.0, "31-04-2022", "Sean White", "Hatchback","Y"));


        Container pane = getContentPane();
        pane.setBackground(new Color(52,171,235));

        createMotorTaxMenu();
        createVehicleMenu();
        createExitMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(116,195,237));
        menuBar.add(motorTaxMenu);
        menuBar.add(vehicleMenu);
        menuBar.add(exitMenu);


        setSize(750,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(400,200);


        mainPanel = new JPanel();
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.setLayout(new BoxLayout(mainPanel , BoxLayout.Y_AXIS));



        try{
            imgMain = new JLabel();
            imgMain.setIcon(new ImageIcon(getClass().getResource("MotorTaxLogo.png")));
            imgMain.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(imgMain);

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Image not found");
        }

        mainPanel.add(Box.createVerticalStrut(30));

        button1 = new JButton();



        button1.setLayout(new GridLayout(2,3));
        button1.setSize(750,100);
        button1.setLocation(-10,230);



        registerCar = new JButton("Register a Car");
        registerCar.addActionListener(this);
        button1.add(registerCar);

        registerMotorbike = new JButton("Register a Motorbike");
        registerMotorbike.addActionListener(this);
        button1.add(registerMotorbike);

        taxBracket = new JButton("Check Vehicle Tax Bracket");
        taxBracket.addActionListener(this);
        button1.add(taxBracket);

        vDetails = new JButton("Change Vehicle Details");
        vDetails.addActionListener(this);
        button1.add(vDetails);

        offRoad = new JButton("Declare a Vehicle Off the Road");
        offRoad.addActionListener(this);
        button1.add(offRoad);

        ownership = new JButton("Change of Ownership");
        ownership.addActionListener(this);
        button1.add(ownership);


        add(button1);
        add(mainPanel);

        setVisible(true);
        setResizable(false);
        openFile();

    }

    public static void main(String[] args) {

       MotorTaxApp taxApp = new MotorTaxApp();



    }

    public void actionPerformed(ActionEvent event){
        String eventName;
        eventName = event.getActionCommand();


        if(eventName.equals("Register a Car") || event.getSource() == registerCar) {
            registerCar();
        }
        if(eventName.equals("Register a Motorbike") || event.getSource() ==  registerMotorbike) {
            registerMotorbike();
        }
        if(eventName.equals("Change Vehicle Details") || event.getSource() == vDetails) {
            changeVehicleDetails();
        }
        if(eventName.equals("Check Tax Bracket") || event.getSource() == taxBracket) {
            taxBracket();
        }
        if(eventName.equals("Check Tax Price")){

           int optionButton= JOptionPane.showConfirmDialog(null,"Do you know your tax bracket of your Vehicle?", "Tax Bracket" , JOptionPane.YES_NO_OPTION);

           if(optionButton == JOptionPane.YES_OPTION) {
               String bracket;

               bracket = JOptionPane.showInputDialog("Please enter your tax bracket:");

               taxPrice(bracket);

           }
           else {
               taxBracket();

           }

        }
        if(eventName.equals("Declare Vehicle of the Road") || event.getSource() == offRoad){
            offTheRoad();
        }
        if(eventName.equals("Change of Ownership") || event.getSource()== ownership) {
            changeOwnership();
        }
        if(eventName.equals("View A Vehicles Details")){
                viewVehicles();
        }

        if(eventName.equals("Save and Exit")) {
            JOptionPane.showMessageDialog(null, "Saving and Exiting the Application");
            saveFile();
            System.exit(0);

        }
        if(eventName.equals("Exit Without Saving")){
            JOptionPane.showMessageDialog(null, "Exiting Without Saving");
            System.exit(0);
        }

        }

        private void createMotorTaxMenu(){
        JMenuItem item;

        motorTaxMenu = new JMenu("Motor Tax");
        item = new JMenuItem("Change Vehicle Details");
        item.addActionListener(this);

        motorTaxMenu.add(item);
        item = new JMenuItem("Check Tax Bracket");
        item.addActionListener(this);
        motorTaxMenu.add(item);

        motorTaxMenu.add(item);
        item = new JMenuItem("Check Tax Price");
        item.addActionListener(this);
        motorTaxMenu.add(item);

        motorTaxMenu.add(item);
        item = new JMenuItem("Declare Vehicle of the Road");
        item.addActionListener(this);
        motorTaxMenu.add(item);

        motorTaxMenu.add(item);
        item = new JMenuItem("Change of Ownership");
        item.addActionListener(this);
        motorTaxMenu.add(item);

        }

        private void createVehicleMenu(){
            JMenuItem item;

            vehicleMenu = new JMenu("Register Vehicle");

            item = new JMenuItem("Register a Car");
            item.addActionListener(this);

            vehicleMenu.add(item);

            item = new JMenuItem("Register a Motorbike");
            item.addActionListener(this);
            vehicleMenu.add(item);

            item = new JMenuItem("View A Vehicles Details");
            item.addActionListener(this);
            vehicleMenu.add(item);

        }

        public  void createExitMenu(){
            JMenuItem item;


            exitMenu = new JMenu("Exit the Application");


            item = new JMenuItem("Save and Exit");
            item.addActionListener(this);
            exitMenu.add(item);

            item = new JMenuItem("Exit Without Saving");
            item.addActionListener(this);
            exitMenu.add(item);

        }

        public void registerCar(){


            String make;
            String model;
            int year;
            String colour;
            String numberPlate;
            final String[] fuelTypelist = {"Diesel","Petrol","Electric"};
            String fuelType;
            double engineSize;
            String taxDueDate;
            String ownerName;
            String bodyType;
            String onRoad = "Y";

            fuelType = (String) JOptionPane.showInputDialog(null,"Register Car","Register Vehicle",JOptionPane.QUESTION_MESSAGE,null,fuelTypelist,fuelTypelist[0]);

            try {
                do {
                    make = JOptionPane.showInputDialog("Enter The Make of the Vehicle");
                    if (make.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Make entered");
                    }
                } while (make.equals(""));


                do {
                    model = JOptionPane.showInputDialog("Enter The Model of the Vehicle");

                    if (model.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Model entered");
                    }
                } while (model.equals(""));

                do {

                    year = Integer.parseInt(JOptionPane.showInputDialog("Enter The Year of the Vehicle"));
                    if (year < 1900 || year > 2022) {
                        JOptionPane.showMessageDialog(null, "Invalid Year Entered");
                    }
                } while (year < 1900 || year > 2022);

                do {
                    colour = JOptionPane.showInputDialog("Enter The Colour of the Vehicle");

                    if (colour.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Colour Entered");
                    }
                } while (colour.equals(""));

                do {

                    numberPlate = JOptionPane.showInputDialog("Enter the Vehicle Number Plate");
                    if (numberPlate.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Number Plate Entered");
                    }
                } while (numberPlate.equals(""));


                if (fuelType.equals("Diesel") || fuelType.equals("Petrol")) {
                do {


                        engineSize = Double.parseDouble(JOptionPane.showInputDialog("Enter the Engine Size. eg. 1.5"));

                        if (engineSize <= 0 || engineSize > 15) {
                            JOptionPane.showMessageDialog(null, "Invalid Entry");
                        }
                    } while (engineSize <= 0 || engineSize > 15) ;
                }else
                {
                    engineSize = 0;
                }
                do {
                    taxDueDate = JOptionPane.showInputDialog("enter the tax due date. dd-mm-yyyy");

                    if (taxDueDate.equals("")) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry");
                    }

                } while (taxDueDate.equals(""));

                do {

                    ownerName = JOptionPane.showInputDialog("enter the vehicle owner Name");

                    if (ownerName.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Name Entered");
                    }
                } while (ownerName.equals(""));

                do{
                    bodyType = JOptionPane.showInputDialog("Enter the Vehicle Body Type");
                    if(bodyType.equals("")){
                        JOptionPane.showMessageDialog(null,"No Body Type Entered");
                    }
                }while (bodyType.equals(""));

                vehicle = new Vehicle(make,model,year,colour,numberPlate,fuelType,engineSize,taxDueDate,ownerName ,bodyType, onRoad);
                vehicles.add(vehicle);


                JOptionPane.showMessageDialog(null,"Vehicle " + numberPlate +" added to the system");


            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Nothing was entered");
            }


       }

        public void registerMotorbike(){


            String make;
            String model;
            int year;
            String colour;
            String numberPlate;
            final String[] fuelTypelist = {"Diesel","Petrol","Electric"};
            String fuelType;
            double engineSize;
            String taxDueDate;
            String ownerName;
            String typeOfBike;
            String onRoad = "Y";

            fuelType = (String) JOptionPane.showInputDialog(null,"Register Car","Register Vehicle",JOptionPane.QUESTION_MESSAGE,null,fuelTypelist,fuelTypelist[0]);

            try {
                do {
                    make = JOptionPane.showInputDialog("Enter The Make of the Vehicle");
                    if (make.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Make entered");
                    }
                } while (make.equals(""));


                do {
                    model = JOptionPane.showInputDialog("Enter The Model of the Vehicle");

                    if (model.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Model entered");
                    }
                } while (model.equals(""));

                do {

                    year = Integer.parseInt(JOptionPane.showInputDialog("Enter The Year of the Vehicle"));
                    if (year < 1900 || year > 2022) {
                        JOptionPane.showMessageDialog(null, "Invalid Year Entered");
                    }
                } while (year < 1900 || year > 2022);

                do {
                    colour = JOptionPane.showInputDialog("Enter The Colour of the Vehicle");

                    if (colour.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Colour Entered");
                    }
                } while (colour.equals(""));

                do {

                    numberPlate = JOptionPane.showInputDialog("Enter the Vehicle Number Plate");
                    if (numberPlate.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Number Plate Entered");
                    }
                } while (numberPlate.equals(""));

                do {


                    engineSize = Double.parseDouble(JOptionPane.showInputDialog("Enter the Engine Size. eg. 1.5"));

                    if (engineSize <= 0 || engineSize > 15) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry");
                    }
                } while (engineSize <= 0 || engineSize > 15);

                do {
                    taxDueDate = JOptionPane.showInputDialog("enter the tax due date. dd-mm-yyyy");

                    if (taxDueDate.equals("")) {
                        JOptionPane.showMessageDialog(null, "Invalid Entry");
                    }

                } while (taxDueDate.equals(""));

                do {

                    ownerName = JOptionPane.showInputDialog("enter the vehicle owner Name");

                    if (ownerName.equals("")) {
                        JOptionPane.showMessageDialog(null, "No Name Entered");
                    }
                } while (ownerName.equals(""));

                do{
                    typeOfBike = JOptionPane.showInputDialog("Enter the Type of Bike");
                    if(typeOfBike.equals("")){
                        JOptionPane.showMessageDialog(null, "No type Entered");
                    }
                }while(typeOfBike.equals(""));


                vehicle = new Vehicle(make,model,year,colour,numberPlate,fuelType,engineSize,taxDueDate,ownerName, typeOfBike, onRoad);
                vehicles.add(vehicle);

                JOptionPane.showMessageDialog(null,"Vehicle " + numberPlate +" added to the system");

            }catch (NumberFormatException e ) {
                JOptionPane.showMessageDialog(null, "Nothing was entered");
            }
            catch (NullPointerException e ) {
                JOptionPane.showMessageDialog(null, "No Entry Entered");
            }

        }

        public void changeVehicleDetails(){
            JComboBox changeDetailsCombo = new JComboBox();
            JTextArea output = new JTextArea();
            JTextArea newOutput = new JTextArea();
            JComboBox detailChoice = new JComboBox();

            output.setText("Change Vehicle Details");


            Iterator<Vehicle> iterator = vehicles.iterator();

            while (iterator.hasNext()) {
                changeDetailsCombo.addItem(iterator.next().getNumberPlate());


            }

            JOptionPane.showMessageDialog(null, changeDetailsCombo, "Select the vehicle you want to change", JOptionPane.PLAIN_MESSAGE);

            int choice = changeDetailsCombo.getSelectedIndex();
            output.append(vehicles.get(choice).toString());

            JOptionPane.showMessageDialog(null, output, "Vehicle Details", JOptionPane.PLAIN_MESSAGE);

            detailChoice.addItem("Make");
            detailChoice.addItem("Model");
            detailChoice.addItem("Year");
            detailChoice.addItem("Colour");
            detailChoice.addItem("Number Plate");
            detailChoice.addItem("Fuel Type");
            detailChoice.addItem("Engine Size");
            detailChoice.addItem("Tax Due Date");


            JOptionPane.showMessageDialog(null, detailChoice, "What would you like to change", JOptionPane.PLAIN_MESSAGE);

            int i = detailChoice.getSelectedIndex();

            if(i == 0){
               String newMake;

               newMake = JOptionPane.showInputDialog("Please enter a new value for the Make:");
               int m = changeDetailsCombo.getSelectedIndex();
               vehicles.get(m).setMake(newMake);

               JOptionPane.showMessageDialog(null,"Make successfully changed to " + newMake);
            }
            if (i == 1){
                String newModel;

                newModel = JOptionPane.showInputDialog("Please enter a new value for the Model:");
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setModel(newModel);

                JOptionPane.showMessageDialog(null,"Model successfully changed to " + newModel);
            }
            if (i == 2){
                int newYear;

                newYear = Integer.parseInt(JOptionPane.showInputDialog("Please enter a new value for the Year:"));
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setYear(newYear);

                JOptionPane.showMessageDialog(null,"Year successfully changed to  " + newYear);
            }
            if (i == 3){
                String newColour;

                newColour = JOptionPane.showInputDialog("Please enter the new value for colour:");
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setColour(newColour);

                JOptionPane.showMessageDialog(null,"Colour successfully changed to  " + newColour);
            }
            if (i == 4){
                String newNumPlate;

                newNumPlate = JOptionPane.showInputDialog("Please enter a new value for Number Plate:");
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setNumberPlate(newNumPlate);

                JOptionPane.showMessageDialog(null,"Number Plate successfully changed to  " + newNumPlate);
            }
            if (i == 5){
                String newFuelType;

                newFuelType = JOptionPane.showInputDialog("Please enter a new value for Fuel Type:");
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setFuelType(newFuelType);

                JOptionPane.showMessageDialog(null,"Fuel Type successfully changed to  " + newFuelType);
            }
            if (i == 6) {
                double newEngineSize;

                newEngineSize = Double.parseDouble(JOptionPane.showInputDialog("Please enter a new value for Engine Size:"));
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setEngineSize(newEngineSize);

                JOptionPane.showMessageDialog(null,"Engine Size successfully changed to  " + newEngineSize);
            }
            if (i ==7){
                String newTaxDate;

                newTaxDate = JOptionPane.showInputDialog("Please enter a new Value for Tax Due Date");
                int m = changeDetailsCombo.getSelectedIndex();
                vehicles.get(m).setTaxDueDate(newTaxDate);

                JOptionPane.showMessageDialog(null,"Tax Due Date successfully changed to  " + newTaxDate);
            }

            newOutput.append(vehicles.get(choice).toString());

            JOptionPane.showMessageDialog(null, newOutput, "Vehicle Details", JOptionPane.PLAIN_MESSAGE);

        }

        public void taxBracket(){


            JComboBox fuelChoice = new JComboBox();
                String fuelType ="";
                int year;
                double engineSize;
                String taxBracket="";

            fuelChoice.addItem("Diesel");
            fuelChoice.addItem("Petrol");
            fuelChoice.addItem("Electric");


            JOptionPane.showMessageDialog(null, fuelChoice, "Pick Fuel Type", JOptionPane.PLAIN_MESSAGE);

            int i = fuelChoice.getSelectedIndex();

            if(i == 0) {
                fuelType = "Diesel";
            }
            if (i==1) {
                fuelType = "Petrol";
            }
            if (i==2){
                fuelType = "Electric";
            }
            year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Year of you Vehicle"));
            engineSize = Double.parseDouble(JOptionPane.showInputDialog("Please enter the Engine Size of your Vehicle"));


                if (fuelType.equals("Electric")) {
                    taxBracket = "E0";
                }


                if (year <= 1992) {
                    if (fuelType.equals("Diesel") ) {
                        if (engineSize <= 1.6) {
                            taxBracket = "CD92A";
                        } else if (engineSize <= 1.9) {
                            taxBracket = "CD92B";
                        } else if (engineSize >= 2.0) {
                            taxBracket = "CD92C";
                        }

                    }
                    if (fuelType.equals("Petrol")) {
                        if (engineSize <= 1.6) {
                            taxBracket = "CP92A";
                        } else if (engineSize <= 1.9) {
                            taxBracket = "CP92B";
                        } else if (engineSize >= 2.0) {
                            taxBracket = "CP92C";
                        }
                    }
                }


                if (year <= 2003 && year >= 1993) {
                    if (fuelType.equals("Diesel")) {
                        if (engineSize <= 1.6) {
                            taxBracket = "CD03A";
                        } else if (engineSize <= 1.9) {
                            taxBracket = "CD03B";
                        } else if (engineSize >= 2.0) {
                            taxBracket = "CD03C";
                        }
                    }
                    if (fuelType.equals("Petrol")) {
                        if (engineSize <= 1.6) {
                            taxBracket = "CP03A";
                        } else if (engineSize <= 1.9) {
                            taxBracket = "CP03B";
                        } else if (engineSize >= 2.0) {
                            taxBracket = "CP03C";
                        }
                    }
                }

                    if (year <= 2008 && year >=2004) {
                        if (fuelType.equals("Diesel")) {
                            if (engineSize <= 1.6) {
                                taxBracket = "CD08A";
                            } else if (engineSize <= 1.9) {
                                taxBracket = "CD08B";
                            } else if (engineSize >= 2.0) {
                                taxBracket = "CD08C";
                            }
                        }
                        if (fuelType.equals("Petrol")) {
                            if (engineSize <= 1.6) {
                                taxBracket = "CP08A";
                            } else if (engineSize <= 1.9) {
                                taxBracket = "CP08B";
                            } else if (engineSize >= 2.0) {
                                taxBracket = "CP08C";
                            }
                        }
                    }


                    if (year <= 2015 && year >= 2009) {
                        if (fuelType.equals("Diesel")) {
                            if (engineSize <= 1.6) {
                                taxBracket = "CD15A";
                            } else if (engineSize <= 1.9) {
                                taxBracket = "CD15B";
                            } else if (engineSize >= 2.0) {
                                taxBracket = "CD15C";
                            }
                        }
                        if (fuelType.equals("Petrol")) {
                            if (engineSize <= 1.6) {
                                taxBracket = "CP15A";
                            } else if (engineSize <= 1.9) {
                                taxBracket = "CP15B";
                            } else if (engineSize >= 2.0) {
                                taxBracket = "CP15C";
                            }
                        }
                    }


                    if (year >= 2016) {
                        if (fuelType.equals("Diesel")) {
                            if (engineSize <= 1.6) {
                                taxBracket = "CD16A";
                            } else if (engineSize <= 1.9) {
                                taxBracket = "CD16B";
                            } else if (engineSize >= 2.0) {
                                taxBracket = "CD16C";
                            }
                        }
                        if (fuelType.equals("Petrol")) {
                            if (engineSize <= 1.6) {
                                taxBracket = "CP16A";
                            } else if (engineSize <= 1.9) {
                                taxBracket = "CP16B";
                            } else if (engineSize >= 2.0) {
                                taxBracket = "CP16C";
                            }
                        }
                    }



                JOptionPane.showMessageDialog(null,"The tax bracket of your vehicle is " + taxBracket);


            int optionButton= JOptionPane.showConfirmDialog(null,"Do you want to see your tax price?", "Tax Price" , JOptionPane.YES_NO_OPTION);

            if(optionButton == JOptionPane.YES_OPTION) {
                taxPrice(taxBracket);


           }
            }

        public void offTheRoad(){



            JComboBox offRoadCombo = new JComboBox();
            JTextArea output = new JTextArea();
            JTextArea newOutput = new JTextArea();


            output.setText("Declare Off the Road");


            Iterator<Vehicle> iterator = vehicles.iterator();

            while (iterator.hasNext()) {
                offRoadCombo.addItem(iterator.next().getNumberPlate());


            }

            JOptionPane.showMessageDialog(null, offRoadCombo, "Select the vehicle you want to declare off the road", JOptionPane.PLAIN_MESSAGE);

            int choice = offRoadCombo.getSelectedIndex();
            output.append(vehicles.get(choice).toString());


            int optionButton= JOptionPane.showConfirmDialog(null,"Do you wish to declare this Vehicle Off the Road", "Declare Vehicle Off The Road" , JOptionPane.YES_NO_OPTION);

            if(optionButton == JOptionPane.YES_OPTION) {

                String OffRoad = "N";

                int m = offRoadCombo.getSelectedIndex();
                vehicles.get(m).setOnRoad(OffRoad);

            }
            else{
                JOptionPane.showMessageDialog(null, "Request Canceled");
            }

            String newOffRoad="";

            newOutput.append(vehicles.get(choice).toString());

            JOptionPane.showMessageDialog(null, newOutput, "Vehicle Details", JOptionPane.PLAIN_MESSAGE);


        }

        public void  taxPrice (String taxBracket){

        String strTaxPrice = "";
        double yearTax;
        String bracket = "";
        switch (taxBracket) {

            //Electric Tax Price
            case "E0":
                    bracket = "E0";
                    yearTax = 0;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4* 0.1));
                break;

             //Diesel and Petrol Less than 1992
            case "CD92A":
                bracket = "CD92A";
                yearTax = 60;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD92B":
                bracket = "CD92B";
                yearTax = 70;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD92C":
                bracket = "CD92C";
                yearTax = 95;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP92A":
                bracket = "CP92A";
                yearTax = 65;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP92B":
                bracket = "CP92B";
                yearTax = 80;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP92C":
                bracket = "CP92C";
                yearTax = 100;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;


            // Diesel and Petrol between 1993 and 2003
            case "CD03A":
                bracket = "CD03A";
                yearTax = 750;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD03B":
                bracket = "CD03B";
                yearTax = 1020;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD03C":
                bracket = "CD03C";
                yearTax = 1350;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP03A":
                bracket = "CP03A";
                yearTax = 680;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP03B":
                bracket = "CP03B";
                yearTax = 1000;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP03C":
                bracket = "CP03C";
                yearTax = 1480;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

              //Diesel and Petrol between 2004 and 2008
            case "CD08A":
                bracket = "CD08A";
                yearTax = 400;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD08B":
                bracket = "CD08B";
                yearTax = 650;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD08C":
                bracket = "CD08C";
                yearTax = 800;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP08A":
                bracket = "CP08A";
                yearTax = 350;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP08B":
                bracket = "CP08B";
                yearTax = 480;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP08C":
                bracket = "CP08C";
                yearTax = 740;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;


                //Diesel and Petrol Between 2009 and 2015

            case "CD15A":
                bracket = "CD15A";
                yearTax = 150;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD15B":
                bracket = "CD15B";
                yearTax = 190;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD15C":
                bracket = "CD15C";
                yearTax = 250;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP15A":
                bracket = "CP15A";
                yearTax = 180;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP15B":
                bracket = "CP15B";
                yearTax = 240;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP15C":
                bracket = "CP15C";
                yearTax = 350;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

                //Diesel and Petrol 2016 and after
            case "CD16A":
                bracket = "CD16A";
                yearTax = 100;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD16B":
                bracket = "CD16B";
                yearTax = 130;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CD16C":
                bracket = "CD16C";
                yearTax = 150;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP16A":
                bracket = "CP16A";
                yearTax = 90;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP16B":
                bracket = "CP16B";
                yearTax = 140;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;

            case "CP16C":
                bracket = "CP16C";
                yearTax = 180;

                strTaxPrice = "1 Year: " + yearTax +
                        "\n6 Months: " + ((yearTax/2)+(yearTax/2* 0.1)) +
                        "\n3 Months: " + ((yearTax/4)+(yearTax/4 * 0.1));
                break;


        }
        JOptionPane.showMessageDialog(null, "The tax price for tax bracket (" + bracket + ") is " +
                "as follows: \n" + strTaxPrice);

        }

        public void changeOwnership(){



            JComboBox changeOwnershipCombo = new JComboBox();
            JTextArea output = new JTextArea();
            JTextArea newOutput = new JTextArea();


            output.setText("Change Vehicles Ownership");


            Iterator<Vehicle> iterator = vehicles.iterator();

            while (iterator.hasNext()) {
                changeOwnershipCombo.addItem(iterator.next().getNumberPlate());


            }

            JOptionPane.showMessageDialog(null, changeOwnershipCombo, "Select the vehicle you want to change", JOptionPane.PLAIN_MESSAGE);

            int choice = changeOwnershipCombo.getSelectedIndex();
            output.append(vehicles.get(choice).toString());

            String newName="";

            JOptionPane.showMessageDialog(null, output, "Vehicle Details", JOptionPane.PLAIN_MESSAGE);


                String newMake;

                newName = JOptionPane.showInputDialog("Please enter the name of the new owner: ");
                int m = changeOwnershipCombo.getSelectedIndex();
                vehicles.get(m).setOwnerName(newName);

                JOptionPane.showMessageDialog(null,"Name successfully changed to " + newName);


            newOutput.append(vehicles.get(choice).toString());

            JOptionPane.showMessageDialog(null, newOutput, "Vehicle Details", JOptionPane.PLAIN_MESSAGE);


        }


        public void viewVehicles(){
                JComboBox vehicleCombo = new JComboBox();
                JTextArea output = new JTextArea();

                output.setText("All Vehicle Details");


                Iterator<Vehicle> iterator = vehicles.iterator();

                while (iterator.hasNext()) {
                    vehicleCombo.addItem(iterator.next().getNumberPlate());


                }

            JOptionPane.showMessageDialog(null, vehicleCombo, "Select the vehicle you want to view", JOptionPane.PLAIN_MESSAGE);

                    int choice = vehicleCombo.getSelectedIndex();
                        output.append(vehicles.get(choice).toString());

                        JOptionPane.showMessageDialog(null, output, "Vehicle Details", JOptionPane.PLAIN_MESSAGE);

                    }

        public void saveFile(){

            File outfile = new File("vehicles.dat");

            try {
            FileOutputStream outputStream = new FileOutputStream(outfile);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(vehicles);

            outputStream.close();
            }
            catch (FileNotFoundException fnfe){
                JOptionPane.showMessageDialog(null, "File Not Found.", "No File Found", JOptionPane.ERROR_MESSAGE );

            }

             catch (IOException ioe) {
                 JOptionPane.showMessageDialog(null, "File can not be written.", "Could not write to file", JOptionPane.ERROR_MESSAGE );

             }

        }

        public void openFile(){

        File inFile = new File("vehicles.dat");

                    try {
                        File file = new File("vehicles.dat");

                        if(file.exists()) {

                            FileInputStream file1 = new FileInputStream(inFile);

                            ObjectInputStream objectInputStream = new ObjectInputStream(file1);
                            vehicles = (ArrayList<Vehicle>) objectInputStream.readObject();
                            objectInputStream.close();



                            JOptionPane.showMessageDialog(null, file.getName() + " file  was successfully loaded into the system", "Successfully Loaded", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            file.createNewFile();
                            JOptionPane.showMessageDialog(null, "File Created", "Created the " + file.getName() + " file", JOptionPane.INFORMATION_MESSAGE);
                        }








                    }catch (ClassNotFoundException fnfe){

                        JOptionPane.showMessageDialog(null,"File could not be found!",
                                "Problem Finding File!",JOptionPane.ERROR_MESSAGE);

                    }
                    catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null,"File could not be read!",
                                "Problem Reading From File!",JOptionPane.ERROR_MESSAGE);
                    }
                    catch (ClassCastException cce) {

                        JOptionPane.showMessageDialog(null,"Could not convert the object to the appropriate class!",
                                "Problem Converting Object!",JOptionPane.ERROR_MESSAGE);
                    }

                    }

}













