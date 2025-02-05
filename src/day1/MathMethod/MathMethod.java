package day1.MathMethod;

public class MathMethod {
    public static void main(String[] args) {
        float pi = (float) Math.PI;
        System.out.println("Math.PI : "+pi);

        double floorValue = Math.floor(3.8); // bulat ke atas
        System.out.println("Math.floor : "+floorValue);

        double ceilValue = Math.ceil(3.2); // bulat ke bawah
        System.out.println("Math.ceil : "+ceilValue);

        double roundValue = Math.round(3.4); // bulat terdekat
        System.out.println("Math.round : "+roundValue);

        double squareValue = Math.sqrt(64); // ngitung akar
        System.out.println("Math.sqrt : " + squareValue);

        double powerOfTwo = Math.pow(4,2);
        System.out.println("Math.pow : " + powerOfTwo);

        int min = Math.min(10,5);
        System.out.println("Math.min : " + min);

        int max = Math.max(10,5);
        System.out.println("Math.max : " + max);

        double randomValue = Math.random();
        System.out.println("Math.random : " + randomValue);
    }
}
