package Calculator;
import java.lang.Math;
/**
 * Created by evanhitchings on 9/11/16.
 */
public class BasicMath {

    public BasicMath() {
    }

    public double add(Double first, Double second){
        return first + second;

    }

    public double subtract(Double first, Double second){
        return first - second;
    }

    public double multiply(Double first, Double second){
        return first * second;
    }

    public double divide (Double first, Double second){
        return first / second;
    }

    public double square (Double numberToSquare){
        return numberToSquare * numberToSquare;
    }

    public double squareRoot(Double numberToRoot){
        return Math.sqrt(numberToRoot);
    }

    public double exponation(Double base, Double pow){
        return Math.pow(base, pow);
    }

    public double inverse(Double numberToInverse){
        return 1 / numberToInverse;
    }

    public double switchNegAndPos(Double number){
        return number * -1;
    }


}
