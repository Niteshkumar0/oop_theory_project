package charges;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Charges {
    public void calculateCharges() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter entry time (HH:mm): ");
        String entryStr = input.nextLine();
        System.out.print("Enter exit time (HH:mm): ");
        String exitStr = input.nextLine();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");

        try {
            LocalTime entryTime = LocalTime.parse(entryStr, timeFormatter);
            LocalTime exitTime = LocalTime.parse(exitStr, timeFormatter);

            long minutesParked = ChronoUnit.MINUTES.between(entryTime, exitTime);
            if (minutesParked <= 0) {
                System.out.println(" Error: Exit time must be after entry time.");
                return;
            }

            double ratePerMinute = 20.0 / 60.0; 
            double totalCharges = minutesParked * ratePerMinute;

            long hours = minutesParked / 60;
            long minutes = minutesParked % 60;

            System.out.println(" Total parking time: " + hours + " hour, " + minutes + " minute");
            System.out.printf("Total charges: $%.2f\n", totalCharges);
        } catch (Exception e) {
            System.out.println("Invalid time format. Please enter time as HH:mm (e.g., 01:30 or 13:45).");
        }
    }
}
