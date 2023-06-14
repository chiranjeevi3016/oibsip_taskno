import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReservationSystem {
    private Map<String, Boolean> reservations;

    public ReservationSystem() {
        reservations = new HashMap<>();
    }

    public void makeReservation(String name) {
        if (reservations.containsKey(name)) {
            System.out.println("Sorry, this name is already reserved.");
        } else {
            reservations.put(name, true);
            System.out.println("Reservation successful for " + name);
        }
    }

    public void cancelReservation(String name) {
        if (reservations.containsKey(name)) {
            reservations.remove(name);
            System.out.println("Reservation canceled for " + name);
        } else {
            System.out.println("No reservation found for " + name);
        }
    }

    public void printReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Reservations:");
            for (String name : reservations.keySet()) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n===== Online Reservation System =====");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    system.makeReservation(name);
                    break;
                case 2:
                    System.out.print("Enter the name to cancel the reservation: ");
                    name = scanner.nextLine();
                    system.cancelReservation(name);
                    break;
                case 3:
                    system.printReservations();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Online Reservation System!");
    }
}
