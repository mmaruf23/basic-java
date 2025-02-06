package day2.BasicOOP;

import day2.BasicOOP.Basic.Human;
public class Main {
    public static void main(String[] args) {
        // Instance creation dari class Human : proses bkin object baru dari sebuah class
        Human student = new Human("Imron", 25);


        // instance method : method yang bisa diakses oleh object yang menampunt suatu class.
        student.breath();
        student.fart();
    }
}
