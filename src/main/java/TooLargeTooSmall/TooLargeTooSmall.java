package TooLargeTooSmall;
import java.util.Scanner;

/**
 * Created by evanhitchings on 9/9/16.
 */
public class TooLargeTooSmall {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        String answer = "wrong";
        System.out.println("Guess the secret number, from 1 - 100");
        while(!(answer.equalsIgnoreCase("Correct!"))){
            int guess = reader.nextInt();
            answer = gameLogic.makeAGuess(guess);
            System.out.println(answer);
        }

        System.out.println("The secret number was " + gameLogic.getSecretNumber() + ".");
        System.out.println("It took you only " + gameLogic.getGuesses().size() + " guesses");





    }
}
