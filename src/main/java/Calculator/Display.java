package Calculator;
import java.util.Scanner;

/**
 * Created by evanhitchings on 9/10/16.
 */
public class Display {


    private String currentDisplayString;
    private double currentDisplayDouble;
    private double secondValue;
    private String operation;
    private BasicMath basicMath;
    private ScientificMath scientificMath;
    private Scanner reader = new Scanner(System.in);
    private String displayMode;




    public Display(){
        this.currentDisplayString = "0";
        this.currentDisplayDouble = 0;
        this.secondValue = 0;
        this.operation = "";
        this.basicMath = new BasicMath();
        this.scientificMath = new ScientificMath();
        this.displayMode = "DECIMAL";

    }

    public void setCurrentDisplayString(Double currentValue) {
        this.currentDisplayString = "" + currentValue;
        //this.currentDisplayString = currentDisplayString.substring(0, 9);
        System.out.println(this);
    }

    public String getCurrentDisplayString() {
        return currentDisplayString;
    }

    public double getCurrentDisplayDouble() {
        return currentDisplayDouble;
    }

    @Override
    public String toString(){
      if(this.currentDisplayString.equalsIgnoreCase("err")){
          System.out.println(this.currentDisplayString);
      }
     return displayModeConverter();


    }

    public String displayModeConverter(){
        double dubs = Double.valueOf(currentDisplayDouble);
        Integer toConvert = (int)dubs;
        switch (displayMode){
            case "OCTAL":
                this.currentDisplayString = "" + Integer.toOctalString(toConvert);
                break;
            case "HEX":
                this.currentDisplayString = "" + Integer.toHexString(toConvert);
                break;
            case "BINARY":
                this.currentDisplayString = "" + Integer.toBinaryString(toConvert);
                break;
            default:
                break;
        }
        return this.currentDisplayString;
    }

    public void clearDisplay(){
        for (int i = 0; i < 20; i++){
            System.out.println();
        }
        this.setCurrentDisplayString(0.0);
        this.currentDisplayDouble = 0;
        this.secondValue = 0;
    }




    public void setCurrentDisplayDouble(double currentDisplayDouble) {
        this.currentDisplayDouble = currentDisplayDouble;
        setCurrentDisplayString(currentDisplayDouble);
        System.out.println(currentDisplayString);

    }





    public void homeScreen(){
        String command;
        do {
            System.out.println(currentDisplayString);
            System.out.println("Choose an option: \n 1: Basic Math \n 2: Scientific Math \n 3: Change Display Mode \n C: Clear Screen \n Q: Quit");
            command = reader.nextLine();

            switch (command){
                case "1":
                    basicMathMenu();
                    break;
                case "2":
                    scientificMathMenu();
                    break;
                case "3":
                    //changeDisplayMenu();
                    break;
                case "C":
                    clearDisplay();
                    break;
                case "Q":
                    return;
                default:
                    continue;
            }


        } while (!(command.equalsIgnoreCase("Q")));




    }

    public void basicMathMenu(){

        String command;
       do {
           if (currentDisplayDouble == 0){
               setCurrentDisplayDouble(numberInput());
               setCurrentDisplayString(currentDisplayDouble);
           }
           System.out.println(currentDisplayString);
           System.out.println("Choose an option: \n 1: Add \n 2: Subtract \n 3: Multiply \n 4: Divide \n 5: Square \n 6: SquareRoot \n 7: Exponent \n " +
                   "8: Inverse \n S: Switch Display Mode \n C: Clear \n Q: Previous");
           command = reader.nextLine();
           switch (command){
               case "1":
                   currentDisplayDouble = basicMath.add(numberInput(), currentDisplayDouble);
                   break;
               case "2":
                   currentDisplayDouble = basicMath.subtract(numberInput(), currentDisplayDouble);
                   break;
               case "3":
                   currentDisplayDouble = basicMath.multiply(numberInput(), currentDisplayDouble);
                   break;
               case "4":
                   try{
                       currentDisplayDouble = basicMath.divide(numberInput(), currentDisplayDouble);
                   } catch (ArithmeticException e){
                       currentDisplayString = "err";
                       break;
                   }
                   break;
               case "5":
                   currentDisplayDouble = basicMath.square(currentDisplayDouble);
                   break;
               case "6":
                   currentDisplayDouble = basicMath.squareRoot(currentDisplayDouble);
                   break;
               case "7":
                   currentDisplayDouble = basicMath.exponation(currentDisplayDouble, numberInput());
                   break;
               case "8":
                   currentDisplayDouble = basicMath.inverse(currentDisplayDouble);
                   break;
               case "S":
                   //switchDisplayLogic();
                   break;
               case "C":
                   clearDisplay();
                   break;
               case "Q":
                   return;
               default:
                   break;
           }
           if(!(currentDisplayString.equalsIgnoreCase("err"))){
               //setCurrentDisplayString(currentDisplayDouble);
               continue;
           }


       } while (!(command.equalsIgnoreCase("Q")));

    }

