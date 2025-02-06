package day2.BasicOOP;
/*
 * BASIC OOP
 * Class : konsep dasar untuk bikin object atau kerangka kerja yang mendfinisikan karakteristrik dan perilaku suatu object
 * atau bisa dibilang class yang berisi fungsionalitas suatu program */
public class Basic { // class penampung
    public static class Human { // class static yang bisa dipanggil oleh class lainnya sebagai object.
        // class attribute : data yang dimiliki object.
        String name;
        int age;

        // constructor : method khusus yang menginisialisasikan object/mengatur nilai awal dari variabel class
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }

        // method : fungsi khusus yang dimiliki object.
        public void breath(){
            System.out.println(name + " is breathing. and he's age " + age + " years old");
        }

        public void fart(){
            System.out.println(name + " is farting!");
        }
    }
}
