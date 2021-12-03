import java.io.*;
import java.util.ArrayList;

//===========================================================================
public class boats implements Serializable {
//----------------------------------------------------------------------------
    private static enum Type {SAILING, POWER};
    private String name;
    private int year;
    private String model;
    private double length;
    private static double purchasePrice;
    private static double maintenancePrice;
    private static ArrayList<boats> boatList=new ArrayList<>();

//----------------------------------------------------------------------------
    public boats(String name, String model, int year, double length, double purchasePrice, double maintenancePrice) {

    super();
    this.name = name;
    this.year = year;
    this.model = model;
    this.length = length;
    boats.purchasePrice = purchasePrice;
    boats.maintenancePrice = maintenancePrice;
}
//----------------------------------------------------------------------------
    public void setName() {

    this.name = name;
    }
 //----------------------------------------------------------------------------
    public String getName() {

    return(name);
    }
//----------------------------------------------------------------------------
    public void setYear(int year) {

    this.year = year;
    }
//----------------------------------------------------------------------------
    public int getYear() {

    return(year);
    }
//----------------------------------------------------------------------------
    public void setModel(String model) {

    this.model = model;
    }
//----------------------------------------------------------------------------
    public String getModel(){

    return(model);
    }
//----------------------------------------------------------------------------
    public void setLength(double length) {

    this.length = length;
        }
//----------------------------------------------------------------------------
    public double getLength() {

    return(length);
    }
//----------------------------------------------------------------------------
    public void setPurchasePrice(double purchasePrice) {

    boats.purchasePrice = purchasePrice;
    }
//----------------------------------------------------------------------------
    public static double getPurchasePrice(){

    return(purchasePrice);
    }
//----------------------------------------------------------------------------
    public void setMaintenancePrice(double maintenancePrice) {

    boats.maintenancePrice = maintenancePrice;
    }
//----------------------------------------------------------------------------
    public static double getMaintenancePrice(){

    return(maintenancePrice);
    }
//----------------------------------------------------------------------------
    public static void setBoatList(ArrayList<boats> shipList) {

     boatList = shipList;

    }
//----------------------------------------------------------------------------
    public static ArrayList<boats> getBoatList() {

    return boatList;
    }
//----------------------------------------------------------------------------
    public String toString() {

    return (name + year + model + length + purchasePrice + maintenancePrice);
 }
//----------------------------------------------------------------------------
    public static double getPaidTotal() {

    double paid = 0;
    paid += boats.getPurchasePrice();
    return paid;
    }
//----------------------------------------------------------------------------
    public static double getSpentTotal() {

    double spent = 0;
    spent += boats.getMaintenancePrice();
    return spent;
    }
//----------------------------------------------------------------------------
    public boolean checkExpense(double money) {


    if (getPurchasePrice() < money)
    {
        System.out.println("Expense not permitted, only "+(getPurchasePrice()-getMaintenancePrice()) + " left to spend.");
        return false;
    }
    return true;
}
//----------------------------------------------------------------------------
////////////////
}