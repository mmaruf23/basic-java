package day1.Casting;

public class Main {
    public static void main(String[] args) {

        // konversi int ke string
        int number = 123;
        System.out.println("Number to string : " + Integer.toString(number));

        // koversi string ke int
        String numberString = "456";
        System.out.println("String to int : " + Integer.parseInt(numberString));

        // string to double
        String doubleString = "123.45";
        System.out.println("String to double : " + Double.parseDouble(doubleString));

        // string to boolean
        String booleanString = "true";
        System.out.println("String to boolean : " + Boolean.parseBoolean(booleanString));

        // int to double
        int intValue = 12;
        double doubleValue = intValue;
        System.out.println("Ini int : " + intValue);
        System.out.println("int to double : " + doubleValue);

        // double ke int
        int intValueFromDouble = (int) doubleValue;
        System.out.println("Double to int : " + intValueFromDouble);
    }


}
