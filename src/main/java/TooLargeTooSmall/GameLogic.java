package TooLargeTooSmall;
import java.math.*;
import java.util.ArrayList;

/**
 * Created by evanhitchings on 9/9/16.
 */
public class GameLogic {
    private int secretNumber;
    private ArrayList<Integer> guesses;


    public GameLogic() {
        this.secretNumber = (int)(Math.random()*100) + 1;
        this.guesses = new ArrayList<Integer>();
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(int guessNumber){
        if(!(guesses.contains(guessNumber))){
            guesses.add(guessNumber);
        }
    }

    public String makeAGuess(int number){
        this.addGuess(number);
        if(number > this.secretNumber){
            return "Too Large";
        } else if (number < this.secretNumber) {
            return "Too Small";
        } else {
            return "Correct!";
        }
    }
}
