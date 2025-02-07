package day3.Scanner.App.Products;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Products.ProductController productController = new Products.ProductController();

        Scanner input = new Scanner(System.in);
        // data mock
        Products products1 = new Products("sabun", 1000, "category");
        Products products2 = new Products("suban", 2000, "category");
        Products products3 = new Products("saban", 3000, "category");
        Products products4 = new Products("subun", 4000, "category");
        productController.addProducts(products2);
        productController.addProducts(products3);
        productController.addProducts(products1);
        productController.addProducts(products4);
        // end data mock
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
        // no. 1 sort method
        productController.displayProductsSortedByPrice();
        System.out.println("====================");

        System.out.println("Apakah anda ingin mencari product? (Y/N) : ");
        String doSearch = input.nextLine();

        // method & logic untuk nyari product berdasarkan nama
        if (doSearch.toLowerCase().equals("y")){
            System.out.print("Masukan nama product yang ingin dicari : ");
            String nameToSearch = input.nextLine();
            productController.findProductByName(nameToSearch);
        }

        // buat method save product ke file.


        // buat method read file product
    }
}
