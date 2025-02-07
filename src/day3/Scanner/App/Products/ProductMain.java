package day3.Scanner.App.Products;

import java.util.Scanner;

public class ProductMain {
    public static void main() {
        Products.ProductController productController = new Products.ProductController();

        Scanner input = new Scanner(System.in);
        System.out.println("=== PRODUCT LIST ===");
        productController.displayProducts();
        System.out.println("====================");

        System.out.println("Apakah anda ingin menambahkan product baru? (Y/N) : ");
        String addProductChoice = input.nextLine().toLowerCase();

        if (addProductChoice.equals("y")){
            System.out.println("Masukan jumlah product : ");
            int jumlahProduct = input.nextInt();
            input.nextLine();

            for (int i = 0; i < jumlahProduct; i++) {
                System.out.println("Data product ke - " + (i + 1));
                System.out.println("Nama : ");
                String nama = input.nextLine();
                System.out.println("Harga : ");
                double harga = input.nextDouble();
                input.nextLine();
                System.out.println("Kategori : ");
                String category = input.nextLine();

                Products products = new Products(nama, harga, category);
                productController.addProducts(products);

            }

        }

        System.out.println("=== PRODUCT LIST ===");
        productController.displayProducts();
        System.out.println("====================");

        System.out.println("=== SORT PRODUCTS BY PRICE ===");
        // sort method
        System.out.println("====================");

        System.out.println("Apakah anda ingin mencari product? (Y/N) : ");
        // method & logic untuk nyari product berdasarkan nama

        // buat method save product ke file.

        // buat method read file product
    }
}
