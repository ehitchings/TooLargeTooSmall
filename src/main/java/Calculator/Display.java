package Calculator;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by evanhitchings on 9/10/16.
 */
public class Display {

    private String currentDisplayValue;
    private double firstValue;
    private double secondValue;
    private String operation;
    private BasicMath basicMath;
    private Scanner reader = new Scanner(System.in);
    private ArrayList<String> operators;



    public Display(){
        this.currentDisplayValue = "0";
        this.firstValue = 0;
        this.secondValue = 0;
        this.operation = "";
        this.basicMath = new BasicMath();
        this.operators = new ArrayList<String>();
        //I feel dirty for doing this...
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

    }

    public void setCurrentDisplayValue(String updatedCurrentDisplay) {
        this.currentDisplayValue = updatedCurrentDisplay;
        this.currentDisplayValue = currentDisplayValue.substring(0, 9);
    }

    public String getCurrentDisplayValue() {
        return currentDisplayValue;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void clearDisplay(){
        for (int i = 0; i < 20; i++){
            System.out.println();
        }


    }

    public double getSecondValue() {
        return secondValue;
    }

    public String getOperation() {
        return operation;
    }



    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
        setCurrentDisplayValue("" + firstValue);
        System.out.println(this);

    }

    public void setOperation(String operation) {
        this.operation = operation;
        System.out.println(this);
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
        setCurrentDisplayValue("" + secondValue);
        System.out.println(this);
    }

    public double numberInput(){
        Double numInput = null;
        do {
            try {
                numInput = Double.parseDouble(reader.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
        } while (numInput != null);
        setSecondValue(numInput);
        setCurrentDisplayValue("" + numInput);

        Double input = reader.nextDouble();
    }

    //THIS IS HOT GARBAGE!!1! REFACTOR TO 3 METHODS, ONE FOR EACH INPUT NEEDED?
    //UPDATE: STILL TERRIBLE!
    public void displayInterface() {

        while(true){
            System.out.println(this);
            String userInput = reader.nextLine();
            if (operators.contains(userInput)){
                setOperation(userInput);
                setFirstValue(Double.parseDouble(currentDisplayValue));
                setSecondValue(numberInput());

            } else try {
                setFirstValue(Double.parseDouble(userInput));

            } catch (NumberFormatException e) {
                System.out.println("You must type a number!");
                clearDisplay();
                //System.out.println(this);
                continue;
            }


        }


        //System.out.println("Input your first number:");

        Double firstValueInput = null;
        label1:
        do {
            System.out.println(this);

            try {
                firstValueInput = Double.parseDouble(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You must type a number!");
                continue;

            }
        } while (firstValueInput != null);
        setFirstValue(firstValueInput);

        String operation = null;
        //System.out.println("What would you like to do?");
        //System.out.println(basicMath.);
        label2:
        while (!(this.operators.contains(operation))) {
            operation = reader.nextLine();
        }
        setOperation(operation);

        Double secondValueInput = null;
        /*label3:
        do {
            try {
                secondValueInput = Double.parseDouble(reader.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
        } while (secondValueInput != null);
        setSecondValue(secondValueInput);
        */
        doMath();



    }


    //THIS DOES WAY MORE THAN A SINGLE THING! I AM A BAD PERSON!
    public double doMath(){

        switch (operation) {
            case "+":
                try {
                    return basicMath.add(firstValue, secondValue);
                } catch (ArithmeticException e){
                    setCurrentDisplayValue("err");
                    return 0.00;
                }
                //Why is these breaks unreachable? is it because addition can never have an arithmeticexception?
                //break;
            case "-":

                try {
                    return basicMath.subtract(firstValue, secondValue);
                } catch (ArithmeticException e){
                    setCurrentDisplayValue("err");
                    return 0.00;
                }
                //break;
            case "*":
                try {
                    return basicMath.multiply(firstValue, secondValue);
                } catch (ArithmeticException e) {
                    setCurrentDisplayValue("err");
                    return 0.00;
                }
                //break;
            case "/":
                try{
                    return basicMath.divide(firstValue, secondValue);
                } catch (ArithmeticException e) {
                    setCurrentDisplayValue("err");
                    return 0.00;
                }
                //break;
            default:
                return 0.00;


        }
    }
    /*public void updateDisplay(String string){

        this.currentDisplayValue += string;
    }*/

    public String toString(){
        //clearDisplay();
        return this.currentDisplayValue;
    }

}


