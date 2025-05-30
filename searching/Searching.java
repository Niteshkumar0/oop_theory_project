package searching;

import java.io.File;
import java.util.Scanner;

public class Searching {
    public void searchSlot() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the slot number you want to search for: ");
        int slotToSearch = input.nextInt();

        boolean found = false;

        try {
            File file = new File("booking.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] parts = line.split(",");
                int slot = Integer.parseInt(parts[0].trim());
                int status = Integer.parseInt(parts[1].trim());

                if (slot == slotToSearch) {
                    found = true;
                    if (status == 1) {
                        System.out.println("Car is found in slot " + slot + ".");
                    } else if (status == 0) {
                        System.out.println("Slot " + slot + " is empty.");
                    } else {
                        System.out.println("Unknown status for slot " + slot + ".");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Slot " + slotToSearch + " not found.");
            }

            read.close();
        } catch (Exception e) {
            System.out.println("Error reading the booking file.");
            e.printStackTrace();
        }
    }
}