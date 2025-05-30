import booking.*;
import java.util.*;
import searching.Searching;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("==================== Welcome to car parking service ====================");

        System.out.println("1. book parking");
        System.out.println("2. searching2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.print("enter ");

        int whichFeature = input.nextInt();

        // switch(whichFeature){
        //     case 1:
                

        // }
        if(whichFeature == 1){
            Booking b1 = new Booking();
            b1.checkingSlots();   
            b1.bookSlot();
        }
        else if (whichFeature == 2) {
            Searching s1 = new Searching();
            s1.searchSlot();
        }
        
    }
}