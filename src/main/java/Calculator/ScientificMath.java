package Calculator;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.Math;
/**
 * Created by evanhitchings on 9/12/16.
 */
public class ScientificMath {
    private boolean radianTrue;

    public ScientificMath() {
        this.radianTrue = true;
    }

    public void switchUnitsMode(String switchTo){
        if(switchTo.equalsIgnoreCase("1")){
            this.radianTrue = true;
            return;
        } else {
            this.radianTrue = false;
            return;
        }


    }

    public boolean getMode(){
        return this.radianTrue;
    }

    public double sin(Double number){
        if(!(this.radianTrue)){
            return Math.sin(Math.toDegrees(number));
        }

        return Math.sin(number);
    }

    public double cos(Double number){
        if(!(this.radianTrue)){
            return Math.cos(Math.toDegrees(number));
        }

        return Math.cos(number);
    }

    public double tan(Double number){

        if(!(this.radianTrue)){
            return Math.tan(Math.toDegrees(number));
        }

        return Math.tan(number);
    }

    public double asin(Double number){
        if(!(this.radianTrue)){
            return Math.asin(Math.toDegrees(number));
        }


        return Math.asin(number);
    }

    public double acos(Double number){
        if(!(this.radianTrue)){
            return Math.acos(Math.toDegrees(number));
        }

        return Math.acos(number);
    }

    public double atan(Double number){
        if(!(this.radianTrue)){
            return Math.atan(Math.toDegrees(number));
        }
        return Math.atan(number);
    }

    public double log(Double number){
        return Math.log10(number);
    }

    public double inverseLog(Double number){
        return Math.exp(Math.log10(number));
    }

    public double ln(Double number){
        return Math.log(number);
    }

    public double inverseLn(Double number){
        return Math.pow(Math.E, number);
    }

    public double factorial(Double number){
        double toReturn = 1;
        for(double i = 1.0; i <= number; i++){
            toReturn *= i;
        }
        return toReturn;
    }




}
