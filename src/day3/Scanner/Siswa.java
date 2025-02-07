package day3.Scanner;

import java.util.Scanner;

public class Siswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan jumlah siswa : ");
        int jumlahSiswa = input.nextInt();
        input.nextLine();

        String[] namaSiswa = new String[jumlahSiswa];
        int[] umurSiswa = new int[jumlahSiswa];
        String[] kelas = new String[jumlahSiswa];
        double[] nilai = new double[jumlahSiswa];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Data siswa ke-" + (i + 1));
            System.out.println("Nama : ");
            namaSiswa[i] = input.nextLine();
            System.out.println("Usia : ");
            umurSiswa[i] = input.nextInt();
            input.nextLine();
            System.out.println("Kelas : ");
            kelas[i] = input.nextLine();
            System.out.println("Nilai : ");
            nilai[i] = input.nextDouble();
            input.nextLine();

            System.out.println("Nama : " + namaSiswa[i]);
        }

        double total = 0;
        for (int i = 0; i < jumlahSiswa; i++){
            total += nilai[i];
        }

        double rata2 = total/jumlahSiswa;
        System.out.println("Rata -rata nilai : " + rata2);
    }
}
