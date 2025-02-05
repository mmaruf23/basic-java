package day1.Day1Test;

import java.util.Arrays;

public class Day1Test {
    public static void main(String[] args) {
        /* 1. Buat logic untuk ngecek apakah sebuah bilangan adalah bilangan prima */
        System.out.println("== SOAL 1");
        int bil = 7;
        Boolean isPrime = true;
        for (int i = 2; i < bil; i++){
            if (bil % i == 0){
                System.out.println(bil + " bukan bilangan prima!");
                isPrime = false;
                break;
            }
        }
        if (isPrime){
            System.out.println(bil + " adalah bilangan prime");
        }

        /* 2. Buat logic untuk nyari nilai terbesar dan terkecil dari sebuah array pake math method */
        System.out.println("== SOAL 2");
        int[] angka = {2,3,1,4,5,6,7,8,9,10};
        int terbesar = angka[0];
        int terkecil = angka[0];
        for (int i : angka) {
            terkecil = Math.min(terkecil, i);
            terbesar = Math.max(terbesar, i);
        }
        System.out.println("Angka terkecil : " + terkecil);
        System.out.println("Angka terbesar : " + terbesar);


        /* 3. Buat logic untuk nyari jumlah element yang nilainya genap dan jumlah elemen yang nilainya ganjil dari array angka */
        System.out.println("== SOAL 3");

        int ganjil = 0;
        int genap = 0;
        for (int i : angka){
            if (i % 2 == 0){
                genap++;
            } else {
                ganjil++;
            }
        }

        System.out.println("Jumlah bilangan genap : " + genap);
        System.out.println("Jumlah bilangan ganjil : " + ganjil);

        /* 4. Buat logic untuk menghitung jumlah karakter dalam sebuah string */
        System.out.println("== SOAL 4");

        String kata = "aku sedang belajar java";
        System.out.println("Jumlah karakter dalam kata : " + kata.length());

        /* 5. Buat logic untuk menghitung jumlah huruf vokal dalam string 'kata' */
        System.out.println("== SOAL 5");

        String[] arrKata = kata.split("");

        int vocal = 0;
        for (String i : arrKata){
            if (i.equalsIgnoreCase("a")) vocal++;
            if (i.equalsIgnoreCase("i")) vocal++;
            if (i.equalsIgnoreCase("u")) vocal++;
            if (i.equalsIgnoreCase("e")) vocal++;
            if (i.equalsIgnoreCase("o")) vocal++;
        }
        System.out.println("Jumlah huruf vokal dalam kata : " + vocal);


        /* 6. Buat array yang terdiri dari 5 mahasiswa, masing-masing punya 3 nilai : ujian, absen, kuis
        * kalkulasi nilai mereka berdasarkan rata-rata nilai dari nilai tersebut
        * lalu tentukan Grade mereka berdasarkan nilai rata-rata mereka menggunakan logic if-else dan ENUM */
        System.out.println("== SOAL 6");
        int[][] mahasiswa = {
                {10,10,9},
                {6,9,9},
                {9,2,9},
                {9,3,9},
                {8,9,8},
        };
        enum grade {
            A,B,C,D,E,F
        };
        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.print("Nilai mahasiswa" + (i+1) + " : ");
            int nilai = 0;
            for (int j = 0; j < mahasiswa[i].length; j++) {
                nilai += mahasiswa[i][j];
            }
//            System.out.print("total nilai :" + nilai);
            int rata2 = nilai / 3;
//            System.out.println("rata-rata : " + rata2);
            if (rata2 >= 9) {
                System.out.println(grade.A);
            } else if (rata2 >= 8) {
                System.out.println(grade.B);
            } else if (rata2 >= 7) {
                System.out.println(grade.C);
            } else if (rata2 >= 6) {
                System.out.println(grade.D);
            } else if (rata2 >= 5) {
                System.out.println(grade.E);
            } else {
                System.out.println(grade.F);
            }
        }
    }
}
