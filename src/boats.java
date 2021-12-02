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
    private double purchasePrice;
    private double maintenancePrice;
    private static ArrayList<boats> boatList=new ArrayList<>();
//----------------------------------------------------------------------------
    public boats(String s, String s1, int i, String s2, double v, double parseDouble, int i1) {

    name = "";
    year = 0;
    model = "";
    length = 0;
    purchasePrice = 0;
    maintenancePrice = 0;

    }
//----------------------------------------------------------------------------
    public boats(String name, int year, String model, double length, double purchasePrice, double maintenancePrice) {

    this();
    this.name = name;
    this.year = year;
    this.model = model;
    this.length = year;
    this.purchasePrice = purchasePrice;
    this.maintenancePrice = maintenancePrice;
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
    public void setYear() {

    this.year = year;
    }
//----------------------------------------------------------------------------
    public int getYear() {

    return(year);
    }
//----------------------------------------------------------------------------
    public void setModel() {

    this.model = model;
    }
//----------------------------------------------------------------------------
    public String getModel(){

    return(model);
    }
//----------------------------------------------------------------------------
    public void setLength() {

    this.length = length;
        }
//----------------------------------------------------------------------------
    public double getLength() {

    return(length);
    }
//----------------------------------------------------------------------------
    public void setPurchasePrice() {

    this.purchasePrice = purchasePrice;
    }
//----------------------------------------------------------------------------
    public double getPurchasePrice(){

    return(purchasePrice);
    }
//----------------------------------------------------------------------------
    public void setMaintenancePrice() {

    this.maintenancePrice = maintenancePrice;
    }
//----------------------------------------------------------------------------
    public double getMaintenancePrice(){

    return(maintenancePrice);
    }
//----------------------------------------------------------------------------
    public static void setBoatList(ArrayList<boats> boatss) {

     boatList = boatss;

    }
//----------------------------------------------------------------------------
    public static ArrayList<boats> getBoatList() {

    return boatList;
    }
//----------------------------------------------------------------------------
    public String toString() {

     return(String.format("%s $%.2f",name,year,model,length,purchasePrice,maintenancePrice));
 }
//----------------------------------------------------------------------------

//----------------------------------------------------------------------------
////////////////
}