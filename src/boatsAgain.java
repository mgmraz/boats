import java.io.*;
import java.util.ArrayList;

//============================================================================
public class boatsAgain implements Serializable {
//----------------------------------------------------------------------------
    private String name;
    ArrayList<boats> boatList = boats.getBoatList();
//----------------------------------------------------------------------------
    public boatsAgain() {

    int index;
    name = null;

    }
//-----------------------------------------------------------------------------
    public boatsAgain(String newName) {

    this();
    name = newName;
    }
//-----------------------------------------------------------------------------
    public void display() {

    int index;

    for (index = 0; index < boatList.size(); index++) {
        if (boatList.get(index) != null) {
            System.out.print("   "+ (index+1) + ": ");
            System.out.println(boatList.get(index));
        }
    }
    }
 //-----------------------------------------------------------------------------
    public void addBoat(String name, int year, String model, double length, double purchasePrice,
                        double maintenancePrice){

        System.out.println("Please enter the new boat CSV data");
        System.out.println("(type,name,year,model,cost)");
        String response = keyboard.next();


    }
//-----------------------------------------------------------------------------
    public static boolean boatFile(String fileName,
                                    boatsAgain dealer) {

    ObjectOutputStream toStream = null;

    try {
        toStream = new ObjectOutputStream(new FileOutputStream(fileName));
        toStream.writeObject(dealer);
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
    public static boatsAgain loadFile(String fileName) {

        ObjectInputStream fromStream = null;
        boatsAgain local;

        try {
            fromStream = new ObjectInputStream(new FileInputStream(fileName));
            local = (boatsAgain)fromStream.readObject();
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
        return(local);
    }
//-----------------------------------------------------------------------------
/////////////
}