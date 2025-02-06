package day2.Upcasting;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        User user1 = admin; // upcasting admin de user;

        user1.login(); // manggil method ke superclass
        // user1.adminStatus(); // error karen efek Upcast.

    }
}
