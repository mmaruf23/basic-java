package day3.ExceptionHandling;

public class TryCatch {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};

        try {
            // cek nilai di index ke-3
            int checkNumber = numbers[2];
            System.out.println("Nilai yang diakses : " + checkNumber);
        } catch (ArrayIndexOutOfBoundsException e){
            // error handling jika gagal
            System.out.println("Index array tidak valid!");
            System.out.println("Error mesage : " + e.getMessage());
        }
    }
}
