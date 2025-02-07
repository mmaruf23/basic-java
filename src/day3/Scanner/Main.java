package day3.Scanner;

import java.util.Scanner;

public class Main {
    // import Scanner dari java buat bikin inputan ke terminal
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan nama : ");
        String nama = input.nextLine();
        System.out.println("Umur : ");
        int age = input.nextInt();
        input.nextLine(); // bikin karakter \n setelah membaca inputan khusus angka ( agar tidak stop setelahnya )
        System.out.println("Kelas : ");
        String kelas = input.nextLine();



        System.out.println("Halo, " + nama + " Umur : " + age + " Kelas : " + kelas);

        // buat nutup inputan
        input.close();
    }
}
