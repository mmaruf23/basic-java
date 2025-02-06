package day2.OOP.Users;

// ini adalah child class implementasi dari inhertance
// child class Admin inherit from parent class User
public class Admin extends  User{
    private boolean isAdmin;

    public Admin(String username, boolean role){
        super(username); // manggil variabel milik class parent (User);
        isAdmin = role;
    }

    // overwrite method si parent.
    @Override
    public void displayInfo(){
        System.out.println("Admin username : " + getUsername());
        System.out.println( "Is Admin : " + isAdmin);
    }
}
