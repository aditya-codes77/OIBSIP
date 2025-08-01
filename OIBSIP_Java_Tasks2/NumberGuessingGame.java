import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("\n===== Welcome to Number Guessing Game =====\n");

        while (playAgain) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("I have picked a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("Can you guess it in " + maxAttempts + " attempts?\n");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("\n🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10;
                    hasWon = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.\n");
                } else {
                    System.out.println("Too high! Try again.\n");
                }
            }

            if (!hasWon) {
                System.out.println("\n😞 You've used all attempts. The number was: " + randomNumber);
            }

            System.out.println("Your current score: " + score);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
            System.out.println();
        }

        System.out.println("Thanks for playing! Your final score is: " + score);
        scanner.close();
    }
}