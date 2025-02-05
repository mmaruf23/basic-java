package day1.Basic;

/* Java : adalah bahasa programming OOP (Object Oriented Programming
* setiap class yang dimuat di dalam file java mewakili suatu object
* */
public class Basic {
    // Method main() : block kode yang akan mengeksekusi suatu perintah.
    public static void main(String[] args) {
        // variabel : buat wadah penyimpanan data
        // tipe data : jenis data yang disimpan didalam variabel.
        /*
        * cara buat variabel :
        * <tipe data> <nama variabel> = isi data */
        String nama = "Ruf";

        int age = 23;

        Boolean isStudent = true;

        // System.out.println : fungsi buat nampilin output ke terminal.
        System.out.println("My name is "+ nama + ", I'm " + age + ", years old, " + " my student status is " + isStudent);


        // array di java punya ukuran data yang statis, gabisa sembarangan ubah / tambah data. dan cuma bisa simpen 1 janis tipe data.
        System.out.println("=== ARRAY ===");
        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println("Array length : " + numbers.length);
        numbers[4] = 7;

        Integer integerNumber = 25;
        System.out.println("IntegerNumber :" + integerNumber);

        // looping tradisional
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("array ke - " + numbers[i]);
        }

        // object : tipe data campuran
        Object[] dataCampuran = {"rifa", 25};
        System.out.println(dataCampuran.length);
        // endhance looping
        for (Object i : dataCampuran) {
            System.out.println("dataCampuran : " + i);
        }

        // tipedata angka yang ukuran/kapasitasnya lebih besar dibanding int
        long longNumber = 123;
        System.out.println(longNumber);

        // tipe data untuk nilai pecahan.
        double doubleNUmber = 10.2;
        float floatNumber = 10;

        // concatenation : method untuk gabungin 2 string
        String firstName = "Rifa";
        String lastName = "Sella";
        System.out.println("basic : " + firstName + " " + lastName);
        System.out.println("concat : " + firstName.concat(lastName));

        // ENUM

        enum Grade {
            LULUS,
            TIDAK_LULUS
        }

        System.out.println("Status kelulusan anda : " + Grade.TIDAK_LULUS);
        System.out.println("Tapi bo'ong");
        System.out.println("Status kelulusan anda : " + Grade.LULUS);

    }
}
