package Calculator;
import java.util.Scanner;

/**
 * Created by evanhitchings on 9/10/16.
 */
public class Display {


    private String currentDisplayString;
    private double currentDisplayDouble;
    private double memoryValue;

    private BasicMath basicMath;
    private ScientificMath scientificMath;
    private Scanner reader = new Scanner(System.in);
    private String displayMode;




    public Display(){
        this.currentDisplayString = "0";
        this.currentDisplayDouble = 0;
        this.basicMath = new BasicMath();
        this.scientificMath = new ScientificMath();
        this.displayMode = "DECIMAL";
        this.memoryValue = 0.00;

    }

    public void setCurrentDisplayString(Double currentValue) {
        this.currentDisplayString = "" + currentValue;
        this.currentDisplayString = this.displayModeConverter();
        //this.currentDisplayString = currentDisplayString.substring(0, 9);
        System.out.println(this.currentDisplayString);
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

    public void clearMemoryValue() {
        this.memoryValue = 0.00;
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
        setCurrentDisplayDouble(0.00);
        //this.setCurrentDisplayString(0.0);


    }


    public void setMemoryValue(double memoryValue) {
        this.memoryValue = memoryValue;
    }

    public void setCurrentDisplayDouble(double displayDouble) {
        this.currentDisplayDouble = displayDouble;
        setCurrentDisplayString(currentDisplayDouble);
        //System.out.println(currentDisplayString);

    }





    public void homeScreen(){
        String command;
        do {
            System.out.println(currentDisplayString);
            System.out.println("Choose an option: \n 1: Basic Math \n 2: Scientific Math \n C: Clear Screen \n Q: Quit");
            command = reader.nextLine();

            switch (command){
                case "1":
                    basicMathMenu();
                    break;
                case "2":
                    scientificMathMenu();
                    break;
                case "c":
                case "C":
                    clearDisplay();
                    break;
                case "q":
                case "Q":
                    return;
                default:
                    continue;
            }


        } while (!(command.equalsIgnoreCase("Q")));




    }

    public void basicMathMenu(){

        String command;
        setCurrentDisplayString(currentDisplayDouble);
       do {
           if (currentDisplayDouble == 0){
               setCurrentDisplayDouble(numberInput());
               setCurrentDisplayString(currentDisplayDouble);
           } else {
               System.out.println(currentDisplayString);

           }
           System.out.println("Choose an option: \n 1: Add \n 2: Subtract \n 3: Multiply \n 4: Divide \n 5: Square \n 6: SquareRoot \n 7: Exponent \n " +
                   "8: Inverse \n M+: Add Mem \n MC: Memory Clear \n MR: Memory Recall \n S: Switch Display Mode (Cycle) \n M: Switch Display Mode (Manual) \n C: Clear \n Q: Previous");
           command = reader.nextLine();
           switch (command){
               case "1":
                   setCurrentDisplayDouble(basicMath.add(numberInput(), currentDisplayDouble));
                   break;
               case "2":
                   setCurrentDisplayDouble(basicMath.subtract(currentDisplayDouble, numberInput()));
                   break;
               case "3":
                   setCurrentDisplayDouble(basicMath.multiply(numberInput(), currentDisplayDouble));
                   break;
               case "4":
                   try{
                       setCurrentDisplayDouble(basicMath.divide(currentDisplayDouble, numberInput()));
                   } catch (ArithmeticException e){
                       currentDisplayString = "err";
                       break;
                   }
                   break;
               case "5":
                   setCurrentDisplayDouble(basicMath.square(currentDisplayDouble));
                   break;
               case "6":
                   setCurrentDisplayDouble(basicMath.squareRoot(currentDisplayDouble));
                   break;
               case "7":
                   setCurrentDisplayDouble(basicMath.exponation(currentDisplayDouble, numberInput()));
                   break;
               case "8":
                   setCurrentDisplayDouble(basicMath.inverse(currentDisplayDouble));
                   break;
               case "m+":
               case "M+":
                   setMemoryValue(basicMath.add(currentDisplayDouble, memoryValue));
                   break;
               case "mc":
               case "MC":
                   clearMemoryValue();
                   break;
               case "mr":
               case "MR":
                   setCurrentDisplayDouble(memoryValue);
                   break;
               case "s":
               case "S":
                   switchDisplayMode();
                   break;
               case "c":
               case "C":
                   clearDisplay();
                   break;
               case "q":
               case "Q":
                   return;
               default:
                   break;
           }
           if(!(currentDisplayString.equalsIgnoreCase("err"))){
               setCurrentDisplayString(currentDisplayDouble);
               continue;
           }
           //setCurrentDisplayString(currentDisplayDouble);


       } while (!(command.equalsIgnoreCase("Q")));

    }

    public void scientificMathMenu(){
        String command;
        label1:
        do {
            if (currentDisplayDouble == 0) {
                setCurrentDisplayDouble(numberInput());
                setCurrentDisplayString(currentDisplayDouble);
            } else {
                System.out.println(currentDisplayString);
            }

            System.out.println("Choose an option: \n 1: Sin \n 2: Cos \n 3: Tan \n 4: Inverse Sin \n 5: Inverse Cos \n 6: Inverse Tan \n T: Change Trig Mode \n " +
                    "8: Log \n 9: Natural Log \n 10: Inverse Log \n 11: Inverse Natural Log \n 12: Facotiral \n " +
                    "M+: Add Mem \n MC: Memory Clear \n MR: Memory Recall \n S: Switch Display Mode \n M: Manual Switch Display Mode\n C: Clear \n Q: Previous");
            command = reader.nextLine();
            try {

                switch (command) {
                    case "1":
                        setCurrentDisplayDouble(scientificMath.sin(currentDisplayDouble));
                        break;
                    case "2":
                        setCurrentDisplayDouble(scientificMath.cos(currentDisplayDouble));
                        break;
                    case "3":
                        setCurrentDisplayDouble(scientificMath.tan(currentDisplayDouble));
                        break;
                    case "4":
                        setCurrentDisplayDouble(scientificMath.asin(currentDisplayDouble));
                        break;
                    case "5":
                        setCurrentDisplayDouble(scientificMath.acos(currentDisplayDouble));
                        break;
                    case "6":
                        setCurrentDisplayDouble(scientificMath.atan(currentDisplayDouble));
                        break;
                    case "t":
                    case "T":
                        clearDisplay();
                        System.out.println(this.currentDisplayString);
                        System.out.println("1: RADIANS \n2: DEGREES");
                        String modeSwitchCommand = reader.nextLine();
                        switch(modeSwitchCommand){
                            case "1":
                                scientificMath.switchUnitsMode("1");
                                break;
                            case "2":
                                scientificMath.switchUnitsMode("2");
                                break;
                            default:
                                break;
                        }

                    case "8":
                        setCurrentDisplayDouble(scientificMath.log(currentDisplayDouble));
                        break;
                    case "9":
                        setCurrentDisplayDouble(scientificMath.ln(currentDisplayDouble));
                        break;
                    case "10":
                        setCurrentDisplayDouble(scientificMath.inverseLog(currentDisplayDouble));
                        break;
                    case "11":
                        setCurrentDisplayDouble(scientificMath.inverseLn(currentDisplayDouble));
                        break;
                    case "12":
                        setCurrentDisplayDouble(scientificMath.factorial(currentDisplayDouble));
                        break;
                    case "m+":
                    case "M+":
                        setMemoryValue(basicMath.add(currentDisplayDouble, memoryValue));
                        break;
                    case "mc":
                    case "MC":
                        clearMemoryValue();
                        break;
                    case "mr":
                    case "MR":
                        setCurrentDisplayDouble(memoryValue);
                        break;
                    case "s":
                    case "S":
                        switchDisplayMode();
                        break;
                    case "m":
                    case "M":
                        String displayCommand = reader.nextLine();
                        switchDisplayMode(displayCommand);
                        break;
                    case "c":
                    case "C":
                        clearDisplay();
                        break;
                    case "q":
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
