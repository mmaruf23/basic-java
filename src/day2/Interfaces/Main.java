package day2.Interfaces;

public class Main {
    public static void main(String[] args) {
        UserController akun1 = new UserController("imron", "1234");

        System.out.println("username : " + akun1.getUsername());
        System.out.println("password : " + akun1.getPassword());
        akun1.addUser("dimas", "12345");

        System.out.println("Total user : " + akun1.getAllUser());

        //default method
        akun1.getCompany();

        // memanggil static method tanpa menggunakan class
        User.setName("Dimas Tri Sulaksono");

        // manggil method dari role
        akun1.admin(true);
    }
}
