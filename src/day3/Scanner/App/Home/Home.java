package day3.Scanner.App.Home;

import day3.Scanner.App.Products.ProductMain;

import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== MENU ===");
        System.out.println("- Login");
        System.out.println("- Register");
        System.out.println("- Products");
        System.out.println("- Cart");
        System.out.println("- Review");
        System.out.println("Pilih menu : ");

        // convert input ke huruf kapital
        Menu myMenu = Menu.valueOf(input.nextLine().toUpperCase());

        switch (myMenu){
            case LOGIN :
                System.out.println("Login success!");
                break;
            case REGISTER :
                System.out.println("Register success!");
                break;
            case PRODUCTS :
                System.out.println("Navigate to products page!");
                ProductMain.main(null);
                break;
            case CART :
                System.out.println("Navigate to cart page!");
                break;
            case REVIEW :
                System.out.println("Navigate to review page!");
                // buat menu review yang bisa nambahin nama reviewer dan rating (int), kemudian tampilin semua review.
                break;
        }
    }
}