    public void scientificMathMenu(){
        String command;
        label1:
        do {
            if (currentDisplayDouble == 0) {
                setCurrentDisplayDouble(numberInput());
                setCurrentDisplayString(currentDisplayDouble);
            }
            System.out.println(currentDisplayString);
            System.out.println("Choose an option: \n 1: Sin \n 2: Cos \n 3: Tan \n 4: Inverse Sin \n 5: Inverse Cos \n 6: Inverse Tan \n T: Change Trig Mode \n " +
                    "8: Log \n 9: Natural Log \n 10: Inverse Log \n 11: Inverse Natural Log \n 12: Facotiral \n S: Switch Display Mode \n M: Manual Switch Display Mode\n C: Clear \n Q: Previous");
            command = reader.nextLine();
            try {

                switch (command) {
                    case "1":
                        currentDisplayDouble = scientificMath.sin(currentDisplayDouble);
                        break;
                    case "2":
                        currentDisplayDouble = scientificMath.cos(currentDisplayDouble);
                        break;
                    case "3":
                        currentDisplayDouble = scientificMath.tan(currentDisplayDouble);
                        break;
                    case "4":
                        currentDisplayDouble = scientificMath.asin(currentDisplayDouble);
                        break;
                    case "5":
                        currentDisplayDouble = scientificMath.acos(currentDisplayDouble);
                        break;
                    case "6":
                        currentDisplayDouble = scientificMath.atan(currentDisplayDouble);
                        break;
                    case "7":
                        clearDisplay();
                        System.out.println(this.currentDisplayString);
                        System.out.println("1: RADIANS \n 2: DEGREES");
                        String modeSwitchCommand = "";
                        while(!(modeSwitchCommand.equalsIgnoreCase("1")) || !(modeSwitchCommand.equalsIgnoreCase("2")));
                        modeSwitchCommand = reader.nextLine();

                        scientificMath.switchUnitsMode(modeSwitchCommand);
                        break;
                    case "8":
                        currentDisplayDouble = scientificMath.log(currentDisplayDouble);
                        break;
                    case "9":
                        currentDisplayDouble = scientificMath.ln(currentDisplayDouble);
                        break;
                    case "10":
                        currentDisplayDouble = scientificMath.inverseLog(currentDisplayDouble);
                        break;
                    case "11":
                        currentDisplayDouble = scientificMath.inverseLn(currentDisplayDouble);
                        break;
                    case "12":
                        currentDisplayDouble = scientificMath.factorial(currentDisplayDouble);
                        break;
                    case "S":
                        switchDisplayMode();
                        break;
                    case "M":
                        String displayCommand = reader.nextLine();
                        switchDisplayMode(displayCommand);

                    case "C":
                        clearDisplay();
                        break;
                    case "Q":
                        return;
                    default:
                        break;

                }
            } catch (ArithmeticException e) {
                currentDisplayString = "err";
                break label1;

            }


        } while(!(command.equalsIgnoreCase("Q")));


    }

    public void switchDisplayMode(){
        if(this.displayMode.equalsIgnoreCase("DECIMAL")){
            this.displayMode = "HEX";
            return;
        } else if (this.displayMode.equalsIgnoreCase("HEX")){
            this.displayMode = "BINARY";
            return;
        } else if (this.displayMode.equalsIgnoreCase("BINARY")){
            this.displayMode = "OCTAL";
        } else {
            this.displayMode = "DECIMAL";
        }
    }

    public void switchDisplayMode(String displayMode){
        System.out.println("DECIMAL \n HEX \n BINARY \n OCTAL");
        switch(displayMode){
            case "DECIMAL":
                this.displayMode = "DECIMAL";
                break;
            case "HEX":
                this.displayMode = "HEX";
                break;
            case "OCTAL":
                this.displayMode = "OCTAL";
                break;
            case "BINARY":
                this.displayMode = "BINARY";
                break;
            default:
                return;

        }

    }



    public double numberInput(){
        System.out.println("Input a number:");
        double numInput = 0.00;
        do {
            try {
                numInput = reader.nextDouble();
            } catch (NumberFormatException e) {
                continue;
            }
        } while (numInput == 0.00);
        return numInput;

    }












}
