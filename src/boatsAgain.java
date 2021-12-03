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

        double paid = 0;
        paid += boats.getPurchasePrice();
        double spent = 0;
        spent += boats.getMaintenancePrice();

        System.out.println("Fleet Report: ");
        for(boats boat:boatList)
            System.out.println(boat.toString());
            System.out.print("Total                                             : Paid $" + paid + ": Spent $     " + spent);
    }

//-----------------------------------------------------------------------------

//-----------------------------------------------------------------------------
/////////////
}