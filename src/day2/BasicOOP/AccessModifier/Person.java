package day2.BasicOOP.AccessModifier;

import org.w3c.dom.ls.LSOutput;

public class Person {
    // Access modifier : kata kunci untuk mengatur aksesibilitas, visibilitas dari sebuah class, variabel, atau method.

    // public
    public String name; // bisa diakses dimana aja.

    //private
    private int age; // cuma bisa diakses dalam kelas sendiri (Person)

    // protected
    protected String address; // cuma bisa diakses oleh class sendiri (Person ) dan subclassnya.

    // Non-access modifier :
    // static
    public static int totalPerson = 0; // variabel static untuk ngasih nilai awal terhadap variabel

    //final
    public final String NATIONALITY = "Indonesian"; // untuk bikin nilai constant

    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
        totalPerson++;
    }

    // method
    public void displayInfo(){
        System.out.println("My name : " + name);
        System.out.println("My age : " + age);
        System.out.println("My address : " + address);
    }

    // method static untuk nampilin total object setiap kali object person bertambah
    public static void displayTotalPerson(){
        System.out.println("Total person : " + totalPerson);
    }
}
