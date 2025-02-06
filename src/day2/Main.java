package day2;

import day2.OOP.Blog;
import day2.OOP.Student.Student;
import day2.OOP.Users.Admin;
import day2.OOP.Users.User;

public class Main {
    public static void main(String[] args) {
        // class biasa
        System.out.println("=== GET STUDENT ===");
        Student s1 = new Student("Imron", 70);
        s1.cekStatus();

        Student s2 = new Student("Dani", 90);
        s2.name = "Danu"; // update data.
        s2.score = 90;
        s2.cekStatus();


        // class encapsulasi
        System.out.println("=== GET BLOG ===");
        Blog myBlog = new Blog("Bootcamp AIGEN Batch III", "Open Registration");
        myBlog.displayInfo();
//        myBlog.getTitle();// untuk menampilkan title ini bisa



        // comments
        myBlog.addComment("Alwi", "Masih buka nggak min?");
        myBlog.addComment("Imron", "Apakah berbayar?");
        myBlog.displayComments();
        myBlog.setContent("Closed");
        myBlog.displayInfo();



        // inheritance
        System.out.println("=== GET USER ===");
        // class
        User userGuest = new User("imron");
        userGuest.displayInfo();

        // class child
        Admin userAdmin = new Admin("Alwi", true);
        userAdmin.displayInfo();
    }
}
