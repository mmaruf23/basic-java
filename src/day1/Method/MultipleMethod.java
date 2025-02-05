package day1.Method;

public class MultipleMethod {
    // method external - method instance : method yang dimiliki sebuah object
    public static int multiple(int num1, int num2){
        return num1 * num2;
    }

    //method overload : biki  method dengan nama  yang sama tapi dengan hasil tipe data params yang beda.
    public static int multiple(int num1, int num2,int num3){
        return num1 * num2 * num3;
    }
    public static double multiple(double num1, double num2,double num3){
        return num1 * num2 * num3;
    }

}
