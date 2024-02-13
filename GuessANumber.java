import java.util.Scanner;
import java.util.Random;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playGame(scanner, 1, 100, 1);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }

        scanner.close();
    }

    public static void playGame(Scanner scanner, int minRange, int maxRange, int level) {
        int attempts = 0;
        Random random = new Random();

        System.out.println("Welcome to level " + level + " of 'Guess A Number' by Ivelina Ivanova!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        while (true) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();
            boolean isValid = isNumber(input);

            if (isValid) {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                    System.out.println("Number of attempts: " + attempts);
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        int maxLevel = 10;
        if (level < maxLevel) {
            System.out.print("Do you want to play the next level? (yes/no): ");
            String nextLevelChoice = scanner.nextLine().toLowerCase();
            if (nextLevelChoice.equals("yes") || nextLevelChoice.equals("y")) {
                int nextMinRange = maxRange + 1;
                int nextMaxRange = maxRange * 2;
                playGame(scanner, nextMinRange, nextMaxRange, level + 1);
            }
        }
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}