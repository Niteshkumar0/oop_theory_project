package booking;
import java.io.*;
import java.util.Scanner;
public class Booking{
    public void checkingSlots(){
        try {
            File file = new File("booking.txt");
            Scanner read = new Scanner(file);

            while(read.hasNextLine()){
                String line = read.nextLine();
                String[] parts = line.split(",");
                int avaiable = Integer.parseInt(parts[1]);
            

                if (avaiable == 0) {
                    System.out.println("Parking is avaible at slot "+parts[0]);
                } else {
                    System.out.println("Parking is not avaible at "+ parts[0] + "slot");

                }
            }
        } catch (Exception e) {
            System.out.println("File not found: booking.txt");
            e.printStackTrace();
        }

    }

    public int bookSlot() {
        System.out.print("Which number slot parking ? : ");
        Scanner input = new Scanner(System.in);
        int slotNumber = input.nextInt();
    
        String[] lines = new String[100]; 
        int lineCount = 0;
        boolean booked = false;
    
        try {
            File file = new File("booking.txt");
            Scanner read = new Scanner(file);
    
            while (read.hasNextLine()) {
                String data = read.nextLine();
                String[] parts = data.split(",");
                int slot = Integer.parseInt(parts[0]);
                int status = Integer.parseInt(parts[1]);
    
                if (slot == slotNumber) {
                    if (status == 0) {
                        status = 1; 
                        booked = true;
                    } else {
                        System.out.println("Slot already booked.");
                    }
                }
    
                lines[lineCount] = slot + "," + status;
                lineCount++;
            }
            read.close();
    
            if (booked) {
                FileWriter writer = new FileWriter("booking.txt");
                for (int i = 0; i < lineCount; i++) {
                    writer.write(lines[i] + "\n");
                }
                writer.close();
                System.out.println("Slot " + slotNumber + " booked successfully.");
            } else {
                System.out.println("Booking failed. Slot may already be booked or not found.");
            }
    
        } catch (Exception e) {
            System.out.println("File error.");
            e.printStackTrace();
        }
    
        return 0;
    }    
}