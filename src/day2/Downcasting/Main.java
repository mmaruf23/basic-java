package day2.Downcasting;

/*
* Downcasting : mengubah superclass / parent jadi subclass / child class
* agar bisa pakai method / atribut yang spesifik dari subclass
* */

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin(); // bikin object admin
        Guest guest = new Guest();
        User user1 = admin; // bikin object user
        User user2 = guest;


        Admin admin1 = (Admin) user1; // downcasting User ke Admin;
        admin1.adminStatus(); // method yang ingin dipake superclass
        admin1.login(); // method yang masih bisa dipake superclass walau sudah downgrade

        Guest guest1 = (Guest) user2;
        guest1.guestStatus();
    }
}
