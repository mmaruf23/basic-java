package day2.OOP.Test;
/*
* 1. Buat object/class student dengan atribut nama, nim dan nilai.
* lalu simpan data student tersebut kedalam arrayList
* kemudian buat method berikut :
* 1. Menghitung rata-rata nilai student
* 2. cari nilai tertinggi
* 3. tampilkan data student dengan nilai diatas rata-rata.*/

import java.util.ArrayList;

public class Main {

    static double avg;
    static int highest;

    public static void main(String[] args) {
        Student murid1 = new Student("murid1", 11111, 90);
        Student murid2 = new Student("murid2", 22222, 80);
        Student murid3 = new Student("murid3", 33333, 70);
        Student murid4 = new Student("murid4", 44444, 85);

        ArrayList<Student> students = new ArrayList<>(); // tampung data student
        students.add(murid1);
        students.add(murid2);
        students.add(murid3);
        students.add(murid4);

        System.out.println("=== VERSI 1 ===");
        System.out.println("Rata - Rata nilai : " + Student.getAvg());
        System.out.println("Nilai tertinggi : " + Student.nilaiTertinggi);

        System.out.println("Siswa dengan nilai di atas rata-rata : ");

        for (Student student : students){
            if (student.nilai > Student.getAvg()){
                student.displayInfo();
            }
        }

        System.out.println("");
        System.out.println("=== VERSI 2 ===");
        processData(students);
        System.out.println("Rata - Rata nilai : " + avg);
        System.out.println("Nilai tertinggi : " + highest);
        HigherStudents(students);


    }

    // Perulangan untuk mencari rata rata dan tertinggi
    static void processData(ArrayList<Student> students){
        double total = 0;

        for (Student student : students){
            total += student.nilai;
            highest = Math.max(highest, student.nilai);
        }
        avg = total / students.size();

    }

    static void HigherStudents(ArrayList<Student> students){
        System.out.println("Siswa dengan nilai di atas rata-rata : ");
        for (Student student : students){
            if (student.nilai > avg){
                System.out.println(" ");
                System.out.println(" Nama : " + student.nama);
                System.out.println(" NIM : " + student.nim);
                System.out.println(" Nilai : " + student.nilai);
            }
        }
    }



}
