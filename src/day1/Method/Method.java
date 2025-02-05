package day1.Method;

// cara import method external/instance
import static day1.Method.MultipleMethod.*;
import static day1.Method.Animal.sound;

public class Method {
    // Method : fungsi untuk menjalankan duatu perinta/ perilaku tertentu -- fungsi.

    /*
    * public static int add(int num1, int num2){} cara membuat method
    * public static : access modifier agar method ini bisa diakses secara global.
    * int add(params) : method/fungsi dengan return integer.
    * return : buat ngembaliin nilai.
    *  */
    public static int cekNilai(int nilai){
        if (nilai >- 80){
            System.out.println("Lulus");
        } else {
            System.out.println("Tidak Lulus");
        }
        return nilai;
    }

    public static int add(int num1, int num2){
        return num1 + num2;
    }
    public static void main(String[] args) {
        // cara jalanin method
        int result = add(5, 2);
        System.out.println("Sum : " + result);

        cekNilai(90);

        System.out.println("== METHOD OVERLOAD");
        System.out.println("Multiple : " + multiple(1, 3));
        System.out.println("Multiple : " + multiple(1, 2, 3));
        System.out.println("Multiple : " + multiple(1.2, 3.2, 3.2));

        System.out.println("== METHOD OVERRIDE");
        System.out.println(sound()); // parent yang return asli
        System.out.println(Cat.sound()); // child yang mereplace method parent


        System.out.println("== INSTANCE METHOD");
        Animal hewan = new Animal();
        System.out.println(hewan.sound());

        Cat kocheng = new Cat();
        System.out.println(kocheng.sound());
    }
}
