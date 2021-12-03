import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class useBoats {
//-----------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    private static ArrayList<boats> boatList = boats.getBoatList();
//-----------------------------------------
    public static void main(String[] args){
        
    String menuResponse;
    String fileName;

    System.out.println("Welcome to the Fleet Management System");
    System.out.println("--------------------------------------");

    if (args.length > 0) {
        fileName = args[0];
        try {
            boatList = loadFile(fileName);
            boats.setBoatList(boatList);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            }
        } else {
        fileName = "FleetData";
        boatList = loadFile("FleetData");
        String boatOne = ("POWER,Big Brother,2019,Mako,20,12989.56");
        String[] strOne = boatOne.split(",");
        boats boatsInArrayOne = new boats(strOne[0], strOne[1], Integer.parseInt(strOne[2]), Double.parseDouble(strOne[4]), Double.parseDouble(strOne[4]), Double.parseDouble(strOne[5]));
        boatList.add(boatsInArrayOne);
        String boatTwo = ("SAILING,Moon Glow,1973,Bristol,30,5500");
        String[] strTwo = boatTwo.split(",");
        boats boatsInArrayTwo = new boats(strTwo[0], strTwo[1], Integer.parseInt(strTwo[2]), Double.parseDouble(strTwo[4]), Double.parseDouble(strTwo[4]), Double.parseDouble(strTwo[5]));
        boatList.add(boatsInArrayTwo);
        String boatThree = ("SAILING,Osita,1988,Tartan,40,11500.07");
        String[] strThree = boatThree.split(",");
        boats boatsInArrayThree = new boats(strThree[0], strThree[1], Integer.parseInt(strThree[2]), Double.parseDouble(strThree[4]), Double.parseDouble(strThree[4]), Double.parseDouble(strThree[5]));
        boatList.add(boatsInArrayThree);
        String boatFour = ("POWER,Rescue II,2016,Zodiac,12,8900");
        String[] strFour = boatFour.split(",");
        boats boatsInArrayFour = new boats(strFour[0], strFour[1], Integer.parseInt(strFour[2]), Double.parseDouble(strFour[4]), Double.parseDouble(strFour[4]), Double.parseDouble(strFour[5]));
        boatList.add(boatsInArrayFour);
    }

        do {
        System.out.println("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it: ");
        menuResponse = keyboard.next().toUpperCase();
    if (menuResponse.equals("P")) {
        Print();
    } else if (menuResponse.equals("A")) {
        Add();
    } else if (menuResponse.equals("R")) {
        Remove();
    } else if (menuResponse.equals("E")) {
        Expense();
    }

        } while (!menuResponse.equals("X"));
        System.out.println("Exiting the Fleet Management System :(");

        boatFile(fileName);
    }
//----------------------------------------------------------------------------
    public static void Print() {
    boatsAgain middleClass = new boatsAgain();

    middleClass.display();
    }
//----------------------------------------------------------------------------
    public static void Add() {

    System.out.println("Please enter the new boat CSV data ");
    System.out.println("(type,name,year,model,cost)");
    String addition = keyboard.next().toUpperCase();
    String[] str = addition.split(",");
    boats boatsInArray = new boats(str[0], str[1], Integer.parseInt(str[2]), Double.parseDouble(str[4]), Double.parseDouble(str[4]), Double.parseDouble(str[5]));
    boatList.add(boatsInArray);
    }
//----------------------------------------------------------------------------
    public static void Remove() {

    System.out.println("Which boat do you want to remove? (enter just the name)");
    String removal = keyboard.next();
    removal = removal.toUpperCase();

    if (boatList.contains(removal)) {
        boatList.remove(removal);
    } else {
        System.out.println("sorry. can't find that");
    }

    }

//----------------------------------------------------------------------------
    public static void Expense() {

        System.out.print("Which boat do you want to spend on?: ");
        String whichBoat = keyboard.next();
        boolean exist = false;
        double total = 0;
        boats moneyBoat = null;

        for(boats ship:boatList){
            if(ship.getName().equalsIgnoreCase(whichBoat)){
                exist = true;
                System.out.print("How much do you want to spend?: ");
                total = keyboard.nextDouble();

            }
        }
        if(!exist)
            System.out.println("sorry. can't find that");
        else {
            if(moneyBoat.checkExpense(boats.getMaintenancePrice() + total))
            {
                boatList.remove(moneyBoat);
                moneyBoat.setMaintenancePrice(boats.getMaintenancePrice() + total);
                boatList.add(moneyBoat);
                System.out.println("Expense authorized, $" + boats.getMaintenancePrice() + " spent.");
            }
        }
    }
//----------------------------------------------------------------------------
    public static boolean boatFile(String fileName) {

    ObjectOutputStream toStream = null;
    String fleet = null;

    try {
        toStream = new ObjectOutputStream(new FileOutputStream(fileName));
        toStream.writeObject(fleet);
        return(true);
    } catch (IOException e) {
        System.out.println("ERROR saving " + e.getMessage());
        return(false);
    } finally {
        if (toStream != null) {
            try {
                toStream.close();
            } catch (IOException e) {
                System.out.println("ERROR closing " + e.getMessage());
                return(false);
            }
        }
    }
}
//-----------------------------------------------------------------------------
    public static ArrayList<boats> loadFile(String fileName) {

        ObjectInputStream fromStream = null;
        List<boats> local = new ArrayList<boats>();

        try {
            FileReader fReader = new FileReader(fileName);
            BufferedReader bReader = new BufferedReader(fReader);
            String line = null;
            fromStream = new ObjectInputStream(new FileInputStream(fileName));
            local = (ArrayList<boats>)fromStream.readObject();

            while ((line = bReader.readLine()) != null) {
                String[] boatsInArrayAgain = line.split(",");
                boats boatsss = new boats(boatsInArrayAgain[0], boatsInArrayAgain[1], Integer.parseInt(boatsInArrayAgain[2]), Double.parseDouble(boatsInArrayAgain[3]), Double.parseDouble(boatsInArrayAgain[4]), Double.parseDouble(boatsInArrayAgain[5]));
                boatList.add(boatsss);
            }
        } catch (IOException e) {
            System.out.println("ERROR loading " + e.getMessage());
            return(null);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return(null);
        } finally {
            if (fromStream != null) {
                try {
                    fromStream.close();
                } catch (IOException e) {
                    System.out.println("ERROR closing " + e.getMessage());
                    return(null);
                }
            }
        }

        return (ArrayList<boats>) local;
    }

/////////////
    }
