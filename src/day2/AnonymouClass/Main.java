package day2.AnonymouClass;

/*
* ANONYMOUS CLASS : class yang sementara yang mewarisi class parentnya
* ini cara singkat / sekali pake buat ngasih fungsi tambahan pada class dan interface yang sudah ada
* dari pada membuat class baru yang terpisah
* */

public class Main {
    public static void main(String[] args) {
        User user = new User("Rifa", 23);

        UserInterface userActions = new UserInterface() {
            @Override
            public void displayUser() {
                System.out.println("Username : " + user.getName());
                System.out.println("User Age : " + user.getAge());
            }

            @Override
            public void updateUser() {
                System.out.println("User updated!");
            }
        };
        userActions.displayUser();
        userActions.updateUser();
    }
}
