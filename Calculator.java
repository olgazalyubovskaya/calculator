import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    static Scanner symbolInput = new Scanner(System.in);
    static char typeOfNumber;

    public static void main(String[] args) {
        //calculator presentation
        System.out.println("- The calculator can perform addition, subtraction, multiplication and division operations " +
                "with two numbers: a + b, a - b, a * b, a / b\n" +
                "- The calculator knows how to work with Arabic and Roman (from I to X) numbers. \n" +
                "- An expression can contain numbers of the same type: II + 2 - an invalid expression.\n");

     do{
         typeOfNumber = getTypeOfNumber();

         int firstNumber = getNumber();
         int secondNumber = getNumber();

         char operator = getOperation();
         int result = calculation(firstNumber,secondNumber,operator);
         System.out.println("Результат операции: "+result);
         System.out.println("Хотите продолжить вычисления? - нажмите 1 и клавишу enter");
     }while(symbolInput.nextInt()==1);

    }


    //receiving of Arabic numbers from the user
    public static int getArabicNumber() {
        int arabicNumber;
        System.out.println("Input your ArabicNumber: ");
        if (symbolInput.hasNextInt()) {
            arabicNumber = symbolInput.nextInt();
        }else{
            System.out.println("Wrong input of Arabic numbers, try again.: ");
            symbolInput.next();
            arabicNumber = getArabicNumber();
        }
        return arabicNumber;
    }

    //receiving of Roman numbers from the user
    public static String getRomanNumber(){
        Scanner symbolInput = new Scanner(System.in);
        String romanNumber;
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        ArrayList<String> containRomanNumbers = new ArrayList<>(Arrays.asList(romanNumbers));
        do{
            System.out.println("Input Roman number (I, II, III, IV, V, VI, VII, VIII, IX, X): ");
            romanNumber = symbolInput.nextLine();
        }while(!containRomanNumbers.contains(romanNumber));
        return romanNumber;
    }

    //Roman numbers conversion
    public static int getConvertRomanNumber(String romanNumber){
        int convertRomanNumber;
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        convertRomanNumber = Arrays.asList(romanNumbers).indexOf(romanNumber) + 1;
        return convertRomanNumber;
    }

    //getting numbers to calculate
    public static int getNumber(){
        int number;
        if (typeOfNumber == 'a') {
            number = getArabicNumber();
        } else {
            number = getConvertRomanNumber(getRomanNumber());
        }
        return number;
    }

    //receiving of type number from the user
    public static char getTypeOfNumber(){
        System.out.println("If you want to work with Arabic numbers input - a, " +
                "If you want to work with Roman numbers input - r: ");
        if(symbolInput.hasNext()){
            typeOfNumber = symbolInput.next().charAt(0);
        } else {
            System.out.println("Wrong input of operator, try again. " +
                    "If you want to work with Arabic numbers input - a, " +
                    "If you want to work with Roman numbers input - r: : ");
            symbolInput.next();
            typeOfNumber = getTypeOfNumber();
        }
        switch (typeOfNumber) {
            case 'a':
                typeOfNumber = 'a';
                break;
            case 'r':
                typeOfNumber = 'r';
                break;
            default:
                System.out.println("Wrong type of number. Repeat entry");
                getTypeOfNumber();
                break;
        }
        return typeOfNumber;
    }

    //receiving of operator from the user
    public static char getOperation(){
//        Scanner symbolInput = new Scanner(System.in);
        char operator;
        System.out.println("Input your operator (/ or * or - or +): ");
        if(symbolInput.hasNext()){
            operator = symbolInput.next().charAt(0);
        } else {
            System.out.println("Wrong input of operator, try again.: ");
            symbolInput.next();
            operator = getOperation();
        }
        return operator;
    }

    //calculation
    public static int calculation(int firstNumber, int secondNumber, char operator){
        int result;
        switch (operator){
            case '+':
                result = firstNumber + secondNumber;
                break;
            case  '-':
                result = firstNumber - secondNumber;
                break;
            case  '*':
                result = firstNumber * secondNumber;
                break;
            case  '/':
                result = firstNumber / secondNumber;
                break;
            default:
                System.out.println("Wrong operation. Repeat entry");
                result = calculation(firstNumber, secondNumber, getOperation());
        }
        return result;
    }
}
