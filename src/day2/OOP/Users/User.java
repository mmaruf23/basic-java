package day2.OOP.Users;

/*
* INHERITANCE
* Konsep untuk menurunkan sifat / perilaku parent class ke child class
* artinya class turunannya bisa menggunakan peroperti dan method milik parent
* child class (inheritance) ditandai dengan kunci 'extends'
* */

public class User {
    private String username;

    public User(String uname){username = uname;}

    public String getUsername(){return username;}

    public void displayInfo(){
        System.out.println("Username : " + username);
    }
}
