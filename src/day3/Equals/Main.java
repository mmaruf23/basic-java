package day3.Equals;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<User> listUser = new ArrayList<>();

    public void registerUser(User user){listUser.add(user);}

    public void isUserRegistered(User user){
        if (listUser.contains(user)) {
            System.out.println(user.getUsername() + " is registered!");
        } else {
            System.out.println(user.getUsername() + " isn't registered!");
        }
    }

    public static void main(String[] args) {
        Main userController = new Main(); // instance dari object main.

        // register user baru
        User user1 = new User("rifa", "rifa@user.com");
        User user2 = new User("rafi", "rafi.user.com");
        userController.registerUser(user1);
        userController.registerUser(user2);

        // simulasi yang tidak terdaftar
        userController.isUserRegistered(user2);

        User userNotRegistered = new User("rafa", "rafa@user.com");
        userController.isUserRegistered(userNotRegistered);
    }
}
