import booking.*;
import charges.Charges;
import java.util.*;
import searching.Searching;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("==================== Welcome to car parking service ====================");

        System.out.println("1. Book parking");
        System.out.println("2. Search parking");
        System.out.println("3. Calculate charges");
        System.out.println("4");
        System.out.println("5");
        System.out.print("Enter your choice: ");

        int whichFeature = input.nextInt();
        input.nextLine();

        if (whichFeature == 1) {
            Booking b1 = new Booking();
            b1.checkingSlots();   
            b1.bookSlot();
        } else if (whichFeature == 2) {
            Searching s1 = new Searching();
            s1.searchSlot();
        } else if (whichFeature == 3) {
            Charges c1 = new Charges();
            c1.calculateCharges();
        }
    }
}