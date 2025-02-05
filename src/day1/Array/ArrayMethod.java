package day1.Array;

import java.util.Arrays;

public class ArrayMethod {
    public static void main(String[] args) {
        System.out.println("=== REGULER ARRAY ===");
        int[] numbers = {1,2,3,4,5};
        System.out.println("Array length : " + numbers.length);
        numbers[4] = 7;

        System.out.println("=== Array Method ===");
        System.out.println("=== SORT");
        Integer sortArray[] = {2,4,7,3,5,6,1};
        Arrays.sort(sortArray);
        // method array untuk mengurutkan data ASC

        for (int i : sortArray){
            System.out.println("Sorted Array : " + i);
        }

        System.out.println("=== FILL");
        // method fill : method untuk mengisi semua indeks array dengan nilai yang sama.
        int[] fillNumbers = new int[5]; // membuat array dengan ukuran 5 index
        Arrays.fill(fillNumbers, 7); // buat ngisi semua data jadi 7
        for (int i : fillNumbers){
            System.out.println("fill : " + i);
        }

        System.out.println("=== COPY OF ARRAY");
        // method buat nyalin dari array lain
        int[] copyNumbers = Arrays.copyOf(numbers, numbers.length + 1);
        for (int i : copyNumbers){
            System.out.println("copy numbers : " + i);
        }

        // nyalin data dari array numbers ke array newNumbers dan tambahin panjang datanya 1
        int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);
        newNumbers[5] = 50;
        for (int i : newNumbers){
            System.out.println("newNumbers : " + i);
        }

        // copyOfrange array : menyalin array dari range tertentu
        System.out.println("=== COPY OF RANGE ARRAY");
        int[] rangeNumbers = Arrays.copyOfRange(numbers, 1, 4); //menyalin data array yang dimulai dari index 1 ke index 4
        for (int i : rangeNumbers){
            System.out.println("rangeNumbers : " + i);
        }

        // equals array : menyamakan 2 data array
        System.out.println("=== EQUALS ARRAY");
        int[] equalsNumbers1 = {1,2,3,4,5};
        int[] equalsNumbers2 = {1,2,3,4,5};
        boolean isEqual = Arrays.equals(equalsNumbers1, equalsNumbers2);
        System.out.println("isEquals : " + isEqual);

        System.out.println("=== CONVERT TO STRING");
        String arrayToString = Arrays.toString(newNumbers);
        System.out.println("Array to String : " + arrayToString);
    }
}
