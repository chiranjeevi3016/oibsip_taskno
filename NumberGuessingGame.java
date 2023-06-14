import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int attempts = 0;
        boolean guessed = false;

        System.out.println("Welcome to the Number Guessing Game!");

        while (!guessed) {
            System.out.print("Enter your guess (between 1 and 100): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the secret number " + secretNumber + " in " + attempts + " attempts.");
                guessed = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for playing the Number Guessing Game!");
    }
}
