package day2.Downcasting;

// Superclass / Parent class
public class User {
    void login(){
        System.out.println("Login success!");
    }
}

// Subclass
class Admin extends User {
    void adminStatus(){
        System.out.println("Hi, Admin");
    }
}

// Subclass
class Guest extends User {
    void guestStatus(){
        System.out.println("Hi, Guest");
    }
}