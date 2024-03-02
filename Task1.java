import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    static int attemptLimit = 3;
    static int attemptCounter = 0;
    static int roundsPlayed = 0;
    static int userWins = 0;
    static boolean playAgain = true;
    static Random random = new Random();
    static int max = 100, min = 1;
    static int secretNumber;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (playAgain){
            playGame();
        }
        System.out.println("Rounds played: " + roundsPlayed + "\t Wins: " + userWins);
    }

    static void playGame() {
        System.out.println("Welcome to the game!");
        secretNumber = random.nextInt((max - min + 1) + min);
        while (attemptCounter < attemptLimit){
            guessNumber();
        }
        System.out.println("The correct answer was " + secretNumber);
        roundsPlayed++;
        System.out.println();
        playAgain();
    }

    static void guessNumber() {
        System.out.println("Guess the secret number between 1 and 10:");
        int userGuess = 0;
        try {
            userGuess = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // discard the non-integer input
            return; // skip the rest of the loop
        }
        if (userGuess > secretNumber){
            System.out.println("Wrong, too high!\n");
        }
        else if (userGuess < secretNumber) {
            System.out.println("Wrong, too low!\n");
        }
        else{
            System.out.println("You win!");
            userWins++;
            return;
        }
        attemptCounter++;
    }

    static void playAgain() {
        String proceedToPlay = "";
        while (!proceedToPlay.equalsIgnoreCase("y") && !proceedToPlay.equalsIgnoreCase("n")) {
            System.out.println("Do you want to play another round?: (Y/N)");
            proceedToPlay = scanner.next();
            if (!proceedToPlay.equalsIgnoreCase("y") && !proceedToPlay.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
        if (proceedToPlay.equalsIgnoreCase("n")){
            playAgain = false;
        }
        else{
            attemptCounter = 0;
        }
    }

}
