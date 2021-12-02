import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class useBoats {
//-----------------------------------------
private static final Scanner keyboard = new Scanner(System.in);
private static ArrayList<boats> boatList=new ArrayList<>();
//-----------------------------------------
    public static void main(String[] args){

    boatsAgain middleClass = new boatsAgain();
    String menuResponse;
    String fileName;

    System.out.println("Welcome to the Fleet Management System");
    System.out.println("--------------------------------------");

    if (args.length > 0) {
        fileName = args[0];
        if ((middleClass = boatsAgain.loadFile(fileName)) == null) {
        }     return;
    } else {

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
                //Expense
    }

        } while (!menuResponse.equals("X"));
        System.out.println("Exiting the Fleet Management System :(");
    }
//----------------------------------------------------------------------------
    public static void Print() {
    boatsAgain middleClass = new boatsAgain();

    System.out.println();
    middleClass.display();
    }
//----------------------------------------------------------------------------
    public static void Add() {
        System.out.println("Please enter the new boat CSV data ");
        System.out.println("(type,name,year,model,cost)");
        String addition = keyboard.next().toUpperCase();
        String str[] = addition.split(",");
        boats boatsInArray = new boats(str[0], str[1], Integer.parseInt(str[2]), str[3], Double.parseDouble(str[4]), Double.parseDouble(str[5]), 0);
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
/////////////
    }
