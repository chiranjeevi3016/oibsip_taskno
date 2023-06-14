import java.util.Scanner;

public class ATMInterface {
    private static final String PIN = "1234";
    private static double balance = 1000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        // PIN verification
        System.out.print("Enter your PIN: ");
        String enteredPIN = scanner.nextLine();

        if (!enteredPIN.equals(PIN)) {
            System.out.println("Invalid PIN. Exiting...");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    depositCash(depositAmount);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");1234
            }
        }

        System.out.println("Thank you for using the ATM!");
    }

    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private static void withdrawCash(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    private static void depositCash(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }
}
