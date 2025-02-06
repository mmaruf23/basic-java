package day2.OOP.Test;

public class Student {
    private String nama;
    private int nim;
    public int nilai;
    private static int totalStudent;
    public static int totalNilai = 0;
    public static int nilaiTertinggi = 0;


    public Student(String nama, int nim, int nilai){
        this.nama = nama;
        this.nim = nim;
        this.nilai = nilai;
        totalNilai += nilai;
        totalStudent++;
        nilaiTertinggi = Math.max(nilaiTertinggi, nilai);
    }

    public static double getAvg(){
        return (double) totalNilai /totalStudent;
    }

    public void displayInfo(){
        System.out.println("");
        System.out.println(" Nama : " + this.nama);
        System.out.println(" NIM : " + this.nim);
        System.out.println(" Nilai : " + this.nilai);
    }

// versi dua




}


